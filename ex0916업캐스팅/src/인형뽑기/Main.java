package 인형뽑기;

public class Main {

	public static void main(String[] args) {
		
		//인형뽑기 기계를 활용해서 인형을 뽑겠습니다.
		//인형뽑기 기계(Machine)를 활용
		Machine m = new Machine();
		
		//피카츄 인형 뽑기
		Pika pika = new Pika();
		
		m.run(pika);
		
		//꼬부기인형, 파이리 인형 뽑아주세요.
		
		Kkobuk kkobuk = new Kkobuk();
		
		m.run(kkobuk);
		
		Pairi pairi = new Pairi();
		m.run(pairi);
		
		
		
		
		//추상클래스의 특징
		// 객체를 생성할 수 없다.
		//Doll d 객체 생성
		//	Doll d = new Doll();
		
		
	}

}
