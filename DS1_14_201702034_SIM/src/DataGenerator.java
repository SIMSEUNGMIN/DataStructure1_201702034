import java.util.Random;

public final class DataGenerator {
	
	private DataGenerator(){};
	
	public static int[] ascendingList(int aSize){
		if(aSize > 0){
			int[] list = new int[aSize];
			for(int i = 0; i < aSize; i++){
				list[i] = i;
			}
			return list;
		}
		return null;
	}
	
	public static int[] descendingList(int aSize){
		if(aSize > 0){
			int[] list = new int[aSize];
			for(int i = 0; i < aSize; i++){
				list[i] = (aSize-1) - i;
			}
			return list;
		}
		return null;
	}
	
	public static int[] randomList(int aSize){
		if(aSize > 0){
			int[] list = new int[aSize];
			for(int i = 0; i < aSize; i++){
				list[i] = i;
			}
			
			Random random = new Random();
			
			for(int i = 0; i < aSize; i++){
				int j = random.nextInt(aSize);
				int temp = list[i];
				list[i] = list[j];
				list[j] = temp;
			}
			return list;
		}
		return null;
	}
}
