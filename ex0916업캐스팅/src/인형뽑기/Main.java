package �����̱�;

public class Main {

	public static void main(String[] args) {
		
		//�����̱� ��踦 Ȱ���ؼ� ������ �̰ڽ��ϴ�.
		//�����̱� ���(Machine)�� Ȱ��
		Machine m = new Machine();
		
		//��ī�� ���� �̱�
		Pika pika = new Pika();
		
		m.run(pika);
		
		//���α�����, ���̸� ���� �̾��ּ���.
		
		Kkobuk kkobuk = new Kkobuk();
		
		m.run(kkobuk);
		
		Pairi pairi = new Pairi();
		m.run(pairi);
		
		
		
		
		//�߻�Ŭ������ Ư¡
		// ��ü�� ������ �� ����.
		//Doll d ��ü ����
		//	Doll d = new Doll();
		
		
	}

}
