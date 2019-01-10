
public abstract class Sort<E extends Comparable<E>> {

	protected Sort(){};
	
	protected void swap(E[] aList, int i, int j){
		E temp = aList[i];
		aList[i] = aList[j];
		aList[j] = temp;
	}
	
	public abstract boolean sort(E[] aList, int aSize);
	
}
