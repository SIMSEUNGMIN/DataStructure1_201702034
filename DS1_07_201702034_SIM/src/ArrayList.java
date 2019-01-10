
public class ArrayList<T> implements Stack<T> {

	private static final int DEFAULT_CAPACITY = 5;
	private int _capacity;
	private int _top;
	private T[] _elements;
	
	@SuppressWarnings("unchecked")
	public ArrayList(){
		this._capacity = DEFAULT_CAPACITY;
		this._top = -1;
		this._elements = (T[]) new Object[DEFAULT_CAPACITY];
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList(int givenStackSize){
		this._capacity = DEFAULT_CAPACITY;
		this._top = -1;
		this._elements = (T[]) new Object[givenStackSize];
	}
	
	public int size(){
		return this._top+1;
	}
	
	@Override
	public boolean isEmpty() {
		return (this._top == -1);
	}

	@Override
	public boolean isFull() {
		return (this._top+1 == this._capacity);
	}

	@Override
	public boolean push(T anElement) {
		if(this.isFull()){
			return false;
		}
		else{
			this._top++;
			this._elements[this._top] = anElement;
			return true;
		}
	}

	@Override
	public T pop() {
		T topElement = null;
		if(!this.isEmpty()){
			topElement = this._elements[this._top];
			this._elements[this._top] = null;
			this._top--;
		}
		return topElement;
	}

	@Override
	public T peek() {
		T topElement = null;
		if(!this.isEmpty()){
			topElement = this._elements[this._top];
		}
		return topElement;
	}
	
	public void clear(){
		while(this._top >= 0){
			this._elements[this._top] = null;
			this._top--;
		}
	}
	
	public T elementAt(int anOrder){
		if(!this.isEmpty() && (0 <= anOrder) && (anOrder <= this._top)){
			return this._elements[anOrder];
		}
		else return null;
	}
}
