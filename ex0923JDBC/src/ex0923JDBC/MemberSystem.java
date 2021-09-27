package ex0923JDBC;

import java.util.ArrayList;
import java.util.Scanner;


public class MemberSystem {

	public static void main(String[] args) {
		// ȸ������, �α���, ȸ����������, ȸ����Ϻ���
		Scanner sc = new Scanner(System.in);
		MemberDAO dao = new MemberDAO();
		

		String id = new String();
		String pw = new String();
		String nick = new String();
		String phone = new String();

		boolean toggle = true;
		while (toggle) {
			System.out.print("[1]ȸ������ [2]�α��� [3]ȸ���������� [4]ȸ����Ϻ��� [5]ȸ��Ż�� [6]����");
			int select = sc.nextInt();

			switch (select) {
			case 1:
				System.out.println("--ȸ������--");
				System.out.print("ID�Է� : ");
				id = sc.next();
				System.out.print("PW�Է� : ");
				pw = sc.next();
				System.out.print("NICK �Է� : ");
				nick = sc.next();
				System.out.println("PHONE �Է� : ");
				phone = sc.next();
				
				MemberVO vo = new MemberVO(id, pw, nick, phone);
				System.out.println(vo);
				
				int cnt = dao.join(vo);
				if(cnt > 0) {
					System.out.println("ȸ������ ����");
				}else {
					System.out.println("ȸ������ ����");
				}
				break;

			case 2:
				System.out.println("--�α���--");
				System.out.print("ID�Է� : ");
				id = sc.next();
				System.out.println("PW�Է� : ");
				pw = sc.next();
				
				MemberVO vo2 = new MemberVO(id, pw); // �����ε��Ͽ� ������ �ΰ� �����
				MemberVO info = dao.login(vo2); //dao���� id��pw�� �Ѱ���� ó������
								// �α��θ޼ҵ��� ������ ���ι޾ƿ÷�? vo�̴� 4�����������ϱ� 
				if(info != null) {
					
					
					System.out.print(dao.login(vo2).getNick());
					
					System.out.println("�α��� ����");
					System.out.println(info);
				}else {
					System.out.println("�α��� ����");
				}
				break;

			case 3:
				System.out.println("--ȸ����������--");
				System.out.println("ID�Է� : ");
				id = sc.next();
				System.out.println("PW�Է� : ");
				pw = sc.next();
				System.out.print("NICK �Է� : ");
				nick = sc.next();
				System.out.println("PHONE �Է� : ");
				phone = sc.next();
				
				MemberVO vo3 = new MemberVO(id, pw, nick, phone);
				int cnt2 = dao.update(vo3);
				if(cnt2 > 0) {
					System.out.println("ȸ���������� ����");
				}else {
					System.out.println("ȸ���������� ����");
				}
				break;

			case 4:
				System.out.println("--ȸ����Ϻ���--");
				ArrayList<MemberVO> list = dao.selectAll(); // membervo�� 1�������ϱ� ���������������� �޾ƾ���
				for(int i = 0; i < list.size(); i++) {
					System.out.println(list.get(i));
				}
				
				break;

			case 5:
				System.out.println("ȸ�� Ż��");
				
				
				
				
			case 6:
				System.out.println("�����մϴ�");
				toggle = false;
				sc.close();
				break;
			}

		}

	}

}
