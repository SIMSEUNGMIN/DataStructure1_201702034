import java.util.Random;

public final class DataGenerator {
	//��ü �ν��Ͻ��� �ʿ�� ���� �ʴ� class. ��ü ���� �ʿ� x.
	//�׷��Ƿ� static���� �����ؾ� ������ �ڹٿ����� static�� �������� �ʴ´�.
	//��� final�� ����Ѵ�.
	
	//�����ڴ� private. ���� �ܺο��� ��ü�� ���� �� ����.
	private DataGenerator(){};
	
	//��� ���� �Լ��� static.
	public static Integer[] ascendingOrderList(int aSize){ //������������ list�� ������ ����.
		Integer[] list = null;
		if(aSize > 0){
			list = new Integer[aSize];
			for(int i = 0; i < aSize; i++){
				list[i] = i;
			}
		}
		return list;
	}
	
	public static Integer[] descendingOrderList(int aSize){ //������������ list�� ������ ����.
		Integer[] list = null;
		if(aSize > 0){
			list = new Integer[aSize];
			for(int i = 0; i < aSize; i++){
				list[i] = (aSize-1)-i;
			}
		}
		return list;
	}
	
	public static Integer[] randomOrderList(int aSize){ //�������� list�� ������ ����.
		Integer[] list = null;
		if(aSize > 0){
			list = new Integer[aSize];
			for(int i = 0; i < aSize; i++){
				list[i] = i;
			}
			
			Random random = new Random();
			for(int i = 0; i < aSize; i++){
				int j = random.nextInt(aSize);
				Integer temp = list[i];
				list[i] = list[j];
				list[j] = temp;
			}
		}
		return list;
	}
	
}
