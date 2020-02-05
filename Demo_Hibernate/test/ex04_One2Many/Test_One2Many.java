package ex04_One2Many;

import java.util.Set;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import bean04.*;
import util.*;

/*
 * 单向一对多（班级--->学生）
 */
public class Test_One2Many {

	// 保存
	@Test
	public void test01_save() {
		Grade g = new Grade("Java 1班", "Java软件开发6班");
		Student stu1 = new Student("张三", "女");
		Student stu2 = new Student("李四", "男");

		// 要在学生表中添加班级的编号，需要把Student对象放进Grade对象中
		g.getStudents().add(stu1);
		g.getStudents().add(stu2);

		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		session.save(g);
		session.save(stu1);
		session.save(stu2);
		tx.commit();
		HibernateUtil.closeSession(session);
	}

	@Test
	public void test02_query() {
		Session session = HibernateUtil.getSession();
		Grade grade = (Grade) session.get(Grade.class, 6);
		System.out.println(grade.getGname() + ": " + grade.getGdesc());

		Set<Student> students = grade.getStudents();
		for (Student student : students) {
			System.out.println(student.getSname() + ": " + student.getSex());
		}
	}

	@Test
	public void test03_update() {
		// 新增新班级
		Grade grade = new Grade("java二班", "java软件开发二班");
		// 开启查询及事务
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		// 查询某学生
		Student student = session.get(Student.class, 7);
		// 把学生放进新班级中
		grade.getStudents().add(student);
		// commit
		session.save(grade);
		tx.commit();
		HibernateUtil.closeSession(session);
	}

	@Test
	public void test04_delete() {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		Student student = (Student) session.get(Student.class, 8);
		session.delete(student);
		tx.commit();
		HibernateUtil.closeSession(session);
	}
}
