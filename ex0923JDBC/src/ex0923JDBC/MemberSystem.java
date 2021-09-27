package ex0923JDBC;

import java.util.ArrayList;
import java.util.Scanner;


public class MemberSystem {

	public static void main(String[] args) {
		// 회원가입, 로그인, 회원정보수정, 회원목록보기
		Scanner sc = new Scanner(System.in);
		MemberDAO dao = new MemberDAO();
		

		String id = new String();
		String pw = new String();
		String nick = new String();
		String phone = new String();

		boolean toggle = true;
		while (toggle) {
			System.out.print("[1]회원가입 [2]로그인 [3]회원정보수정 [4]회원목록보기 [5]회원탈퇴 [6]종료");
			int select = sc.nextInt();

			switch (select) {
			case 1:
				System.out.println("--회원가입--");
				System.out.print("ID입력 : ");
				id = sc.next();
				System.out.print("PW입력 : ");
				pw = sc.next();
				System.out.print("NICK 입력 : ");
				nick = sc.next();
				System.out.println("PHONE 입력 : ");
				phone = sc.next();
				
				MemberVO vo = new MemberVO(id, pw, nick, phone);
				System.out.println(vo);
				
				int cnt = dao.join(vo);
				if(cnt > 0) {
					System.out.println("회원가입 성공");
				}else {
					System.out.println("회원가입 실패");
				}
				break;

			case 2:
				System.out.println("--로그인--");
				System.out.print("ID입력 : ");
				id = sc.next();
				System.out.println("PW입력 : ");
				pw = sc.next();
				
				MemberVO vo2 = new MemberVO(id, pw); // 오버로딩하여 생성자 두개 만들어
				MemberVO info = dao.login(vo2); //dao한테 id랑pw를 넘겨줘야 처리하지
								// 로그인메소드의 리턴은 뭘로받아올래? vo이다 4개정보있으니까 
				if(info != null) {
					
					
					System.out.print(dao.login(vo2).getNick());
					
					System.out.println("로그인 성공");
					System.out.println(info);
				}else {
					System.out.println("로그인 실패");
				}
				break;

			case 3:
				System.out.println("--회원정보수정--");
				System.out.println("ID입력 : ");
				id = sc.next();
				System.out.println("PW입력 : ");
				pw = sc.next();
				System.out.print("NICK 입력 : ");
				nick = sc.next();
				System.out.println("PHONE 입력 : ");
				phone = sc.next();
				
				MemberVO vo3 = new MemberVO(id, pw, nick, phone);
				int cnt2 = dao.update(vo3);
				if(cnt2 > 0) {
					System.out.println("회원정보수정 성공");
				}else {
					System.out.println("회원정보수정 실패");
				}
				break;

			case 4:
				System.out.println("--회원목록보기--");
				ArrayList<MemberVO> list = dao.selectAll(); // membervo가 1명정보니까 여러개묶인정보로 받아야함
				for(int i = 0; i < list.size(); i++) {
					System.out.println(list.get(i));
				}
				
				break;

			case 5:
				System.out.println("회원 탈퇴");
				
				
				
				
			case 6:
				System.out.println("종료합니다");
				toggle = false;
				sc.close();
				break;
			}

		}

	}

}
