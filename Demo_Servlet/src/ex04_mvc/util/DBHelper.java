package ex04_mvc.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBHelper {

	// �������ݿ��URL��ַ
	private static final String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	private static final String username = "DEMO";// ���ݿ���û���
	private static final String password = "DEMO";// ���ݿ������

	private static Connection conn = null;

	// ��̬����鸺���������
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");// ���ݿ�����
			System.out.println("���ݿ��������سɹ�");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	// ����ģʽ�������ݿ����Ӷ���
	public static Connection getConnection() throws Exception {
		if (conn == null) {
			conn = DriverManager.getConnection(url, username, password);
			return conn;
		}
		return conn;
	}

	public static void main(String[] args) {

		try {
			Connection conn = DBHelper.getConnection();
			if (conn != null) {
				System.out.println("���ݿ�����������");
			} else {
				System.out.println("���ݿ������쳣��");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}
}
