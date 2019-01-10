import java.util.Arrays;

public class InsertionSort<E extends Comparable <E>> extends Sort<E> { //오름차순 정렬
	//Constructor
	public InsertionSort(){}

	//Sort에서 가져온 public Method
	@Override
	public boolean sort(E[] aList, int aSize) {
		if((aSize < 1) || (aSize > aList.length)){ //사이즈 수가 리스트랑 맞지 않는 경우.
			return false;
		}
		
		//사이즈 수가 맞았을 때.
		int minLoc = 0; 
		for(int i = 1; i < aSize; i++){ //최소값을 찾기 시작.
			if(aList[i].compareTo(aList[minLoc]) < 0){ //뒤가 크면 음수기 때문에 비교하는 값이 minLoc보다 작으면 minLoc을 바꿔준다.
				minLoc = i;
			}
		}
		this.swap(aList, 0, minLoc); //최종적으로 구한 minLoc을 배열의 첫칸으로 넣어준다.
		
		for(int i = 2; i < aSize; i++){ //오름차순 정렬.
			E insertedElement = aList[i];
			int insertionLoc = i-1;
			while(aList[insertionLoc].compareTo(insertedElement) > 0){ //앞에가 크면 양수, 뒤가 크면 음수, 같으면 0.
				aList[insertionLoc + 1] = aList[insertionLoc];
				insertionLoc--;
			}
			//while loop 조건이 false라서 loop 종료. 따라서, (insertionLoc + 1)이 원소 삽입 위치.
			aList[insertionLoc + 1] = insertedElement;
		}
		return true;
	}
}
