package �߻�Ŭ��������;

public abstract class Employee {
	//�����Ѱ� ����������
	//getMoneyPay�������޶��� �׳� ����
	//�߻�ȭ��Ű��~
	// ������������ ����
	// public -> ���� ������Ʈ ���ο��� ������(� Ŭ����)���ٰ���
	// private => �� ���� �ٸ� Ŭ������ ���� �Ұ�~��~
	// default(����) =>���� ������Ʈ ����, ���� ��Ű�� �ȿ� �ִ� Ŭ������ ���� ����
	// protected => ���� ������Ʈ ����, ���� ��Ű�� �ȿ� �ִ� Ŭ���� , �ٸ� ��Ű���ȿ�������
	//��Ӱ��迡�ִ� Ŭ���� ���� ����.
	

	protected String empno;
	protected String name;
	protected int pay;
	
	public Employee(String empno, String name, int pay) {
		this.empno = empno;
		this.name = name;
		this.pay = pay;
	}

	public abstract int getMoneyPay(); 
	//���� �� �޶�
	public String print() {
		return empno+ ":"+name + ":"+ pay;
	}
	
	
	
	
}
