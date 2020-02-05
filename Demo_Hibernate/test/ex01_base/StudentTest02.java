package ex01_base;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
//import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.jdbc.Work;
import org.hibernate.service.ServiceRegistry;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import bean01.Student;

public class StudentTest02 {
	private SessionFactory sessionFactory;
	private Session session;
	// private Transaction transaction;

	@Before
	public void init() {
		// 创建服务注册对象
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
		// 创建会话工厂对象
		sessionFactory = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
		// 会话对象
		session = sessionFactory.openSession();
		// 开启事务
		// transaction = session.beginTransaction();
	}

	@After
	public void destory() {
		// 提交事物
//		  transaction.commit();
		// 关闭会话
		session.close();
		// 关闭会话工厂
		sessionFactory.close();
	}

	@Test
	public void testSaveStudents() {
		// 生成学生对象
		Student student = new Student("Dick", "男", new Date(), "地址", null);
		// 不用开启事务，自动commit
		session.doWork(new Work() {
			@Override
			public void execute(Connection connection) throws SQLException {
				connection.setAutoCommit(true);
			}
		});
		session.save(student);
		session.flush();
	}

}