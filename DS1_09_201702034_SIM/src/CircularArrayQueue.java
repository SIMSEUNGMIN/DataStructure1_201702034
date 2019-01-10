
public class CircularArrayQueue<T> {
	private static final int DEFAULT_CAPACITY = 100;
	
	private int _capacity;
	private int _front;
	private int _rear;
	private T[] _elements;
	
	public CircularArrayQueue(){
		this(CircularArrayQueue.DEFAULT_CAPACITY);
	}
	
	@SuppressWarnings("unchecked")
	public CircularArrayQueue(int givenCapacity){
		this._capacity = givenCapacity;
		this._front = 0;
		this._rear = 0;
		this._elements = (T[]) new Object[this._capacity];
	}
	
	public int capacity(){
		return this._capacity;
	}
	
	public int size(){
		if(this._front <= this._rear){
			return (this._rear - this._front);
		}
		else{
			return ((this._rear + this._capacity) - this._front);
		}
	}
	
	public boolean isEmpty(){
		return (this._front == this._rear);
	}
	
	public boolean isFull(){
		int nextRear = (this._rear + 1) % this._capacity;
		return (nextRear == this._front);
	}
	
	public T frontElement(){
		if(this.isEmpty()){
			return null;
		}
		else{
			return this._elements[this._front + 1];
		}
	}
	
	public boolean enQueue(T anElement){
		if(this.isFull()){
			return false;
		}
		else{
			this._rear = (this._rear + 1) % this._capacity;
			this._elements[this._rear] = anElement;
			return true;
		}
	}
	
	public T deQueue(){
		if(this.isEmpty()){
			return null;
		}
		else{
			this._front = (this._front + 1) % this._capacity;
			T returnElement = this._elements[this._front];
			this._elements[this._front] = null;
			return returnElement;
			
		}
	}
	
	public T elementAt(int anOrder){
		return this._elements[(this._front + 1 + anOrder) % this._capacity];
	}
	
	public void clear(){
		for(int i = 0; i < this.size(); i++){
			this._elements[(this._front + i) % this._capacity] = null;
		}
		this._front = 0;
		this._rear = 0;
	}
}
