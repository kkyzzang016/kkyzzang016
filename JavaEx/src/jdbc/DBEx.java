package jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
		  데이터 (Data)
		  	수집된 사실이나 값이 정형화되고 기록될만한 가치가 있다고 판단되는 현실세계의 어떤 현상이나 사건에 대한 구체적인 묘사
		  	
		  DB(DataBase)
		  	어느 한 조직의 여러 응용시스템들이 공용할 수 있도록 통합. 저장된 운영 데이터의 집합
		  	(통합된 데이터, 저장된 데이터, 운영 데이터, 공용 데이터)
		  	
		  	
		  자바에서의 DB를 사용하기(JDBC)
		  	-JDBC(Java Database Connectivity)는 자바에서 데이터베이스에 접속할 수 있도록 하는 자바 API이다.
		  	-JDBC는 데이터베이스에서 자료를 쿼리하거나 업데이트하는 방법을 제공한다.
		  	-JDBC는 데이터베이스 질의문을 실행하여 관계형 데이터베이스(relational database)의 데이터를 검색, 갱신하는 방법을 제공합니다.
		  	
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
