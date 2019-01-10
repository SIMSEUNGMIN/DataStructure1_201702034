import java.util.Random;

public final class DataGenerator {
	//객체 인스턴스를 필요로 하지 않는 class. 객체 생성 필요 x.
	//그러므로 static으로 선언해야 하지만 자바에서는 static을 선언하지 않는다.
	//대신 final을 사용한다.
	
	//생성자는 private. 따라서 외부에서 객체를 만들 수 없다.
	private DataGenerator(){};
	
	//모든 공개 함수는 static.
	public static Integer[] ascendingOrderList(int aSize){ //오름차순으로 list에 데이터 생성.
		Integer[] list = null;
		if(aSize > 0){
			list = new Integer[aSize];
			for(int i = 0; i < aSize; i++){
				list[i] = i;
			}
		}
		return list;
	}
	
	public static Integer[] descendingOrderList(int aSize){ //내림차순으로 list에 데이터 생성.
		Integer[] list = null;
		if(aSize > 0){
			list = new Integer[aSize];
			for(int i = 0; i < aSize; i++){
				list[i] = (aSize-1)-i;
			}
		}
		return list;
	}
	
	public static Integer[] randomOrderList(int aSize){ //랜덤으로 list에 데이터 생성.
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
