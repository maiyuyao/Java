package com.demo.interceptor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;
import java.util.Properties;

import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;

import com.demo.entity.Page;

/**
 * 分页拦截器
 */
//使用注解，要在处理SQLstatement之前拦截处理SQL
//mybatis源码的方法是StatementHandler，方法是prepare，表示预处理
//方法的参数是固定的，第一个参数是数据库连接
@Intercepts({ @Signature(type = StatementHandler.class, method = "prepare", args = {
		Connection.class }) })
public class PageInterceptor implements Interceptor {

	// 定义一个对象，接受从setProperties获取的，配置文件的值
	private String test;

	// 3.通过intercept方法执行拦截的逻辑
	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		// invocation是被拦截的对象，即实现StatementHandler接口的对象。此外，对象可以用接口定义。
		StatementHandler statementHandler = (StatementHandler) invocation.getTarget();

		// 当mybatis从XML生成SQL的时候，会执行StatementHandler实例的prepare，而这个方法是知道SQL的id等相关配置信息
		// 通过反射的方法，即可从statementHandler对象中获得
		MetaObject metaObject = MetaObject.forObject(statementHandler,
				SystemMetaObject.DEFAULT_OBJECT_FACTORY,
				SystemMetaObject.DEFAULT_OBJECT_WRAPPER_FACTORY);

		// StatementHandler是一个接口，有两个实现：RoutingStatementHandler，BaseStatementHandler
		// 事实上拦截到的是RoutingStatementHandler，里面有一个属性delegate，再去获取另外一个实现的属性mappedStatement
		MappedStatement mappedStatement = (MappedStatement) metaObject
				.getValue("delegate.mappedStatement");

		// 于是，终于可以获取配置文件中SQL语句的ID: queryMessageListByPage
		String id = mappedStatement.getId();
		// 符合条件的才拦截：尾缀是"ByPage"
		if (id.matches(".+ByPage$")) {
			BoundSql boundSql = statementHandler.getBoundSql();
			// 原始的SQL语句
			String sql = boundSql.getSql();

			// 查询总条数的SQL语句
			String countSql = "select count(1) from (" + sql + ") a";
			// 查询总条数的SQL要获取JDBC连接，运行
			// 拦截的第一个参数是数据库连接
			Connection connection = (Connection) invocation.getArgs()[0];
			PreparedStatement countStatement = connection.prepareStatement(countSql);

			// 此时，原始的SQL的参数是以?形式出现的，要获取参数填充
			ParameterHandler parameterHandler = (ParameterHandler) metaObject
					.getValue("delegate.parameterHandler");
			// 传入参数
			parameterHandler.setParameters(countStatement);
			// 执行总条数的查询语句，只有一条数据返回
			ResultSet rs = countStatement.executeQuery();

			// boundSql中不但有sql语句，还可以拿到page信息
			// 因为Message.xml用的是parameterType="java.util.Map"，所以类型要匹配
			Map<?, ?> parameter = (Map<?, ?>) boundSql.getParameterObject();
			Page page = (Page) parameter.get("page");
			// 总条数赋值
			if (rs.next()) {
				page.setTotalNumber(rs.getInt(1));
			}
			// 改造带分页查询的SQL语句，这是Oracle，和Mysql不一致
			String pageSql = "SELECT * FROM (SELECT t2.*, ROWNUM AS rowno FROM ( " + sql
					+ "  ) t2 WHERE ROWNUM <= " + page.getOracleEnd() + " ) t3 WHERE t3.rowno >= "
					+ page.getOracleStart();
			// 把修改后的SQL放回去
			metaObject.setValue("delegate.boundSql.sql", pageSql);
		}
		return invocation.proceed();
	}

	// 2.对拦截的对象进行过滤
	@Override
	public Object plugin(Object target) {
		System.out.println(this.test);
		return Plugin.wrap(target, this);
	}

	// 1.通过setProperties拿到配置文件里面的属性值
	@Override
	public void setProperties(Properties properties) {
		this.test = properties.getProperty("test");
	}

}
