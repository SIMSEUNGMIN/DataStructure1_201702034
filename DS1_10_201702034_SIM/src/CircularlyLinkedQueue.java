
public class CircularlyLinkedQueue<T> implements Queue<T> {
	private int _size;
	private Node<T> _rear;
	
	public CircularlyLinkedQueue(){
		this._size = 0;
		this._rear = null;
	}
	
	public int size(){
		return this._size;
	}
	
	public int capacity(){
		return 2147483647;
	}
	
	@Override
	public boolean isEmpty() {
		return (this._rear == null);
	}

	@Override
	public boolean isFull() {
		return false;
	}

	@Override
	public boolean enQueue(T anElement) {
		Node<T> addNode = new Node<T>(anElement);
		if(this.isEmpty()){
			addNode.setNext(addNode);
		}
		else{
			addNode.setNext(this._rear.next());//this._rear.next()는 첫노드를 가리키고 있다.
			this._rear.setNext(addNode);
		}
		this._rear = addNode;
		this._size++;
		return true;
	}

	@Override
	public T deQueue() {
		Node<T> returnNode = null;
		if(!this.isEmpty()){
			returnNode = this._rear.next();
			if(this._rear == this._rear.next()){
				this._rear = null;
			}
			else{
				this._rear.setNext(returnNode.next());
			}
			this._size--;
		}
		return returnNode.element();
	}

	@Override
	public T frontElement() {
		if(this.isEmpty()){
			return null;
		}
		else{
			return this._rear.next().element();
		}
	}
	
	public void clear(){
		this._rear = null;
		this._size = 0;
		
	}
	
	public T elementAt(int anOrder){
		if((0 <= anOrder) && (anOrder < this._size)){
			Node<T> front = this._rear.next();
			for(int i = 0; i < anOrder; i++){
				front = front.next();
			}
			return front.element();
		}
		return null;
	}
	
}
