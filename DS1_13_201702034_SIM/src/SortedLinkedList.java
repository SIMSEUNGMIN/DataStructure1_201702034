
public class SortedLinkedList<T extends Comparable> implements List<T> {
	private int _size;
	private Node<T> _head;
	
	public SortedLinkedList(){
		this._size = 0;
		this._head = null;
	}
	
	@Override
	public int size() {
		return this._size;
	}

	@Override
	public boolean contains(T anElement) {
		boolean found = false;
		
		while(this._head.Next() != null){
			if(this._head.element().compareTo(anElement) == 0){
				found = true;
				break;
			}
			else{
				this._head = this._head.Next();
			}
		}
		return found;
	}

	@Override
	public boolean isFull() {
		return false;
	}

	@Override
	public boolean isEmpty() {
		return (this.size() == 0);
	}

	@Override
	public boolean add(T anElement) { //처음에 들어갈 때 중간에 들어갈 때 마지막에들어갈 때.
		if(this.isEmpty()){ //맨 앞일 경우.
			Node<T> addNode = new Node<T>(anElement, this._head);
			this._head = addNode;
			this._size++;
			return true;
		}
		else{ //앞이 아닐 때. (중간)
			Node<T> currentNode = this._head;
			Node<T> previousNode = null;

			while(currentNode.Next() != null){
				if(currentNode.element().compareTo(anElement) < 0){
					if(currentNode.Next().element().compareTo(anElement) > 0){
						Node<T> addNode = new Node<T>(anElement, currentNode.Next());
						currentNode.setNext(addNode);
						this._size++;
						return true;
					}
				}
					previousNode = currentNode;
					currentNode = currentNode.Next();
			}
			
			if(currentNode.Next() == null){
					Node<T> addNode = new Node<T>(anElement, null);
					currentNode.setNext(addNode);
					this._size++;
					return true;
			}
		}
		return false;
	}
	

	@Override
	public T removeMin() {
		if(this.isEmpty()){
			return null;
		}
		else{
			T returnElement = this._head.element();
			this._head = this._head.Next();
			this._size--;
			return returnElement;
		}
	}

	@Override
	public T removeMax() {
		if(this.isEmpty()){
			return null;
		}
		else{
			Node<T> currentNode = this._head;
			Node<T> previousNode = null;
			
			while(currentNode.Next() != null){
				previousNode = currentNode;
				currentNode = currentNode.Next();
			}
			
			T returnElement = currentNode.element();
			previousNode.setNext(null);
			this._size--;
			return returnElement;
		}
	}

	@Override
	public T removeFrom(int aPosition) {
		if(this.isEmpty()){
			return null;
		}
		else if((aPosition < 0) || (aPosition >= this._size)){
			return null;
		}
		else if(aPosition == 0){
			Node<T> returnNode = this._head;
			this._head = this._head.Next();
			this._size--;
			return returnNode.element();
		}
		else{
			Node<T> currentNode = this._head;
			Node<T> previousNode = null;
			
			for(int i = 0; i < aPosition; i++){
				previousNode = currentNode;
				currentNode = currentNode.Next();
			}
			
			T returnElement = currentNode.element();
			previousNode.setNext(null);
			this._size--;
			return returnElement;
		}
	}

	@Override
	public void clear() {
		this._head = null;
		this._size = 0;
		
	}

	@Override
	public Iterator<Integer> ListIterator() {
		return new ListIterator();
	}
	
	class ListIterator<T> implements Iterator<T>{
		private Node<T> _next;
		
		private ListIterator(){
			this._next = (Node<T>) SortedLinkedList.this._head;
		}

		@Override
		public boolean hasNext() {
			return(this._next != null);
		}

		@Override
		public T next() {
			if(this._next == null){
				return null;
			}
			else{
				T element = (T) this._next.element();
				this._next = this._next.Next();
				return element;
			}
		}
		
	}

}
