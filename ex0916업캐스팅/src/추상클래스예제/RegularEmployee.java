package 추상클래스예제;

public class RegularEmployee extends Employee {
	//필드
	
	//4.보너스
	private int bonus;

	//메소드
	public RegularEmployee(String empno, String name, int pay, int bonus) {
		super(empno, name, pay);
		
	
		this.bonus = bonus;
	}
	
	//2. 월급여 계산해서 리턴
	public int getMoneyPay() { //매개변수안받기로했으니까.
		//반드시 한번은 정수형 데이터를 리턴
		//매개변수 받으라고 했을까요옹~!~! 어어.........안받을거지용~!~! ah!....?
		 
		return (pay+bonus)/12;
	}
	




}
