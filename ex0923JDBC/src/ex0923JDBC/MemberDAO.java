package ex0923JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MemberDAO {

	private Connection conn = null; // =null�� �Ƚᵵ ���������� ���۷��������� �˾Ƽ� ���̴�.
	private ResultSet rs = null; // ResultSet�� executeQuery�� ����� �޾��ִ°Ŷ�� ��������
	private PreparedStatement psmt = null;

	// PreparedStatement --> sql������ ���� �� �ִ� ����
	private void getConn() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String db_url = "jdbc:oracle:thin:@localhost:1521:xe";
			String db_id = "hr";
			String db_pw = "hr";
			conn = DriverManager.getConnection(db_url, db_id, db_pw);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace(); // exception�� �����ϸ鼭 ��� ������ �߻��ߴ��� ������ִ� ��ɾ� ���߶�������!
		}

	}

	private void close() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (psmt != null) {
				psmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int join(MemberVO vo) {
		int cnt = 0;

		getConn();
		try {

			if (conn != null) {
				System.out.println("Ŀ�ؼ� ���Ἲ��");
			} else {
				System.out.println("Ŀ�ؼ� �������");
			}
			// 3. SQL�� ����
			// psmt ��ü�� sql������ �ϼ��� �� �ְ� sql������ ������ �� �ִ�.
			String sql = "insert into big_member values(?,?,?,?)";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getId()); // ���� 12354�� ���� sql�� ����
			psmt.setString(2, vo.getPw());
			psmt.setString(3, vo.getNick());
			psmt.setString(4, vo.getPhone());
			cnt = psmt.executeUpdate(); // �� �Է� �Ǿ����� �����ϰڴٴ� �� insert update delete�� �̰� ���ϴ�
			// cnt�� ������ ������ ������ ��ƮŸ������ ������ ������ 1 ���н� 0

		} catch (SQLException e) { // SQL���� ������� �����ϱ� ��� ����
			e.printStackTrace(); // ������ �����۾� �����°� ->������ �ȶ�� ����
		} finally {

			close();
		}
		return cnt;

	}

	// ����Ÿ�� MVO �Ű����� �̰�.. ��?
	public MemberVO login(MemberVO vo) {
		MemberVO info = null; // �α��ν����ϸ� ��, �����ϸ� ���ο� ��ü����

		getConn();
		try {

			String sql = "select * from big_member where id = ? and pw = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getId());
			psmt.setString(2, vo.getPw());
			rs = psmt.executeQuery(); // select ����� �ʿ��� Ű����
			if (rs.next()) { // Ŀ�� �̵��� ���� RS������ ���ذ� �ȵȴ�
				String id = rs.getString(1); // �÷� ��ġ�� ���ȳ��� "id" �÷����� ����
				String pw = rs.getString("pw");
				String nick = rs.getString("nick");
				String phone = rs.getString(4);

				info = new MemberVO(id, pw, nick, phone);
			}

		} catch (SQLException e) {
			e.printStackTrace(); // ������ �����۾� �����°� ->������ �ȶ�� ����
		} finally {
			close();
		}

		return info;
	}

	public int update(MemberVO vo) {
		int cnt = 0;

		getConn();
		try {

			String sql = "update big_member set pw = ?, nick = ?, phone = ? where id = ? ";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getPw());
			psmt.setString(2, vo.getNick());
			psmt.setString(3, vo.getPhone());
			psmt.setString(4, vo.getId());
			cnt = psmt.executeUpdate(); // �� �Է� �Ǿ����� �����ϰڴٴ� �� insert update delete�� �̰� ���ϴ�
			// cnt�� ������ ������ ������ ��ƮŸ������ ������ ����� 1++ ���н� 0

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 4. �������� : �������� �ݾ�����ؿ�
			close();

		}

		return cnt;

	}

	public ArrayList<MemberVO> selectAll() {
		ArrayList<MemberVO> list = new ArrayList<MemberVO>();

		getConn();
		try {
			String sql = "select * from big_member";
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) { // ������� �𸣴ϱ� rs�� boolean���·ΰ��ϱ� false ���ö����� ������
				String id = rs.getString("id");
				String pw = rs.getString("pw");
				String nick = rs.getString("nick");
				String phone = rs.getString("phone");
				MemberVO vo = new MemberVO(id, pw, nick, phone);
				list.add(vo); // ����Ʈ�� vo�� ���.. �������
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return list;
	}

	public int delete(MemberVO vo) {
		int row = 0; // ���� �̸�����
		// JDBC �������
		// 1.����̹� �ε�
		// 2.Connection ��ü ����
		getConn(); // -->�ε�

		// 3.sql�� �ۼ� //���̵�� ��й�ȣ�� ��ġ�ϴ� ���� ����!
		try {
			String sql = "delete from big_member where id = ? and pw = ?";
			// 3-1. PreParedStatement--->sql������ ������ �ִ� ����
			psmt = conn.prepareStatement(sql);

			// 3-2. ?���� ä���ֱ�
			psmt.setString(1, vo.getId());

			psmt.setString(2, vo.getPw());

			// 4. sql�� ����
			// *****�ٽ�sql���� ���� ����@*****
			row = psmt.executeUpdate(); // �ٽ� ������ �ȵȴ� ��?!
			// int r => ������ ���� ���� ����
			// insert, delete,update�������� ���.

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return row;
		// finally ���� �ٳ����� ������ !
	}

}
