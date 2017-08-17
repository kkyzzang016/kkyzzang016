<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.Context"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="java.sql.*"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%!public Connection getConnection() {
		Connection conn = null;
		try {
			InitialContext initctx = new InitialContext();
			Context ctx = (Context) initctx.lookup("java:comp/env");
			DataSource ds = (DataSource) ctx.lookup("jdbc/mysql");
			conn = ds.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<table border=1>
		<%
			String sql = "select * from bank";
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			ResultSetMetaData rsmd = null;
			int cols = 0;
			Connection conn = getConnection();
			try {
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				rsmd = rs.getMetaData();
				cols = rsmd.getColumnCount();
				while (rs.next()) {
		%>
		<tr>
			<%
				for (int i = 1; i <= cols; i++) {
			%>
			<td><%=rs.getString(i)%></td>
			<%
				}
			%>
		
		<tr>
			<%
				}
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					if (rs != null)
						rs.close();
					if (pstmt != null)
						pstmt.cancel();
					if (conn != null)
						conn.close();
				}
			%>
		
</body>
</html>