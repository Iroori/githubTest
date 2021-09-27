package 추상클래스예제;

public class TempEmployee extends Employee {
	
	
	
	//필드

	//메소드
	//1.생성자
	public TempEmployee(String empno, String name, int pay) {
		super(empno, name, pay); // 부모의 생성자에서 매개변수로 받아온거 넣어주깅
		
	}
	//2. 월급여 계산 후 리턴
	public int getMoneyPay(){
	
		return  pay/12;
	}
	
	
	
	
	
}
