package ex05_Many2One;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import bean05.*;
import util.HibernateUtil;

public class Test_Many2One {
	// 保存
	@Test
	public void save() {
		Grade g = new Grade("Java 5班", "Java软件开发5班");
		Student stu1 = new Student("Bruce", "男");
		Student stu2 = new Student("Gloria", "女");

		// 设定关联关系
		stu1.setGrade(g);
		stu2.setGrade(g);
		
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		session.save(g);
		session.save(stu1);
		session.save(stu2);
		tx.commit();
		HibernateUtil.closeSession(session);
	}
}
