import java.util.Random;

public final class DataGenerator {
	//static 클래스.
	//더이상 상속할 필요가 없으므로 "final"로 선언.
	
	//생성자는 private. 따라서 외부에서 객체를 만들 수 없다.
	private DataGenerator(){}
	
	//모든 공개함수는 static.
	public static Integer[] ascendingOrderList(int aSize){ //aSize에 맞게 오름차순으로 정수를 집어넣음.
		Integer[] list = null;
		if(aSize > 0){
			list = new Integer[aSize];
			for(int i = 0; i < aSize; i++){
				list[i] = i;
			}
		}
		return list;
	}
	
	public static Integer[] descendingOrderList(int aSize){ //aSize에 맞게 내림차순으로 정수를 집어넣음.
		Integer[] list = null;
		if(aSize > 0){
			list = new Integer[aSize];
			for(int i = 0; i < aSize; i++){
				list[(aSize-1)-i] = i;
			}
		}
		return list;
	}
	
	public static Integer[] randomOrderList(int aSize){ //aSize에 맞게 랜덤으로 정수를 집어넣음.
		Integer[] list = null;
		if(aSize > 0){ //처음에는 오름차순으로 넣음.
			list = new Integer[aSize];
			for(int i = 0; i < aSize; i++){
				list[i] = i;
			}
			
			Random random = new Random();
			for(int i = 0; i < aSize; i++){ //랜덤으로 순서를 바꿔 집어넣음.
				int j = random.nextInt(aSize);
				Integer temp = list[i];
				list[i] = list[j];
				list[j] = temp;
			}
		}
		return list;
	}
}
