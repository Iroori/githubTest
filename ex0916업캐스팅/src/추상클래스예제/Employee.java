package 추상클래스예제;

public abstract class Employee {
	//동일한거 가져오는중
	//getMoneyPay로직은달랐엉 그냥 지워
	//추상화시키깅~
	// 접근제한자의 종류
	// public -> 같은 프로젝트 내부에서 누구나(어떤 클래스)접근가능
	// private => 나 외의 다른 클래스는 접근 불가~넝~
	// default(생략) =>같은 프로젝트 내부, 같은 패키지 안에 있는 클래스만 접근 가능
	// protected => 같은 프로젝트 내부, 같은 패키지 안에 있는 클래스 , 다른 패키지안에있지만
	//상속관계에있는 클래스 접근 가능.
	

	protected String empno;
	protected String name;
	protected int pay;
	
	public Employee(String empno, String name, int pay) {
		this.empno = empno;
		this.name = name;
		this.pay = pay;
	}

	public abstract int getMoneyPay(); 
	//식이 다 달라
	public String print() {
		return empno+ ":"+name + ":"+ pay;
	}
	
	
	
	
}
