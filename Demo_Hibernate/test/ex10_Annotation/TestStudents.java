package ex10_Annotation;

import java.util.*;
import org.junit.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.hibernate.tool.schema.TargetType;
import util.HibernateUtil;

import bean10.t01_class.*;
import bean10.t02_filed.*;
import bean10.t03_Embedded.*;
import bean10.t04_one2one.*;
import bean10.t05_one2one_bfk.*;
import bean10.t06_many2One.*;
import bean10.t07_one2Many.*;
import bean10.t08_one2Many_bfk.*;
import bean10.t09_many2Many.*;
import bean10.t10_many2Many_bfk.*;

public class TestStudents {
	private Session session = null;

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
	public void Test01_CreateTable() {
		// 创建服务注册对象,会直接去读配置文档
		StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure()
				.build();
		Metadata metadata = new MetadataSources(serviceRegistry).buildMetadata();

		// 创建Schema,表的对象.目的是根据数据生成表
		SchemaExport schemaExport = new SchemaExport();
		schemaExport.create(EnumSet.of(TargetType.DATABASE), metadata);
	}

	@Test
	public void Test02_insert() {

		Transaction transaction = session.beginTransaction();
		// 创建学生对象
		Address address = new Address("528400", "中山市", "136000000");
		Students02 s = new Students02("S0001", "张三", "男", new Date(), "物理专业", address);
		session.save(s);
		transaction.commit();
	}

	@Test
	public void Test03_emb() {
		Transaction transaction = session.beginTransaction();
		// 创建学生对象
		Address address = new Address("528400", "中山市", "136000000");
		StudentPk pk = new StudentPk("442000000000000000", "s0000002");
		Students03 s = new Students03(pk, "张三", "男", new Date(), "物理专业", address);
		session.save(s);
		transaction.commit();

	}

	@Test
	public void Test04_one2one() {
		// 创建事务
		Transaction transaction = session.beginTransaction();
		// 创建学生对象
		IdCard card = new IdCard("442000000000000001", "张三");
		Students04 stu = new Students04(card, "男", new Date(), "武术专业");
		session.save(card);
		session.save(stu);
		transaction.commit();

	}

	@Test
	public void Test05_one2one_bfk() {
		// 创建事务
		Transaction transaction = session.beginTransaction();
		// 创建学生对象
		IdCard05 card = new IdCard05("442000000000000000", "张三");
		Students05 stu = new Students05(card, "男", new Date(), "武术专业");
		session.save(card);
		session.save(stu);
		transaction.commit();
	}

	@Test
	public void Test06_many2One() {
		// 创建事务
		Transaction transaction = session.beginTransaction();
		// 创建班级对象
		ClassRoom06 c1 = new ClassRoom06("C00001", "java一班");
		ClassRoom06 c2 = new ClassRoom06("C00002", "python一班");
		// 创建学生对象
		Students06 s1 = new Students06("张三", "男", new Date(), "软件专业");
		Students06 s2 = new Students06("李四", "男", new Date(), "软件专业");
		Students06 s3 = new Students06("王五", "女", new Date(), "软件专业");
		Students06 s4 = new Students06("赵六", "女", new Date(), "软件专业");

		// 因为是多方关联一方，所以先保存一方，多方再获取一方的信息
		session.save(c1);
		session.save(c2);

		session.save(s1);
		session.save(s2);
		session.save(s3);
		session.save(s4);

		transaction.commit();

	}

	@Test
	public void Test07_one2Many() {
		// 创建事务
		Transaction transaction = session.beginTransaction();
		// 创建班级对象
		ClassRoom07 c1 = new ClassRoom07("C00001", "java一班");
		ClassRoom07 c2 = new ClassRoom07("C00002", "python一班");
		// 创建学生对象
		Students07 s1 = new Students07("张三", "男", new Date(), "软件专业");
		Students07 s2 = new Students07("李四", "男", new Date(), "软件专业");
		Students07 s3 = new Students07("王五", "女", new Date(), "软件专业");
		Students07 s4 = new Students07("赵六", "女", new Date(), "软件专业");

		// 创建两个集合对象
		Set<Students07> set1 = new HashSet<Students07>();
		Set<Students07> set2 = new HashSet<Students07>();
		set1.add(s1);
		set1.add(s2);
		set2.add(s3);
		set2.add(s4);
		// 把学生集合放到班级中
		c1.setStudents(set1);
		c2.setStudents(set2);

		// 因为是一方关联多方，先保存学生
		session.save(s1);
		session.save(s2);
		session.save(s3);
		session.save(s4);
		// 再保存班级
		session.save(c1);
		session.save(c2);

		transaction.commit();
	}

