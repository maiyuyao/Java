package ex09_HQL;


import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import bean09.*;
import util.HibernateUtil;

public class OrderTest {
	private Session session = null;
	
	@Test
	public void test01_collection(){
		String hql = " from Order o where o.orderItems is not empty ";
		Query query = session.createQuery(hql);
		List<Order> orders = query.list();
		
		for(Order order : orders){
			//System.out.println(order.getCustomer().getName());
			System.out.println(order.getAmount());
			System.out.println(order.getTradeDate());
		}
	}

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
}
