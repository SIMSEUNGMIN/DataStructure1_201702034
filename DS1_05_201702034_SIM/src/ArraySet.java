
public class ArraySet<E> {

	private static final int DEFAULT_CAPACITY = 100; //상수
	
	// 비공개 인스턴스 변수
	private int _capacity;
	private int _size;
	private E[] _elements; //ArraySet의 원소들을 담을 java배열.
	
	public ArraySet(){
		this._capacity = DEFAULT_CAPACITY;
		this._size = 0;
		this._elements = (E[]) new Object[DEFAULT_CAPACITY];
	}
	
	public ArraySet(int givenCapacity){
		this._capacity = givenCapacity;
		this._size = 0;
		this._elements = (E[]) new Object[givenCapacity];
	}
	
	public int size(){
		return this._size;
	}
	
	public boolean isEmpty(){
		if(this._size == 0){
			return true;
		}
		else return false;
	}
	
	public boolean isFull(){
		if(this._size == this._capacity){
			return true;
		}
		else return false;
	}
	
	public boolean doesContain(E anElement){
		for(int i = 0; i < this._size; i++){
			if(this._elements[i].equals(anElement)){
				return true;
			}
		}
		return false;
	}
	
	public E elementAt(int anOrder){
		if((0 <= anOrder) && (anOrder < this._size)){
			return this._elements[anOrder];
		}
		else return null;
	}
	
	public boolean add(E anElement){
		if(isFull()){
			return false;
		}
		else if (doesContain(anElement)){
			return false;
		}
		else{
			this._elements[this._size] = anElement;
			this._size++;
			return true;
		}
	}
	
	public E remove(E anElement){
		if(isEmpty()){
			return null;
		}
		else{
			int foundIndex;
			boolean found = false;
			E removeStar = null;
			
			for(foundIndex = 0; foundIndex < this._size; foundIndex++){
				if(this._elements[foundIndex].equals(anElement)){
					found = true;
					removeStar = this._elements[foundIndex];
					break;
				}
			}
			
			if(!found){
				return null;
			}
			else{
				for(int i = foundIndex; i < this._size - 1; i++){
					this._elements[i] = this._elements[i+1];
				}
				this._elements[this._size-1] = null;
				this._size--;
				return removeStar;
			}
		}
	}
	
	public E removeAny(){ //E removeStar 부분이 애매함.
		if(isEmpty()){
			return null;
		}
		else{
			E removeStar = this._elements[0];
			for(int i = 0; i < this._size -1; i++){
				this._elements[i] = this._elements[i+1];
			}
			this._elements[this._size-1] = null;
			this._size --;
			return removeStar;
		}
	}
	
	public void clear(){
		for(int i = 0; i < this._size; i++){
			this._elements[i] = null;
		}
		
		this._size = 0;
	}
}
