import java.util.Arrays;

public class InsertionSort<E extends Comparable <E>> extends Sort<E> { //�������� ����
	//Constructor
	public InsertionSort(){}

	//Sort���� ������ public Method
	@Override
	public boolean sort(E[] aList, int aSize) {
		if((aSize < 1) || (aSize > aList.length)){ //������ ���� ����Ʈ�� ���� �ʴ� ���.
			return false;
		}
		
		//������ ���� �¾��� ��.
		int minLoc = 0; 
		for(int i = 1; i < aSize; i++){ //�ּҰ��� ã�� ����.
			if(aList[i].compareTo(aList[minLoc]) < 0){ //�ڰ� ũ�� ������ ������ ���ϴ� ���� minLoc���� ������ minLoc�� �ٲ��ش�.
				minLoc = i;
			}
		}
		this.swap(aList, 0, minLoc); //���������� ���� minLoc�� �迭�� ùĭ���� �־��ش�.
		
		for(int i = 2; i < aSize; i++){ //�������� ����.
			E insertedElement = aList[i];
			int insertionLoc = i-1;
			while(aList[insertionLoc].compareTo(insertedElement) > 0){ //�տ��� ũ�� ���, �ڰ� ũ�� ����, ������ 0.
				aList[insertionLoc + 1] = aList[insertionLoc];
				insertionLoc--;
			}
			//while loop ������ false�� loop ����. ����, (insertionLoc + 1)�� ���� ���� ��ġ.
			aList[insertionLoc + 1] = insertedElement;
		}
		return true;
	}
}
