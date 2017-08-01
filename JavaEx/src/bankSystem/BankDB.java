package bankSystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import jdbc.DBAction;

public class BankDB {

	Connection conn;
	bankSystem.DBAction db;
	public BankDB() {
		db = bankSystem.DBAction.getInstance();
	    conn = db.getConnection();
	}
	
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
	        	 BankMethod.insertnum++;
	        	 BankClientInfo bi = new BankClientInfo(id,pw,name,address,account,phone,birth);

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
	public void insertCilentData(BankClientInfo bi,int num) {

		String id = bi.getId();
		String pw = bi.getPw();
		String name = bi.getName();
		String address = bi.getAddress();
		String account = bi.getAccount();
		String phone = bi.getPhone();
		String birth = bi.getBirth();
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
			 pstmt.setInt(8, num);
	    	 pstmt.executeUpdate();
	    	 BankMethod.insertnum++;
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
	public void updateClientData(BankClientInfo bi, int num) {

		String id = bi.getId();
		String pw = bi.getPw();
		String name = bi.getName();
		String address = bi.getAddress();
		String account = bi.getAccount();
		String phone = bi.getPhone();
		String birth = bi.getBirth();
		String sql = "update bank set id=?, pw=?, name=?, address=?, account=?, phone=?, birth=? where SEQ = ?";
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
	    	  pstmt.setInt(8, num);
	    	  pstmt.executeUpdate();
	        // System.out.println("성공");
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
	
	public void deleteClientData(String id) {
		String sql = "delete from bank where id=?";
		PreparedStatement pstmt=null;
		int result= -1;
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
/*	public static void main(String[] args) {
		BankDB bd = new BankDB();
		BankClientInfo bi = new BankClientInfo("id", "pw", "name", "address", "account", "phone", "birth");
		bd.updateClientData(bi,2);
	}*/
}
