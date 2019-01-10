
public class SortedArrayList<T extends Comparable> implements List<T> {
	//Comparable : java���� ������ class�� �� ��ü�� ���� �� ���.
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
		
		if(this.isEmpty()){ //���� ����־ ù��° ĭ�� ������ ���.
			this._element[this.size()] = anElement; //ù ��ġ�� ����.
			this._size++; //����� �ø���.
			return true;
		}
		else{ //������� ���� ��.
			if(!this.isFull()){ //�� ������ �ʴٸ� ����ġ�� ã�´�. 
				//(anElement���� ���ϴ� ���Ұ� ũ�� �� ������, �ƴϸ� �������� ���� ���ҿ� �ٽ� ��.)
				int insertionPosition = 0;
				while((insertionPosition < this.size()) && (this._element[insertionPosition].compareTo(anElement) < 0)){ 
					//anElement���� ���ϴ� ���Ұ� ���� ���, position�� �÷� �ٽ� Ȯ��.
					insertionPosition++;
				}
				//�� ��ġ�� ã�� ��� (insertionPosition)
				//�� ��ġ�� ���� ���� �� ���� ���ҵ��� ���� �ڷ� �� ĭ�� �δ�.
				for(int i = this.size(); i >= insertionPosition; i--){
					this._element[i+1] = this._element[i];
				}
				this._size++; //�ڷ� �а� ������ ũ�⸦ �ϳ� �ø���.
				//���� ����ִ� ��ġ(insertionPosition)�� ���Ҹ� �����Ѵ�.
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
			T returnElement = this._element[0]; //ã�� �ּҰ��� ����.
			
			for(int i = 0; i < this._size - 1; i++){ //�ּҰ��� �ڸ��� ���� ���ҵ��� ��ĭ�� ����.
				this._element[i] = this._element[i + 1];
			}
			
			this._element[this._size - 1] = null; //�� ������ ��ġ�� null�� �����.
			this._size--; //����� ���δ�.
			
			return returnElement;
		}
	}
	
	@Override
	public T removeMax() {
		
		if(this.isEmpty()){
			return null;
		}
		else{
			T returnElement = this._element[this.size()-1]; //�ִ밪�� ã�Ƽ� ����.
			this._element[this._size - 1] = null; //�� ������ ���Ҹ� null�� �ٲ۴�.
			this._size--; //����� ���δ�.
			
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
		private int _nextPositon; //���� (���)��ġ.

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
