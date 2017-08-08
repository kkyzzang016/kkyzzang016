package bankSystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;


public class BankDB {

	Connection conn;
	bankSystem.DBAction db;
	public BankDB() {
		db = bankSystem.DBAction.getInstance();
	    conn = db.getConnection();
	}
	//초기 전체 데이터 불러오기
	public void initCilentData() {
		String sql = "select * from bank";
	      Statement stmt = null;
	      ResultSet rs = null;
	      ResultSetMetaData rsmd = null;
	      try{
	         stmt = conn.createStatement();
	         rs = stmt.executeQuery(sql);
	         while(rs.next()) {
	        	
	        	 String id = rs.getString("id");
	        	 String pw = rs.getString("pw");
	        	 String name = rs.getString("name");
	        	 String address = rs.getString("address");
	        	 String account = rs.getString("account");
	        	 String phone = rs.getString("phone");
	        	 String birth = rs.getString("birth");
	        	 int money = rs.getInt("money");
	        	 BankClientInfo bi = new BankClientInfo(id,pw,name,address,account,phone,birth,money);

	        	 BankMethod.client.add(bi);
	        	 //System.out.println("성공");
	         }
	      }catch(SQLException e){
	         e.printStackTrace();
	      }finally {
				try {
					rs.close();
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
	      }

	}
	//클라이언트 DB추가
	public void insertCilentData(BankClientInfo bi) {

		String id = bi.getId();
		String pw = bi.getPw();
		String name = bi.getName();
		String address = bi.getAddress();
		String account = bi.getAccount();
		String phone = bi.getPhone();
		String birth = bi.getBirth();
		int money = bi.getMoney();
		String sql="insert into bank values(?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt=null;
		
	      try{
	    	 pstmt=conn.prepareStatement(sql);
	    	 pstmt.setString(1, id);
			 pstmt.setString(2, pw);
			 pstmt.setString(3, name);
			 pstmt.setString(4, address);
			 pstmt.setString(5, account);
			 pstmt.setString(6, phone);
			 pstmt.setString(7, birth);
			 pstmt.setInt(8, money);
	    	 pstmt.executeUpdate();
	      }catch(SQLException e){
	         e.printStackTrace();
	      }finally {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
	      }
	}
	//클라이언트 정보 업데이트
	public void updateClientData(BankClientInfo bi, String tid) {
		
		PreparedStatement pstmt=null;
		String id = bi.getId();
		String pw = bi.getPw();
		String name = bi.getName();
		String address = bi.getAddress();
		String account = bi.getAccount();
		String phone = bi.getPhone();
		String birth = bi.getBirth();
		int money = bi.getMoney();
		String sql = "update bank set id=?, pw=?, name=?, address=?, account=?, phone=?, birth=?, money=? where id = ?";
		//String sql="update student set name=?, java=?,jsp=?,spring=?,total=?,average=?,ban=? where num="+num;
		try{
	    	  pstmt=conn.prepareStatement(sql);
	    	  pstmt.setString(1, id);
	    	  pstmt.setString(2, pw);
	    	  pstmt.setString(3, name);
	    	  pstmt.setString(4, address);
	    	  pstmt.setString(5, account);
	    	  pstmt.setString(6, phone);
	    	  pstmt.setString(7, birth);
	    	  pstmt.setInt(8, money);
	    	  pstmt.setString(9, tid);
	    	  pstmt.executeUpdate();
	         System.out.println("성공");
	      }catch(SQLException e){
	         e.printStackTrace();
	      }finally {
				try {
					pstmt.close();
					//conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
	      }
	}
	//잔액 업데이트
public void updateMoney(BankClientInfo bi, String tid, int money) {
		
		PreparedStatement pstmt=null;
		String sql = "update bank set money=? where id = ?";
		//String sql="update student set name=?, java=?,jsp=?,spring=?,total=?,average=?,ban=? where num="+num;
		try{
	    	  pstmt=conn.prepareStatement(sql);
	    	  pstmt.setInt(1, money);
	    	  pstmt.setString(2, tid);
	    	  pstmt.executeUpdate();
	         System.out.println("성공");
	      }catch(SQLException e){
	         e.printStackTrace();
	      }finally {
				try {
					pstmt.close();
					//conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
	      }
	}
	//클라이언트 정보 삭제
	public void deleteClientData(String id) {
		String sql = "delete from bank where id=?";
		PreparedStatement pstmt=null;
		int result= -1;
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			result = pstmt.executeUpdate();
			System.out.println("성공");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
}
