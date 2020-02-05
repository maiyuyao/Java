package ex09_HQL;

import java.util.List;
import java.util.Map;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import bean09.*;
import util.HibernateUtil;

public class CustomerTest {
	private Session session;

	@Before
	public void setUp() throws Exception {
		// 会话对象
		session = HibernateUtil.getSession();
	}

	@After
	public void tearDown() throws Exception {
		// 关闭对话
		HibernateUtil.closeSession(session);
	}

	@Test
	public void test01_From() {
		String hql = " from Customer ";

		Query query = session.createQuery(hql);
		List<Customer> customers = query.list();

		for (Customer customer : customers) {
			System.out.println("name:" + customer.getName());
		}
	}

	@Test
	public void test02_List() {
		String hql = "select new list(c.name,c.sex,c.age,c.tel) from Customer c ";
		Query query = session.createQuery(hql);
		List<List> lists = query.list();

		for (List list : lists) {
			System.out.println("name:" + list.get(0));
			System.out.println("sex:" + list.get(1));
			System.out.println("age" + list.get(2));
			System.out.println("tel:" + list.get(3));
		}
	}

	@Test
	// 假如只有一个属性(字段)，则返回的是Object，而不是Object[]
	public void test03_Object() {
		String hql = " select c.name from Customer c ";
		Query query = session.createQuery(hql);
		List<Object> list = query.list();
		for (Object objs : list) {
			System.out.println("name:" + objs);
		}
	}

	@Test
	public void test04_Map() {
		String hql = "select new map(c.name,c.sex,c.age,c.tel ) from Customer c ";
		Query query = session.createQuery(hql);
		List<Map> maps = query.list();

		for (Map map : maps) {
			System.out.println("name:" + map.get("0"));
			System.out.println("sex:" + map.get("1"));
			System.out.println("age:" + map.get("2"));
			System.out.println("tel:" + map.get("3"));
		}
	}

	@Test
	public void test05_Distinct() {
		String hql = "select distinct c.sex from Customer c ";
		Query query = session.createQuery(hql);
		List<Object> list = query.list();

		for (Object obj : list) {
			System.out.println(obj);
		}
	}

	@Test
	public void test06_compare() {
		String hql = "  from Customer c where c.sex<>'男'";
		Query query = session.createQuery(hql);
		List<Customer> customers = query.list();

		for (Customer c : customers) {
			System.out.println("name:" + c.getName());
			System.out.println("sex:" + c.getSex());
		}
	}

	@Test
	public void test07_in() {
		String hql = " from Customer c where c.age in (20,40) ";
		Query query = session.createQuery(hql);
		List<Customer> customers = query.list();

		for (Customer c : customers) {
			System.out.println("name:" + c.getName());
			System.out.println("age:" + c.getAge());
		}
	}

	@Test
	public void test08_between() {
		String hql = " from Customer c where c.age between 20 and 40 ";
		Query query = session.createQuery(hql);
		List<Customer> customers = query.list();

		for (Customer c : customers) {
			System.out.println("name:" + c.getName());
			System.out.println("age:" + c.getAge());
		}
	}

	@Test
	public void test09_like() {
		String hql = " from Customer c where c.name like '%张%' ";
		Query query = session.createQuery(hql);
		List<Customer> customers = query.list();

		for (Customer c : customers) {
			System.out.println("name:" + c.getName());
			System.out.println("address :" + c.getAddress());
		}
	}

	@Test
	// 如果返回的是多条记录，会报错。
	public void test10_uniqueResult() {
		String hql = " from Customer where ID=1 ";
		Query query = session.createQuery(hql);
		Customer customer = (Customer) query.uniqueResult();

		System.out.println("name:" + customer.getName());
		System.out.println("age:" + customer.getAge());
	}

	@Test
	public void test11_Orderby() {
		String hql = " from Customer order by age desc ";
		Query query = session.createQuery(hql);
		List<Customer> customers = query.list();

		for (Customer c : customers) {
			System.out.println("name:" + c.getName());
			System.out.println("age:" + c.getAge());
		}
	}

}
