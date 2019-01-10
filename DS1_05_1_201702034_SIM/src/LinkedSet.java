
public class LinkedSet<E> {
	private int _size;
	private Node<E> _head;
	
	public LinkedSet(){
		this._size = 0;
		this._head = null;
	}
	
	public int size(){
		return this._size;
	}
	
	public boolean isEmpty(){
		return (this._size == 0);
	}
	
	public boolean isFull(){
		return false;
	}
	
	public boolean doesContain(E anElement){
		Node<E> currentNode = this._head;
		while(currentNode != null){
			if(currentNode.element().equals(anElement)){
				return true;
			}
			else currentNode = currentNode.next();
		}
		
		return false;
		
	}
	
	public boolean add(E anElement){
		Node<E> nodeForAdd = new Node<E>(anElement,this._head);
		this._head = nodeForAdd;
		this._size++;
		return true;
	}
	
	public Star remove(E anElement){
		if(this.isEmpty()){
			return null;
		}
		else{
			Node<E> previousNode = null;
			Node<E> currentNode = this._head;
			boolean found = false;
			
			while(currentNode != null && !found){
				if(currentNode.element().equals(anElement)){
					found = true;
					break;
				}
				else{
					previousNode = currentNode;
					currentNode = currentNode.next();
				}
			}
			
			if(!found){
				return null;
			}
			else{
				Star removeStar = null;
				
				if(currentNode == this._head){
					removeStar = ((Star)this._head.element());
					this._head = currentNode.next();
				}
				else{
					removeStar = ((Star)currentNode.element());
					previousNode.setNext(currentNode.next());
				}
				
				this._size--;
				return removeStar;
			}
		}
	}
	
	public E removeAny(){
		if(this.isEmpty()){
			return null;
		}
		else{
			E removedElement = this._head.element();
			this._head = this._head.next();
			this._size--;
			return removedElement;
		}
	}
	
	public E elementAt(int anOrder){
		if(isEmpty() || anOrder < 0 || this._size <= anOrder){
			return null;
		}
		else{
			Node<E> returnNode = this._head;
			for(int i = 0; i < anOrder; i++){
				returnNode = returnNode.next();
			}
			return returnNode.element();
		}
	}
	
	public void clear(){
		this._size = 0;
		this._head = null;
	}
}
