
public class SortedArrayList<T extends Comparable> implements List<T> {
	//Comparable : java에서 동일한 class의 두 객체를 비교할 때 사용.
	private static final int DEFAULT_MAX_SIZE = 20;
	private int _maxSize;
	private int _size;
	private T[] _element;
	
	public SortedArrayList(){
		this(SortedArrayList.DEFAULT_MAX_SIZE);
	}
	
	public SortedArrayList(int givenMaxSize){
		this._maxSize = givenMaxSize;
		this._size = 0;
		this._element = (T[])new Comparable[this._maxSize];
	}
	
	@Override
	public int size() {
		return this._size;
	}
	
	@Override
	public boolean contains(T anElement) {
		boolean found = false;
		for(int i = 0; i < this.size(); i++){
			if(this._element[i].compareTo(anElement) == 0){
				found = true;
			}
		}
		return found;
	}
	
	@Override
	public boolean isFull() {
		return (this._size == this._maxSize);
	}
	
	@Override
	public boolean isEmpty() {
		return (this._size == 0);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean add(T anElement) {
		
		if((this._size < 0) || (this._size > this._element.length)){
			return false;
		}
		
		if(this.isEmpty()){ //만약 비어있어서 첫번째 칸에 삽입할 경우.
			this._element[this.size()] = anElement; //첫 위치에 삽입.
			this._size++; //사이즈를 늘린다.
			return true;
		}
		else{ //비어있지 않을 때.
			if(!this.isFull()){ //꽉 차있지 않다면 들어갈위치를 찾는다. 
				//(anElement보다 비교하는 원소가 크면 그 앞으로, 아니면 움직여서 뒤의 원소와 다시 비교.)
				int insertionPosition = 0;
				while((insertionPosition < this.size()) && (this._element[insertionPosition].compareTo(anElement) < 0)){ 
					//anElement보다 비교하는 원소가 작을 경우, position을 늘려 다시 확인.
					insertionPosition++;
				}
				//들어갈 위치를 찾은 경우 (insertionPosition)
				//들어갈 위치를 비우기 위해 그 뒤의 원소들을 전부 뒤로 한 칸씩 민다.
				for(int i = this.size(); i >= insertionPosition; i--){
					this._element[i+1] = this._element[i];
				}
				this._size++; //뒤로 밀고 나서는 크기를 하나 늘린다.
				//다음 비어있는 위치(insertionPosition)에 원소를 삽입한다.
				this._element[insertionPosition] = anElement;
				return true;
			}
			else return false;
		}
	}
	
	@Override
	public T removeMin() {
		
		if(this.isEmpty()){
			return null;
		}
		else{
			T returnElement = this._element[0]; //찾은 최소값을 저장.
			
			for(int i = 0; i < this._size - 1; i++){ //최소값의 자리로 뒤의 원소들을 한칸씩 당긴다.
				this._element[i] = this._element[i + 1];
			}
			
			this._element[this._size - 1] = null; //맨 마지막 위치는 null로 만든다.
			this._size--; //사이즈를 줄인다.
			
			return returnElement;
		}
	}
	
	@Override
	public T removeMax() {
		
		if(this.isEmpty()){
			return null;
		}
		else{
			T returnElement = this._element[this.size()-1]; //최대값을 찾아서 저장.
			this._element[this._size - 1] = null; //맨 마지막 원소를 null로 바꾼다.
			this._size--; //사이즈를 줄인다.
			
			return returnElement;
		}
	}
	
	@Override
	public T removeFrom(int aPosition) {
		if(this.isEmpty()){
			return null;
		}
		else{
			if((0 > aPosition) || (aPosition >= this._size)){
				return null;
			}
			else{
				T returnElement = this._element[aPosition];
				
				for(int i = aPosition; i < this._size - 1; i++){
					this._element[i] = this._element[i + 1];
				}
				
				this._element[this._size - 1] = null;
				this._size--;
				
				return returnElement;
			}
		}
	}
	
	public T elementAt(int anOrder){
		if(this.isEmpty()){
			return null;
		}
		else{
			if((0 <= anOrder) && (anOrder < this._size)){
				return this._element[anOrder];
			}
			return null;
		}
	}
	
	@Override
	public void clear() {
		for(int i = 0; i < this.size(); i++){
			this._element[i] = null;
		}
		this._size = 0;
	}
	
	@Override
	public Iterator<Integer> ListIterator() {
		return new ListIterator();
	}
	
	class ListIterator<T> implements Iterator<T> {
		private int _nextPositon; //현재 (노드)위치.

		private ListIterator() {
			this._nextPositon = 0;
		}

		@Override
		public boolean hasNext() {
			return (this._nextPositon < SortedArrayList.this.size());
		}

		@Override
		public T next() {
			if (this._nextPositon == SortedArrayList.this.size()) {
				return null;
			}
			else {
				@SuppressWarnings("unchecked")
				T element = (T) SortedArrayList.this._element[this._nextPositon];
				this._nextPositon++;
				return element;
			}
		}
	}
}
