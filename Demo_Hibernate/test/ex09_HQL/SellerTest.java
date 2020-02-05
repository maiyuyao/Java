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


public class SellerTest {
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

	// from入门查询
	@Test
	public void test01_From() {
		String hql = " from Seller ";
		Query<Seller> query = session.createQuery(hql);
		List<Seller> sellers =  query.list();

		for (Seller seller : sellers) {
			System.out.println(seller);
		}
	}

	// 查询的是一个对象，及别名的演示
	@Test
	public void test02_Class() {
		String hql = "from bean09.Seller s ";
		Query query = session.createQuery(hql);

		List<Seller> sellers = query.list();
		for (Seller seller : sellers) {
			System.out.println("name:" + seller.getName());
		}
	}

	/*
	 * 1.name 2.tel 3.address 4.star 
	 * 如果只查询一个属性(字段)，那返回的是Object，而不是Object
	 */
	@Test
	public void test03_Object() {
		String hql = " select s.name,s.tel,s.address from Seller s ";
		Query query = session.createQuery(hql);

		List<Object[]> list = query.list();
		for (Object obj[] : list) {
			System.out.println("name:" + obj[0]);
			System.out.println("tel:" + obj[1]);
			System.out.println("address:" + obj[2]);
		}
	}

	@Test
	public void test04_List() {
		String hql = " select new list(s.name,s.tel,s.address) from Seller s ";

		Query query = session.createQuery(hql);
		List<List> lists = query.list();

		for (List list : lists) {
			System.out.println("name : " + list.get(0));
			System.out.println("tel:" + list.get(1));
			System.out.println("address:" + list.get(2));
		}
	}

	@Test
	public void test05_Map() {
		String hql = " select new map(s.name as name,s.tel,s.address) from Seller s ";
		Query query = session.createQuery(hql);

		List<Map> maps = query.list();
		for (Map map : maps) {
			//没有别名时，只能用索引值；有别名后，只能用别名。
			System.out.println("name:" + map.get("0"));
			System.out.println("name:" + map.get("name"));
			System.out.println("tel:" + map.get("tel"));
			System.out.println("address:" + map.get("2"));
		}
	}

	@Test
	public void test06_Customize() {
		String hql = " from Seller ";
		Query query = session.createQuery(hql);
		List<Seller> sellers = query.list();

		for (Seller seller : sellers) {
			System.out.println("name: " + seller.getName());
			System.out.println("tel:" + seller.getTel());
			System.out.println("address:" + seller.getAddress());
		}
	}

}
