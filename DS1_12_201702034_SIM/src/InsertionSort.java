
public class InsertionSort<E extends Comparable<E>> extends Sort<E> {

	public InsertionSort(){};

	@Override
	public boolean sort(E[] aList, int aSize) {
		if((aSize < 1) || (aSize > aList.length)){
			return false;
		}
		
		int minLoc = 0;
		for(int i = 1; i < aSize; i++){
			if(aList[i].compareTo(aList[minLoc]) < 0){
				minLoc = i;
			}
		}
		this.swap(aList, 0, minLoc);
		
		for(int i = 2; i < aSize; i++){
			E insertedElement = aList[i];
			int insertionLoc = i - 1;
			while(aList[insertionLoc].compareTo(insertedElement) > 0){
				aList[insertionLoc + 1] = aList[insertionLoc];
				insertionLoc--;
			}
			//while loop�� ������ false�� loop����. ���� (insertionLoc + 1)�� ���� ���� ��ġ.
			aList[insertionLoc + 1] = insertedElement;
		}
		return true;
	}
}
