package ex02_session;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.jdbc.Work;
import org.hibernate.service.ServiceRegistry;
import org.junit.Test;

import bean01.Student;

public class SessionTest {

	/**
	 * openSession和getCurrentSession的区别
	 * 1.OpenSession每次创建新的session对象，而getCurrentSession使用现有的。
	 * 2.getCurrentSession每次事务提交或回滚后会自动关闭，而openSession需要手工关闭；
	 */
	@Test
	public void testOpenSession() {
		// 获取配置对象
		Configuration config = new Configuration().configure();
		// 获得注册服务
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(config.getProperties()).build();
		// 创建会话工厂对象
		SessionFactory sessionFactory = config.buildSessionFactory(serviceRegistry);
		// 用openSession()创建会话对象
		Session session = sessionFactory.openSession();
		// 测试openSession()得到的是否是同一个session
		Session session2 = sessionFactory.openSession();
		System.out.println(session == session2);

		if (session != null) {
			System.out.println("session 创建成功!");
		} else {
			System.out.println("session 创建失败!");
		}
	}

	@Test
	public void testGetCurrentSession() {
		Configuration config = new Configuration().configure();
		// 获得注册服务
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(config.getProperties()).build();
		// 创建会话工厂对象
		SessionFactory sessionFactory = config.buildSessionFactory(serviceRegistry);
		// 用getCurrentSession()创建会话对象
		Session session = sessionFactory.getCurrentSession();
		Session session2 = sessionFactory.getCurrentSession();
		// 测试GetCurrentSession()得到的是否是同一个session
		System.out.println(session == session2);

		if (session != null) {
			System.out.println("session 创建成功!");
		} else {
			System.out.println("session 创建失败!");
		}
	}

	/**
	 * 测试OpenSession()
	 */
	@Test
	public void testSaveStudentWithOpenSession() {
		// 创建服务注册对象
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
		// 创建会话工厂对象
		SessionFactory sessionFactory = new MetadataSources(serviceRegistry).buildMetadata()
				.buildSessionFactory();
		// 新增第1个学生对象
		Session session1 = sessionFactory.openSession();
		Transaction transaction = session1.beginTransaction();
		Student student = new Student("张三", "男", new Date(), "北京", null);
		// 后续不关闭session，打印connection的hashCode，验证opensession是否创建新的connection。
		session1.doWork(new Work() {
			@Override
			public void execute(Connection connection) throws SQLException {
				System.out.println("connection hash code :" + connection.hashCode());
			}
		});
		//
		session1.save(student);
		transaction.commit();

		// 新增第2个学生对象
		Session session2 = sessionFactory.openSession();
		transaction = session2.beginTransaction();
		student = new Student("李四", "男", new Date(), "上海", null);

		session2.doWork(new Work() {
			@Override
			public void execute(Connection connection) throws SQLException {
				System.out.println("connection hash code :" + connection.hashCode());
			}
		});
		session2.save(student);
		transaction.commit();
	}

	/**
	 * 测试GetcurrentSession()
	 */
	@Test
	public void testSaveStudentWithGetcurrentSession() {
		// 创建服务注册对象
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
		// 创建会话工厂对象
		SessionFactory sessionFactory = new MetadataSources(serviceRegistry).buildMetadata()
				.buildSessionFactory();
		// 新增第1个学生对象
		Session session1 = sessionFactory.getCurrentSession();
		Transaction transaction = session1.beginTransaction();
		Student student = new Student("王五", "男", new Date(), "中山", null);
		// 后续不关闭session，打印connection的hashCode，验证opensession是否创建新的connection。
		session1.doWork(new Work() {
			@Override
			public void execute(Connection connection) throws SQLException {
				System.out.println("connection hash code :" + connection.hashCode());
			}
		});
		session1.save(student);
		// session1.close();
		transaction.commit();

		// 新增第2个学生对象
		Session session2 = sessionFactory.getCurrentSession();
		transaction = session2.beginTransaction();
		student = new Student("赵六", "男", new Date(), "广州", null);
		// 验证connection的连接
		session2.doWork(new Work() {
			@Override
			public void execute(Connection connection) throws SQLException {
				System.out.println("connection hash code :" + connection.hashCode());
			}
		});
		session2.save(student);
		transaction.commit();
	}
}
