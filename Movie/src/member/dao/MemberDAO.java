package member.dao;

import static db.JdbcUtil.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import member.vo.MemberBean;

public class MemberDAO {
		private static MemberDAO instance = new MemberDAO();
		
		private MemberDAO() {}

		public static MemberDAO getInstance() {
			return instance;
		};
		
		// ------------------------------------------
		Connection con;

		public void setConnection(Connection con) {
			this.con = con;
		}

		// 로그인 
		public int login(MemberBean member) {

			int isLogin = 0;
			
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				
				String sql ="SELECT pass FROM member WHERE email=?";
				pstmt = con.prepareStatement(sql);
				rs=pstmt.executeQuery();
				
				if(rs.next()) { // 이메일이 존재할 경우
					if(member.getPass().equals(rs.getString("pass"))) {
						isLogin=1;
					}else { // 패스워드가 일치하지 않을 경우
						isLogin=-1;
					}
				}else {
					isLogin=0;
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Member.dao - 오류!");
			}finally {
				close(rs);
				close(pstmt);
			}
			
			return isLogin;
		}
		
		
		
}
