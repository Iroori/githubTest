package �߻�Ŭ��������;

public class Main {
	//������...
	//1. �ʵ� (���,�̸�,pay)
	//2. ������ �ٸ��� getMoneypay
	//3.print(������ �Ȱ���)
	//4.������
	public static void main(String[] args) {
		
		//�������
		//1, RegularEmployee re
		RegularEmployee re =new RegularEmployee("SMHRD001", "ȫ�浿", 4000, 400);
		
//		String s = re.print();
//		System.out.println(s);
//		int a= re.getMoneyPay(); //�̰� ����ϰ� ������ ��� �ϸ� �ɱ�� ����
//		System.out.println(a+"����");
		System.out.println(re.print());
		System.out.println(re.getMoneyPay());
		//2.TempEmployee te
		TempEmployee te = new TempEmployee("Smhrd002","����", 3500);
		System.out.println(te.print());
		System.out.println(te.getMoneyPay());
		
		//3.PartTimeEmployee pa
		PartTimeEmployee pa = new PartTimeEmployee("SMHRD003", "�赿��", 5000, 50);
		System.out.println(pa.print());
		System.out.println(pa.getMoneyPay()); //??�Ѥ�
		
	}

}
