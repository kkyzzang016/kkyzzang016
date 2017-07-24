package jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
		  ������ (Data)
		  	������ ����̳� ���� ����ȭ�ǰ� ��ϵɸ��� ��ġ�� �ִٰ� �ǴܵǴ� ���Ǽ����� � �����̳� ��ǿ� ���� ��ü���� ����
		  	
		  DB(DataBase)
		  	��� �� ������ ���� ����ý��۵��� ������ �� �ֵ��� ����. ����� � �������� ����
		  	(���յ� ������, ����� ������, � ������, ���� ������)
		  	
		  	
		  �ڹٿ����� DB�� ����ϱ�(JDBC)
		  	-JDBC(Java Database Connectivity)�� �ڹٿ��� �����ͺ��̽��� ������ �� �ֵ��� �ϴ� �ڹ� API�̴�.
		  	-JDBC�� �����ͺ��̽����� �ڷḦ �����ϰų� ������Ʈ�ϴ� ����� �����Ѵ�.
		  	-JDBC�� �����ͺ��̽� ���ǹ��� �����Ͽ� ������ �����ͺ��̽�(relational database)�� �����͸� �˻�, �����ϴ� ����� �����մϴ�.
		  	
		  	DDL =  data definition language
		  	DML = data modify language
		  	DCL = data control language
		 */




		/*   ORACLE
		 * try {
			//Driver Loading
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver Successful ");

			//DB Connection
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin://localhost:1521:orcl", "user", "pw");
			System.out.println("Connection Successful ");
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		 */
public class DBEx {

	public DBEx() {
		String user = "root";
		String pw = "oracle";
		try {
			//Driver Loading
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver Successful ");

			//DB Connection
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306",user,pw);
			System.out.println("Connection Successful ");
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e1) {
			e1.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new DBEx();
	}
}
