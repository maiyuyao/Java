package ex03_attr;

import java.io.*;
import java.sql.Blob;
import java.util.Date;

import org.hibernate.*;
import org.hibernate.boot.*;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;
import org.junit.*;

import bean01.*;

public class StudentTest {
	private SessionFactory sessionFactory;
	private Session session;
	private Transaction transaction;

	@Before
	public void init() {
		// 创建服务注册对象,会直接去读配置文档
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
		// 创建会话工厂对象
		sessionFactory = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
		// 会话对象
		session = sessionFactory.openSession();
		// 开启事物
		transaction = session.beginTransaction();
	}

	@After
	public void destory() {
		// 提交事物
		transaction.commit();
		// 关闭会话
		session.close();
		// 关闭会话工厂
		sessionFactory.close();
	}

	@Test
	public void test01_SaveStudent() {
		// 生成学生对象
		Student s = new Student();
		s.setSname("张三");
		s.setGender("男");
		s.setBirthday(new Date());
		s.setAddress("中山市");
		session.save(s);
	}

	@Test
	public void test02_writeBlob() throws Exception {
		Student s = new Student("张三", "男", new Date(), "中山市",null);
		File f = new File("D:\\Collection\\Image\\1.jpg");
		InputStream input = new FileInputStream(f);
		//createBlob(从哪里读取，输入流的最大长度)
		Blob image = Hibernate.getLobCreator(session).createBlob(input, input.available());
		s.setPicture(image);
		session.save(s);
	}

	@Test
	public void test03_ReadBlob() throws Exception {
		Student student = session.get(Student.class, 24);
		// 获得Blob对象
		Blob image = student.getPicture();
		// 获得照片输入流
		InputStream inputStream = image.getBinaryStream();
		// 创建输出流
		File file = new File("D:"+File.separator+"Collection"+File.separator+"Image"+File.separator+"test.jpg");
		// 获得输出流
		OutputStream outputStream = new FileOutputStream(file);
		// 创建缓冲区
		byte[] buff = new byte[inputStream.available()];
		@SuppressWarnings("unused")
		int out;
		while ((out = inputStream.read(buff)) != -1) {
			outputStream.write(buff);
		}
		inputStream.close();
		outputStream.close();
	}

	@Test
	public void test04_SaveStudent_com() {
		// 生成学生对象
		Student_comp student_com = new Student_comp();
		student_com.setSname("张三");
		student_com.setGender("男");
		student_com.setBirthday(new Date());
		Address address =new Address("528400","0760","中山市");
		student_com.setAddress(address);
		session.save(student_com);
	}
	
	
	//session.get马上发送SQL语句，找不到返回null
	@Test
	public void test05_getStudent() throws Exception {
		Student_comp s = (Student_comp) session.get(Student_comp.class, 2);
		System.out.println(s);
	}
	
	
	//session.load当用到这个对象时才发送SQL，找不到返回异常
	@Test
	public void test06_loadStudent() throws Exception {
		Student_comp s = (Student_comp) session.load(Student_comp.class, 2);
		System.out.println(s);
	}
	
	@Test
	public void test07_updateStudent() throws Exception {
		Student_comp s = (Student_comp) session.get(Student_comp.class, 2);
		s.setGender("女");
		session.update(s);
	}
	
	@Test
	public void test08_delStudent() throws Exception {
		Student_comp s = (Student_comp) session.get(Student_comp.class, 1);
		session.delete(s);
	}

}