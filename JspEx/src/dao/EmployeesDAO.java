package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.EmployeesBean;
import bean.UserInfo;
import db.DBAction;
import oracle.sql.CHAR;

public class EmployeesDAO {
	
	private static EmployeesDAO instance = new EmployeesDAO();
	
	public static EmployeesDAO getInstance() {
	      return instance;
	   }
	
	 public Connection getConnection() {
	      DBAction db = DBAction.getInstance();
	      return db.getConnection();
	   }

	   public int insertMember(EmployeesBean ui) {
	      int result = -1;
	      String sql = "insert into employees(id, pass, name, lev, enter, gender, phone) values(?, ?, ?, ?, ?, ?, ?)";
	      Connection conn = getConnection();
	      PreparedStatement pstmt = null;
	      try {
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setString(1, ui.getId());
	         pstmt.setString(2, ui.getPass());
	         pstmt.setString(3, ui.getName().trim());
	         pstmt.setString(4, String.valueOf(ui.getLev()));
	         pstmt.setString(5, String.valueOf(ui.getEnter()));
	         pstmt.setString(6, String.valueOf(ui.getGender()));
	         pstmt.setString(7, ui.getPhone());

	         result = pstmt.executeUpdate();
	      } catch (SQLException e) {
	         // TODO: handle exception
	         e.printStackTrace();
	      } /*finally {
	         try {
	            if (pstmt != null)
	               pstmt.close();
	            if (conn != null)
	               conn.close();
	         } catch (SQLException e) {
	            e.printStackTrace();
	         }
	      }*/
	      String msg = result > 0 ? "success" : "fail";
	      return result;
	   }

	   public int userCheck(String id, String pass) {
		   int result = -1;
		   
		   String sql = "select id, name, pass from employees where id=?";
		   Connection conn = getConnection();
		   PreparedStatement pstmt =null;
		   
		   try {
			pstmt= conn.prepareStatement(sql);
			pstmt.setString(1, id.trim());
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				if(rs.getString("pass").equals(pass.trim())) {
					result = 1;
				}else{
					result = -1;//pass fail
				}
			}else {	
				result = -1;//id fail
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   return result;
	   }
	   public EmployeesBean getMember(String id) {
		   EmployeesBean ui = null;
		   String sql = "select * from employees where id=?";
		   Connection conn = null;
		   PreparedStatement pstmt = null;
		   ResultSet rs = null;
		   
		   try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				ui = new EmployeesBean();
				ui.setId(rs.getString("id"));
				ui.setPass(rs.getString("pass"));
				ui.setName(rs.getString("name"));
				ui.setLev(rs.getString("lev").charAt(0));
				ui.setEnter(rs.getDate("enter"));
				ui.setGender(rs.getString("gender").charAt(0));
				ui.setPhone(rs.getString("phone"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		   return ui;
	   }
	   
}
