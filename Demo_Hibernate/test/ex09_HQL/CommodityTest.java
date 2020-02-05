package ex09_HQL;

import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import bean09.*;
import util.HibernateUtil;

public class CommodityTest {
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
	public void test01_cascade() {
		String hql = " from Commodity ";

		Query query = session.createQuery(hql);
		List<Commodity> commodities = query.list();

		for (Commodity c : commodities) {
			System.out.print("Commodity's name:" + c.getName() + " >> ");
			//如果不打印Seller，就不会执行Seller的SQL
			System.out.println("Seller's name :" + c.getSeller().getName());
		}
	}

	@Test
	public void test02_compare() {
		String hql = " from Commodity c where c.price<=40 ";
		Query query = session.createQuery(hql);
		List<Commodity> commodities = query.list();

		for (Commodity c : commodities) {
			System.out.println("name:" + c.getName());
			System.out.println("price:" + c.getPrice());
		}
	}
	
	@Test
	public void test03_null() {
		String hql = " from Commodity c where c.description= null ";
		Query query = session.createQuery(hql);
		List<Commodity> commodities = query.list();

		for (Commodity c : commodities) {
			System.out.println("name:" + c.getName());
			System.out.println("price:" + c.getPrice());
		}
	}
	
 

	@Test
	public void test04_Logic() {
		String hql = " from Commodity c where c.price between 1000 and 5000 and c.category like '%书%' or name like '%电_' ";
		Query query = session.createQuery(hql);
		List<Commodity> commodities = query.list();

		for (Commodity c : commodities) {
			System.out.println("name:" + c.getName());
			System.out.println("category:" + c.getCategory());
			System.out.println("price:" + c.getPrice());
		}
	}


	@Test
	public void test05_operations() {
		String hql = " from Commodity c where c.price*5>3000 ";
		Query query = session.createQuery(hql);
		List<Commodity> commodities = query.list();

		for (Commodity c : commodities) {
			System.out.println("name:" + c.getName());
			System.out.println("price:" + c.getPrice() * 5);
		}
	}

	@Test
	public void test06_Orderby() {
		String hql = " from Commodity order by seller.id asc,price desc,name asc  ";
		Query query = session.createQuery(hql);
		List<Commodity> commodities = query.list();

		for (Commodity c : commodities) {
			System.out.println("name:" + c.getName());
			System.out.println("price:" + c.getPrice());
		}
	}

}
