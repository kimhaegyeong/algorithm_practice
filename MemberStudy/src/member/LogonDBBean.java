package member;

import java.io.PrintStream;
import java.sql.*;
import java.util.HashSet;
import javax.naming.*;
import javax.sql.DataSource;

// Referenced classes of package member:
//            LogonDataBean, ZipcodeBean

public class LogonDBBean {

	public LogonDBBean() {
	}

	public static LogonDBBean getInstance() {
		return instance;
	}

	public Connection getConnection() throws NamingException, SQLException {
		Context initCtx = new InitialContext();
		Context envCtx = (Context) initCtx.lookup("java:comp/env");
		DataSource ds = (DataSource) envCtx.lookup("jdbc/kh");
		return ds.getConnection();
	}

	public int insertMember(LogonDataBean dto) {
		int result;
		Connection con;
		PreparedStatement pstmt;
		result = 0;
		con = null;
		pstmt = null;

		try {
			con = getConnection();
			String sql = "insert into memberstudy values(?, ?, ?, ?, ?, ?, ?, ?, ?, sysdate)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPasswd());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.getJumin1());
			pstmt.setString(5, dto.getJumin2());
			pstmt.setString(6, dto.getZipcode());
			pstmt.setString(7, dto.getAddress());
			pstmt.setString(8, dto.getTel());
			pstmt.setString(9, dto.getEmail());
			result = pstmt.executeUpdate();
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return result;
	}

	public int check(String id) {
		int result;
		Connection con;
		PreparedStatement pstmt;
		ResultSet rs;
		result = 0;
		con = null;
		pstmt = null;
		rs = null;

		try {
			con = getConnection();
			String sql = "select * from memberstudy where id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next())
				result = 1;
			else
				result = 0;
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return result;
	}

	public int check(String id, String passwd) {
		int result;
		Connection con;
		PreparedStatement pstmt;
		ResultSet rs;
		result = 0;
		con = null;
		pstmt = null;
		rs = null;

		try {
			con = getConnection();
			String sql = "select * from memberstudy where id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				if (passwd.equals(rs.getString("passwd")))
					result = 1;
				else
					result = -1;
			} else {
				result = 0;
			}
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return result;
	}

	public int deleteMember(String id) {
		int result;
		Connection con;
		PreparedStatement pstmt;
		result = 0;
		con = null;
		pstmt = null;
		try {
			con = getConnection();
			String sql = "delete from memberstudy where id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			result = pstmt.executeUpdate();
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return result;
	}

	public LogonDataBean getMember(String id) {
		LogonDataBean dto;
		Connection con;
		PreparedStatement pstmt;
		ResultSet rs;
		dto = null;
		con = null;
		pstmt = null;
		rs = null;
		try {
			con = getConnection();
			String sql = "select * from memberstudy where id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				dto = new LogonDataBean();
				dto.setId(rs.getString("id"));
				dto.setPasswd(rs.getString("passwd"));
				dto.setName(rs.getString("name"));
				dto.setJumin1(rs.getString("jumin1"));
				dto.setJumin2(rs.getString("jumin2"));
				dto.setZipcode(rs.getString("zipcode"));
				dto.setAddress(rs.getString("address"));
				dto.setTel(rs.getString("tel"));
				dto.setEmail(rs.getString("email"));
				dto.setReg_date(rs.getTimestamp("reg_date"));
			}
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return dto;
	}

	public int modifyMember(LogonDataBean dto) {
		int result;
		Connection con;
		PreparedStatement pstmt;
		result = 0;
		con = null;
		pstmt = null;
		try {
			con = getConnection();
			String sql = "update memberstudy set passwd=?, tel=?, email=?, zipcode=?, address=? where id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getPasswd());
			pstmt.setString(2, dto.getTel());
			pstmt.setString(3, dto.getEmail());
			pstmt.setString(4, dto.getZipcode());
			pstmt.setString(5, dto.getAddress());
			pstmt.setString(6, dto.getId());
			result = pstmt.executeUpdate();
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return result;
	}

	public HashSet<ZipcodeBean> getZipcodes(String area) {
		HashSet<ZipcodeBean> hs;
		Connection con;
		PreparedStatement pstmt;
		ResultSet rs;
		hs = null;
		ZipcodeBean dto = null;
		con = null;
		pstmt = null;
		rs = null;
				
		try {
			con = getConnection();

			String sql = "select * from zipcode where area1=? or area2=? or area3=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, area);
			pstmt.setString(2, area);
			pstmt.setString(3, area);
			for (rs = pstmt.executeQuery(); rs.next(); hs.add(dto)) {
				if (hs == null)
					hs = new HashSet<ZipcodeBean>();
				dto = new ZipcodeBean();
				dto.setZipcode(rs.getString("zipcode"));
				dto.setArea1(rs.getString("area1"));
				dto.setArea2(rs.getString("area2"));
				dto.setArea3(rs.getString("area3"));
			}
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}  finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return hs;
	}

	private static LogonDBBean instance = new LogonDBBean();

}
