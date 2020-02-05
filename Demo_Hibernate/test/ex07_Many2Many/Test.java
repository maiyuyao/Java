package ex07_Many2Many;

import org.hibernate.Session;
import org.hibernate.Transaction;

import bean07.*;
import util.HibernateUtil;

/*
 * 多对多关联关系的配置
 * 同时建立了Project和Employee之间的双向多对多关联关系
 * 关联关系的维护交由Project方来处理，并且在保存Project对象时会一并保存Employee对象
 */
public class Test {
	public static void main(String[] args) {
		Project project1=new Project(1003,"项目-3");
		Project project2=new Project(1004,"项目-4");
		Employee employee1=new Employee(4,"Kevin");
		Employee employee2=new Employee(5,"Melody");
		Employee employee3=new Employee(6,"Peter");
		
		//参加项目1的员工有:Nicole,Paul
		project1.getEmployees().add(employee1);
		project1.getEmployees().add(employee2);
		project1.getEmployees().add(employee3);
		// 参加项目2的员工有:Nicole
		project2.getEmployees().add(employee1);
		
		Session session=HibernateUtil.getSession();
		Transaction tx=session.beginTransaction();
		session.save(project1);
		session.save(project2);
		tx.commit();
		HibernateUtil.closeSession(session);
	}
}
