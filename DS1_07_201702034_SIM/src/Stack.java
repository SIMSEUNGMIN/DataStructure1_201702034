
public interface Stack<T> {
	
	public boolean isEmpty();
	public boolean isFull();
	public boolean push(T anElement);
	public T pop();
	public T peek();

}
