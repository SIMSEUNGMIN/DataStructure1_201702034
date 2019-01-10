
public abstract class Sort<E extends Comparable <E>> {
	
	//Constructor
	protected Sort(){}
	
	//Protected Method
	protected void swap(E[] aList, int i, int j){
		E tempElement = aList[i];
		aList[i] = aList[j];
		aList[j] = tempElement;
	}
	
	//public Method
	public abstract boolean sort(E[] aList, int aSize);

}
