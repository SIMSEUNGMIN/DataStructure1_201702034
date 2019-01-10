
public class Node<T> {
	private T _element;
	private Node<T> _next;
	
	public Node(){
		this._element = null;
		this._next = null;
	}
	
	public Node(T givenElement){
		this._element = givenElement;
		this._next = null;
	}
	
	public Node(T givenElement, Node<T> givenNext){
		this._element = givenElement;
		this._next = givenNext;
	}
	
	public void setElement(T newElement){
		this._element = newElement;
	}
	
	public T element(){
		return this._element;
	}
	
	public void setNext(Node<T> newNext){
		this._next = newNext;
	}
	
	public Node<T> next(){
		return this._next;
	}
}
