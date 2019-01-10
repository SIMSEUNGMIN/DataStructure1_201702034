
public enum ListOrder {
	//�̹� ���迡���� 3���� ������ ������ ����Ʈ�� �����ϰ� �ִ�.
	//�� ������ ǥ���� �������� Enum "ListOrder"�� ����Ѵ�.
	
	Ascending, //�������� ������ ����Ʈ�� ������ ǥ��.
	Descending, //�������� ������ ����Ʈ�� ������ ǥ��.
	Random; //������ ������ ����Ʈ�� ������ ǥ��.
	
	//���� Enum�� Ŭ������ Ư���� ���.
	//�Ʒ��� ���� ����� ������ �� �ִ�.
	
	public static final String[] ORDER_NAMES = {"��������", "��������", "������"};
	
	//���� �Ʒ��� ���� member method ���� ������ �� �ִ�.
	//��, Enum �ȿ� ����� ������ Enum�� ��ü �ν��Ͻ��� �νĵȴ�.
	//Ascending, Descending, Random ������ ��ü �ν��Ͻ��̴�.
	
	public String orderName(){
		return ListOrder.ORDER_NAMES[this.ordinal()];
		//ordinal()�� ��� Enum�� �̸� ���ǵǾ� �ִ� �Լ���,
		//����� ���� Enum �ȿ��� ������ ������ ���� �� �ִ�.
		//�� Ascening.ordinal()�� 0, Descending.ordinal()�� 1, 
		//Random.ordinal()�� 2�� ��´�.
		
	}

}