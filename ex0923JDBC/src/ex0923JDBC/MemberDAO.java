package ex0923JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MemberDAO {

	private Connection conn = null; // =null을 안써도 전역변수의 레퍼런스변수는 알아서 널이다.
	private ResultSet rs = null; // ResultSet은 executeQuery의 결과값 받아주는거라고 생각하자
	private PreparedStatement psmt = null;

	// PreparedStatement --> sql구문을 담을 수 있는 공간
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
			e.printStackTrace(); // exception을 추적하면서 어디서 문제가 발생했는지 출력해주는 명령어 개발때만사요옹!
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
				System.out.println("커넥션 연결성공");
			} else {
				System.out.println("커넥션 연결실패");
			}
			// 3. SQL문 실행
			// psmt 객체가 sql문장을 완성할 수 있고 sql문장을 실행할 수 있다.
			String sql = "insert into big_member values(?,?,?,?)";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getId()); // 숫자 12354는 위에 sql의 순서
			psmt.setString(2, vo.getPw());
			psmt.setString(3, vo.getNick());
			psmt.setString(4, vo.getPhone());
			cnt = psmt.executeUpdate(); // 다 입력 되었으니 실행하겠다는 뜻 insert update delete때 이걸 씁니다
			// cnt는 실행한 문장의 갯수를 인트타입으로 돌려줌 성공시 1 실패시 0

		} catch (SQLException e) { // SQL에서 오류뜰수 있으니까 요건 냅둬
			e.printStackTrace(); // 에러시 빨간글씨 나오는거 ->없으면 안뜬다 넣자
		} finally {

			close();
		}
		return cnt;

	}

	// 리턴타입 MVO 매개변수 이거.. 왜?
	public MemberVO login(MemberVO vo) {
		MemberVO info = null; // 로그인실패하면 널, 성공하면 새로운 객체생성

		getConn();
		try {

			String sql = "select * from big_member where id = ? and pw = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getId());
			psmt.setString(2, vo.getPw());
			rs = psmt.executeQuery(); // select 실행시 필요한 키워드
			if (rs.next()) { // 커서 이동시 성공 RS개념이 이해가 안된다
				String id = rs.getString(1); // 컬럼 위치가 기억안나면 "id" 컬럼명사용 가능
				String pw = rs.getString("pw");
				String nick = rs.getString("nick");
				String phone = rs.getString(4);

				info = new MemberVO(id, pw, nick, phone);
			}

		} catch (SQLException e) {
			e.printStackTrace(); // 에러시 빨간글씨 나오는거 ->없으면 안뜬다 넣자
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
			cnt = psmt.executeUpdate(); // 다 입력 되었으니 실행하겠다는 뜻 insert update delete때 이걸 씁니다
			// cnt는 실행한 문장의 갯수를 인트타입으로 돌려줌 실행시 1++ 실패시 0

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 4. 연결종료 : 역순으로 닫아줘야해요
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
			while (rs.next()) { // 몇명인지 모르니까 rs는 boolean형태로가니까 false 나올때까지 돌린다
				String id = rs.getString("id");
				String pw = rs.getString("pw");
				String nick = rs.getString("nick");
				String phone = rs.getString("phone");
				MemberVO vo = new MemberVO(id, pw, nick, phone);
				list.add(vo); // 리스트에 vo를 담아.. 개어려워
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return list;
	}

	public int delete(MemberVO vo) {
		int row = 0; // 변수 미리지정
		// JDBC 연결과정
		// 1.드라이버 로딩
		// 2.Connection 객체 생성
		getConn(); // -->로딩

		// 3.sql문 작성 //아이디와 비밀번호가 일치하는 행을 삭제!
		try {
			String sql = "delete from big_member where id = ? and pw = ?";
			// 3-1. PreParedStatement--->sql구문을 담을수 있는 공간
			psmt = conn.prepareStatement(sql);

			// 3-2. ?인자 채워주기
			psmt.setString(1, vo.getId());

			psmt.setString(2, vo.getPw());

			// 4. sql문 전송
			// *****다시sql구문 담지 말기@*****
			row = psmt.executeUpdate(); // 다시 담으면 안된댕 왜?!
			// int r => 영향을 받은 행의 갯수
			// insert, delete,update구문에서 사용.

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return row;
		// finally 까지 다끝나고난 다음에 !
	}

}
