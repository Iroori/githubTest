package 추상클래스예제;

public class Main {
	//공통점...
	//1. 필드 (사번,이름,pay)
	//2. 로직은 다른데 getMoneypay
	//3.print(로직도 똑같음)
	//4.새성자
	public static void main(String[] args) {
		
		//실행공간
		//1, RegularEmployee re
		RegularEmployee re =new RegularEmployee("SMHRD001", "홍길동", 4000, 400);
		
//		String s = re.print();
//		System.out.println(s);
//		int a= re.getMoneyPay(); //이걸 출력하고 싶으면 어떻게 하면 될까용 허허
//		System.out.println(a+"만원");
		System.out.println(re.print());
		System.out.println(re.getMoneyPay());
		//2.TempEmployee te
		TempEmployee te = new TempEmployee("Smhrd002","김운비", 3500);
		System.out.println(te.print());
		System.out.println(te.getMoneyPay());
		
		//3.PartTimeEmployee pa
		PartTimeEmployee pa = new PartTimeEmployee("SMHRD003", "김동원", 5000, 50);
		System.out.println(pa.print());
		System.out.println(pa.getMoneyPay()); //??ㅡㅡ
		
	}

}
