import java.util.Random;

public final class DataGenerator {
	//static Ŭ����.
	//���̻� ����� �ʿ䰡 �����Ƿ� "final"�� ����.
	
	//�����ڴ� private. ���� �ܺο��� ��ü�� ���� �� ����.
	private DataGenerator(){}
	
	//��� �����Լ��� static.
	public static Integer[] ascendingOrderList(int aSize){ //aSize�� �°� ������������ ������ �������.
		Integer[] list = null;
		if(aSize > 0){
			list = new Integer[aSize];
			for(int i = 0; i < aSize; i++){
				list[i] = i;
			}
		}
		return list;
	}
	
	public static Integer[] descendingOrderList(int aSize){ //aSize�� �°� ������������ ������ �������.
		Integer[] list = null;
		if(aSize > 0){
			list = new Integer[aSize];
			for(int i = 0; i < aSize; i++){
				list[(aSize-1)-i] = i;
			}
		}
		return list;
	}
	
	public static Integer[] randomOrderList(int aSize){ //aSize�� �°� �������� ������ �������.
		Integer[] list = null;
		if(aSize > 0){ //ó������ ������������ ����.
			list = new Integer[aSize];
			for(int i = 0; i < aSize; i++){
				list[i] = i;
			}
			
			Random random = new Random();
			for(int i = 0; i < aSize; i++){ //�������� ������ �ٲ� �������.
				int j = random.nextInt(aSize);
				Integer temp = list[i];
				list[i] = list[j];
				list[j] = temp;
			}
		}
		return list;
	}
}
