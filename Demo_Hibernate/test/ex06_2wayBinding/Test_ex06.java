package ex06_2wayBinding;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import bean06.*;
import util.HibernateUtil;

public class Test_ex06{

	// 保存
	@Test
	public void test01_save() {
		Grade grade = new Grade("ex06班", ".net开发 2班");
		Student student1 = new Student("Charles", "男");
		Student student2 = new Student("Doris", "女");

		// 同时建立一对多和多对以的关联关系
		grade.getStudents().add(student1);
		grade.getStudents().add(student2);

		// 即使grade设置了cascade，也要把grade放进student中，否则student找不到grade的ID。
		student1.setGrade(grade);
		student2.setGrade(grade);

		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		session.save(grade);
		// 在grade设置了cascade，可以不用保存student，直接保存grade。
		// session.save(student1);
		// session.save(student2);
		tx.commit();
		HibernateUtil.closeSession(session);
	}
	
	@Test
	public void test02_query(){
		Session session=HibernateUtil.getSession();
		
		Student student = session.get(Student.class, 14);
		System.out.println(student.getSid()+", "+student.getSname());
		
		Grade grade =student.getGrade();
		System.out.println(grade.getGname()+", "+grade.getGdesc());
	}

}
