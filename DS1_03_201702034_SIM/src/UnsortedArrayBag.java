
public class UnsortedArrayBag<Element> {
	private static final int DEFAULT_CAPACITY = 100;
	private int _capacity;
	private int _size; //Bag에 들어있는 원소의 개수.
	private Element[] _elements; //ArrayBag의 원소들을 담을 java배열.
	
	public UnsortedArrayBag(){ //수용값을 미리 정하는 경우.
		this._capacity = DEFAULT_CAPACITY;
		this._elements = (Element[]) new Object[this._capacity];
		this._size = 0;
	}
	
	public UnsortedArrayBag(int givenCapacity){ //사용자가 수용값을 직접 입력하는 경우.
		this._capacity = givenCapacity;
		this._elements = (Element[]) new Object[this._capacity];
		this._size = 0;
	}
	
	public int size(){ //Bag에 들어있는 원소의 개수를 알려준다.
		return this._size;
	}
	public boolean isEmpty(){ //size가 0인지 아닌지 확인.
		if(this._size == 0){
			return true;
		}
		else return false;
	}
	
	public boolean isFull(){ //size와 capacity가 같은지 확인.(전부 채워져있나.)
		if(this._size == this._capacity){
			return true;
		}
		else return false;
	}
	
	
	public boolean doesContain(Element anElement){ //주어진 원소가 Bag에 있는지 알려준다.
		boolean found = false;
		for(int i = 0; i < this._size && ! found; i++){
			if(this._elements[i].equals(anElement)){
				found = true;
			}
		}
		return found;
	}
	
	public int frequencyOf(Element anElement){ //주어진 원소가 Bag에 몇 개 있는지 알려준다.
		int frequencyCount = 0;
		for(int i = 0; i < this._size; i++){
			if(this._elements[i].equals(anElement)){
				frequencyCount++;
			}
			else{}
		}
		return frequencyCount;
	}
	
	public boolean add(Element anElement){ //Bag에 주어진 원소를 넣는다.
		if(this.isFull()){ //Bag이 다 찼으면 false을 돌려준다.
			return false;
		}
		else{ //isFull이 true가 아닐 경우. 배열의 맨 마지막 원소의 다음칸에 넣는다.
			this._elements[this._size] = anElement;
			this._size++;
			return true;
		}
	}
	
	public boolean remove(Element anElement){ //Bag에 주어진 원소를 삭제한다.
		if(this.isEmpty()){ //Bag이 비어있다면 false.
			return false;
		}
		else{
			int foundIndex;
			boolean found = false;
			
			for(foundIndex = 0; foundIndex < this._size; foundIndex++){ //주어진 원소의 위치를 찾는다.
				if(this._elements[foundIndex].equals(anElement)){
					found = true;
					break;
				}
			}
			
			if(!found){
				return false;
			}
			else{ //그 원소를 찾았으면 삭제하고 그 이후의 모든 원소를 앞쪽으로 한 칸씩 이동시킨다.
				for(int i = foundIndex; i < this._size-1; i++){
					this._elements[i] = this._elements[i+1];
				}
				this._elements[this._size-1] = null;
				this._size--;
				return true;
			}
		}		
	}
	
	Element elementAt(int anOrder){
		if((0 <= anOrder) && (anOrder < this._size)){
			return this._elements[anOrder];
		}
		else{
			return null;
		}
	}
	
	public void clear(){ //Bag을 비운다.
		for(int i = 0; i < this._size; i++){
			this._elements[i] = null;
		}
		this._size = 0;
	}
}


