package �߻�Ŭ��������;

public class PartTimeEmployee extends Employee {
	
	//�ʵ�
	
	private int workDay;
	
	//�޼ҵ�
	public PartTimeEmployee(String empno, String name, int pay, int workDay) {
		super(empno,name,pay); //dj?...��?.. 
		this.workDay = workDay;
	}
	
	public int getMoneyPay() {
		return pay * workDay;
	}
	
	
	
}
