package board_dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import board_dto.BoardVO;
import util.DBManager;

public class BoardDAO {

   private BoardDAO() {

   }

   private static BoardDAO instance = new BoardDAO();

   public static BoardDAO getInstance() {
      return instance;
   }

   public List<BoardVO> selectAllBoards() {
      String sql = "select * from board order by num desc";
      List<BoardVO> list = new ArrayList<BoardVO>();
      Connection conn = null;
      Statement stmt = null;
      ResultSet rs = null;
      try {
         conn = DBManager.getConnection();
         stmt = (Statement) conn.createStatement();
         rs = stmt.executeQuery(sql);
         while (rs.next()) {
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
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         DBManager.close(conn, stmt, rs);
      }
      return list;
   }
   
   public void insertBoard(BoardVO bVo) {
      String sql = "insert into board(name, email, pass, title, content) values(?, ?, ?, ?, ?)";
      Connection conn = null;
      PreparedStatement pstmt = null;
      try {
         conn = DBManager.getConnection();
         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, bVo.getName());
         pstmt.setString(2, bVo.getEmail());
         pstmt.setString(3, bVo.getPass());
         pstmt.setString(4, bVo.getTitle());
         pstmt.setString(5, bVo.getContent());
         pstmt.executeUpdate();
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         DBManager.close(conn, pstmt);
      }
   }
   
   public void updateReadCount(String num) {
      // TODO Auto-generated method stub
      String sql = "update board set readcount=readcount+1 where num=?";

      Connection conn = null;
      PreparedStatement pstmt = null;
      try {
         conn = DBManager.getConnection();
         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, num);
         pstmt.executeUpdate();
      } catch (Exception e) {
         // TODO: handle exception
         e.printStackTrace();
      } finally {
         DBManager.close(conn, pstmt);
      }

   }

   // 게시판 글 상세 내용 보기 : 글번호로 찾아온다. : 실패 null,
   public BoardVO selectOneBoardByNum(String num) {
      // TODO Auto-generated method stub
      String sql = "select * from board where num=?";

      BoardVO bVo = null;
      Connection conn = null;
      PreparedStatement pstmt = null;
      ResultSet rs = null;

      try {
         conn = DBManager.getConnection();
         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, num);
         rs = pstmt.executeQuery();
         if (rs.next()) {
            bVo = new BoardVO();
            bVo.setNum(rs.getInt("num"));
            bVo.setName(rs.getString("name"));
            bVo.setPass(rs.getString("pass"));
            bVo.setEmail(rs.getString("email"));
            bVo.setTitle(rs.getString("title"));
            bVo.setContent(rs.getString("content"));
            bVo.setWritedate(rs.getTimestamp("writedate"));
            bVo.setReadcount(rs.getInt("readcount"));
         }

      } catch (Exception e) {

         e.printStackTrace();
      } finally {
         DBManager.close(conn, pstmt, rs);
      }
      return bVo;
   }
   
   public void updateBoard(BoardVO bVo) {
      // TODO Auto-generated method stub
      String sql = "update board set name=?, email=?, pass=?, title=?, content=? where num=?";
      Connection conn = null;
      PreparedStatement pstmt = null;
      try {
         conn = DBManager.getConnection();
         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, bVo.getPass());
         pstmt.setString(2, bVo.getName());
         pstmt.setString(3, bVo.getEmail());
         pstmt.setString(4, bVo.getTitle());
         pstmt.setString(5, bVo.getContent());
         pstmt.setInt(6, bVo.getNum());
         pstmt.executeUpdate();
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         DBManager.close(conn, pstmt);
      }
   }
   
   
   public BoardVO checkPassWord(String pass, String num) {
      String sql = "select * from board where pass=? and num=?";
      
      Connection conn = null;
      PreparedStatement pstmt = null;
      ResultSet rs = null;
      BoardVO bVo = null;
      try {
         conn = DBManager.getConnection();
         pstmt = conn.prepareStatement(sql);
         
         pstmt.setString(1, pass);
         pstmt.setString(2, num);
         
         rs = pstmt.executeQuery();
         
         if(rs.next()) {
            bVo = new BoardVO();
            bVo.setNum(rs.getInt("num"));
            bVo.setName(rs.getString("name"));
            bVo.setEmail(rs.getString("email"));
            bVo.setPass(rs.getString("pass"));
            bVo.setTitle(rs.getString("title"));
            bVo.setContent(rs.getString("content"));
            bVo.setReadcount(rs.getInt("readcount"));
            bVo.setWritedate(rs.getTimestamp("writedate"));
         }
      }catch(SQLException e) {
         e.printStackTrace();
      }
      return bVo;
   }
   

   public void deleteBoard(String num) {
      String sql = "delete from board where num=?";
      // delete 삭제한다 boardtest1 테이블을 조건은 num에 일치하는 값만

      Connection conn = null;
      PreparedStatement pstmt = null;
      try {
         conn = DBManager.getConnection();
         pstmt = conn.prepareStatement(sql);

         pstmt.setString(1, num);

         pstmt.executeUpdate();// DB의 값이 변동/삭제 되기 때문에 executeUpdate를 사용
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         DBManager.close(conn, pstmt);
      }
   }
}