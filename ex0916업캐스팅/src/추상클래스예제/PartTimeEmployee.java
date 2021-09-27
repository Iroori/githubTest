package 추상클래스예제;

public class PartTimeEmployee extends Employee {
	
	//필드
	
	private int workDay;
	
	//메소드
	public PartTimeEmployee(String empno, String name, int pay, int workDay) {
		super(empno,name,pay); //dj?...어?.. 
		this.workDay = workDay;
	}
	
	public int getMoneyPay() {
		return pay * workDay;
	}
	
	
	
}
