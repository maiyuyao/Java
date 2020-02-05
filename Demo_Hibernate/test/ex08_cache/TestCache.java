package ex08_cache;

import java.util.Iterator;
import java.util.List;

import javax.net.ssl.SSLException;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Test;

import bean07.*;
import util.HibernateUtil;

public class TestCache {

	@Test
	public void Test01() {
		// 开启Session
		Session session = HibernateUtil.getSession();
		// 第一次查询
		Employee employee = (Employee) session.get(Employee.class, 1);
		System.out.println(employee.getEmpname());
		
		// 第二次查询
		employee = (Employee) session.get(Employee.class, 1);
		System.out.println(employee.getEmpname());

		session.close();
	}

	@Test
	public void Test02() {
		Session session = HibernateUtil.getSession();
		Employee employee = (Employee) session.get(Employee.class, 1);
		System.out.println(employee.getEmpname());

		// evict方法清除一级缓存中的指定对象
		//session.evict(employee);
		// clear方法清空session中的所有内容
		  session.clear();

		employee = (Employee) session.get(Employee.class, 1);
		System.out.println(employee.getEmpname());

		session.close();
	}

	@Test
	public void Test03() {
		Session session = HibernateUtil.getSession();

		Query query = session.createQuery("from Employee");
		List<Employee> list = query.list();
		for (Employee employee : list) {
			System.out.println(employee.getEmpname());
		}

		list = query.list();
		for (Employee employee : list) {
			System.out.println(employee.getEmpname());
		}
		session.close();
	}

	@Test
	public void Test04() {
		Session session = HibernateUtil.getSession();

		Query query = session.createQuery("from Employee");
		List<Employee> list = query.list();
		for (Employee employee : list) {
			System.out.println(employee.getEmpname());
		}

		Iterator iterator = query.iterate();
		while (iterator.hasNext()) {
			Employee employee = (Employee) iterator.next();
			System.out.println(employee.getEmpname());
		}

		session.close();
	}
	
	
	@Test
	public void Test05() {
		Session session = HibernateUtil.getSession();

		Query query = session.createQuery("from Employee");
		Iterator iterator = query.iterate();
		while (iterator.hasNext()) {
			Employee employee = (Employee) iterator.next();
			System.out.println(employee.getEmpname());
		}
		
		session.close();
	}

}