	@Test
	public void Test08_one2Many_bfk() {
		// 创建事务
		Transaction transaction = session.beginTransaction();
		// 创建班级对象
		ClassRoom08 c1 = new ClassRoom08("C00001", "java一班");
		ClassRoom08 c2 = new ClassRoom08("C00002", "python一班");
		// 创建学生对象
		Students08 s1 = new Students08("张三", "男", new Date(), "软件专业");
		Students08 s2 = new Students08("李四", "男", new Date(), "软件专业");
		Students08 s3 = new Students08("王五", "女", new Date(), "软件专业");
		Students08 s4 = new Students08("赵六", "女", new Date(), "软件专业");

       //和上例相比，把定义集合的代码，写在javabean中，减少几行代码
//	   private Set<Students08> stu = new HashSet<Students08>();
		c1.getStu().add(s1);
		c1.getStu().add(s2);
		c2.getStu().add(s3);
		c2.getStu().add(s4);

		// 因为是双向关系，先保存哪一方都没有关系
		session.save(s1);
		session.save(s2);
		session.save(s3);
		session.save(s4);
		session.save(c1);
		session.save(c2);

		transaction.commit();
	}

	@Test
	public void Test09_many2Many() {
		// 创建事务
		Transaction transaction = session.beginTransaction();

		// 创建教师对象
		Teacher09 t1 = new Teacher09("T001", "陈老师");
		Teacher09 t2 = new Teacher09("T002", "李老师");
		Teacher09 t3 = new Teacher09("T003", "张老师");
		Teacher09 t4 = new Teacher09("T004", "王老师");

		// 创建学生对象
		Students09 s1 = new Students09("S001", "男", new Date(), "化学专业");
		Students09 s2 = new Students09("S001", "男", new Date(), "物理专业");
		Students09 s3 = new Students09("S001", "男", new Date(), "美术专业");
		Students09 s4 = new Students09("S001", "男", new Date(), "地理专业");
		// 学生s1上t1,t2的课
		s1.getTeacher().add(t1);
		s1.getTeacher().add(t2);
		// 学生s2上t3,t4的课
		s2.getTeacher().add(t3);
		s2.getTeacher().add(t4);
		// 学生s3上t3,t4的课
		s3.getTeacher().add(t1);
		s3.getTeacher().add(t3);
		s3.getTeacher().add(t4);
		// 学生s4上t3,t4的课
		s4.getTeacher().add(t2);
		s4.getTeacher().add(t3);
		s4.getTeacher().add(t4);

		session.save(t1);
		session.save(t2);
		session.save(t3);
		session.save(t4);

		session.save(s1);
		session.save(s2);
		session.save(s3);
		session.save(s4);

		transaction.commit();
	}

	@Test
	public void Test10_many2Many_bfk() {
		// 创建事务
		Transaction transaction = session.beginTransaction();

		// 创建教师对象
		Teacher10 t1 = new Teacher10("T011", "陈老师");
		Teacher10 t2 = new Teacher10("T012", "李老师");
		Teacher10 t3 = new Teacher10("T013", "张老师");
		Teacher10 t4 = new Teacher10("T014", "王老师");

		// 创建学生对象
		Students10 s1 = new Students10("S001", "男", new Date(), "化学专业");
		Students10 s2 = new Students10("S001", "男", new Date(), "物理专业");
		Students10 s3 = new Students10("S001", "男", new Date(), "美术专业");
		Students10 s4 = new Students10("S001", "男", new Date(), "地理专业");
		// 学生s1上t1,t2的课
		s1.getTeach().add(t1);
		s1.getTeach().add(t2);
		// 学生s2上t3,t4的课
		s2.getTeach().add(t3);
		s2.getTeach().add(t4);
		// 学生s3上t3,t4的课
		s3.getTeach().add(t1);
		s3.getTeach().add(t3);
		s3.getTeach().add(t4);
		// 学生s4上t3,t4的课
		s4.getTeach().add(t2);
		s4.getTeach().add(t3);
		s4.getTeach().add(t4);

		session.save(t1);
		session.save(t2);
		session.save(t3);
		session.save(t4);

		session.save(s1);
		session.save(s2);
		session.save(s3);
		session.save(s4);

		transaction.commit();
	}

}
