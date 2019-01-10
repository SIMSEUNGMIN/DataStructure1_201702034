
public interface List<T> {
	
	public int size();
	
	public boolean contains(T anElement);
	public boolean isFull();
	public boolean isEmpty();
	
	public boolean add(T anElement);
	
	public T removeMin();
	public T removeMax();
	public T removeFrom(int aPosition);
	
	public void clear();

	public Iterator<Integer> ListIterator();
}
