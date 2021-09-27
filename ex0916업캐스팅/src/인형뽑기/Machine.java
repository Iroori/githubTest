package 인형뽑기;

public class Machine {
	//인형을뽑는기능(어떤인형을 뽑을 것인지 설정 역할)
	//매개변수->Pika객체
	// 로직 -> Pika객체를 활용해서 pick이라는 메소드 사용.
//	public void run(Pika pika) {
//		pika.pick();
//		
//	}
//	public void run(Kkobuk kkobuk) {
//		kkobuk.pick();
//	}
//	public void run(Pairi pairi) {
//		pairi.pick();
//	}
	public void run(Doll doll) {
		doll.pick();
	}
	
}
