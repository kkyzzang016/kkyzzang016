package board_dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import board_dto.BoardVO;

public class BoardDAO {
	
	private static BoardDAO instance = new BoardDAO();
	
	private BoardDAO() {
		super();
	}
	
	public static BoardDAO getInstance() {
		return instance;
	}
	
	public List<BoardVO> selectAllBoards(){
		
		String sql = "select * from board order by num desc";
		
		List<BoardVO> list = new ArrayList<BoardVO>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
		conn = DBManager.getConnection();
		stmt = conn.createStatement();
		rs = stmt.executeQuery(sql);
		while(rs.next()) {
			BoardVO bVo = new BoardVO();
			bVo.setNum(rs.getInt("num"));
			bVo.setName(rs.getString("name"));
			bVo.setEmail(rs.getString("email"));
			bVo.setPass(rs.getString("pass"));
			bVo.setTitle(rs.getString("title"));
			bVo.setContent(rs.getString("content"));
			bVo.setReadcount(rs.getInt("readcount"));
			bVo.setWritedate(rs.getTimestamp("writedate"));
			list.add(bVo);
		}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn,stmt,rs);
		}
		
		return list;
	}
}
