package �߻�Ŭ��������;

public class RegularEmployee extends Employee {
	//�ʵ�
	
	//4.���ʽ�
	private int bonus;

	//�޼ҵ�
	public RegularEmployee(String empno, String name, int pay, int bonus) {
		super(empno, name, pay);
		
	
		this.bonus = bonus;
	}
	
	//2. ���޿� ����ؼ� ����
	public int getMoneyPay() { //�Ű������ȹޱ�������ϱ�.
		//�ݵ�� �ѹ��� ������ �����͸� ����
		//�Ű����� ������� ��������~!~! ���.........�ȹ���������~!~! ah!....?
		 
		return (pay+bonus)/12;
	}
	




}
