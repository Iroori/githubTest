package �߻�Ŭ��������;

public class TempEmployee extends Employee {
	
	
	
	//�ʵ�

	//�޼ҵ�
	//1.������
	public TempEmployee(String empno, String name, int pay) {
		super(empno, name, pay); // �θ��� �����ڿ��� �Ű������� �޾ƿ°� �־��ֱ�
		
	}
	//2. ���޿� ��� �� ����
	public int getMoneyPay(){
	
		return  pay/12;
	}
	
	
	
	
	
}
