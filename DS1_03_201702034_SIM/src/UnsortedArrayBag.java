
public class UnsortedArrayBag<Element> {
	private static final int DEFAULT_CAPACITY = 100;
	private int _capacity;
	private int _size; //Bag�� ����ִ� ������ ����.
	private Element[] _elements; //ArrayBag�� ���ҵ��� ���� java�迭.
	
	public UnsortedArrayBag(){ //���밪�� �̸� ���ϴ� ���.
		this._capacity = DEFAULT_CAPACITY;
		this._elements = (Element[]) new Object[this._capacity];
		this._size = 0;
	}
	
	public UnsortedArrayBag(int givenCapacity){ //����ڰ� ���밪�� ���� �Է��ϴ� ���.
		this._capacity = givenCapacity;
		this._elements = (Element[]) new Object[this._capacity];
		this._size = 0;
	}
	
	public int size(){ //Bag�� ����ִ� ������ ������ �˷��ش�.
		return this._size;
	}
	public boolean isEmpty(){ //size�� 0���� �ƴ��� Ȯ��.
		if(this._size == 0){
			return true;
		}
		else return false;
	}
	
	public boolean isFull(){ //size�� capacity�� ������ Ȯ��.(���� ä�����ֳ�.)
		if(this._size == this._capacity){
			return true;
		}
		else return false;
	}
	
	
	public boolean doesContain(Element anElement){ //�־��� ���Ұ� Bag�� �ִ��� �˷��ش�.
		boolean found = false;
		for(int i = 0; i < this._size && ! found; i++){
			if(this._elements[i].equals(anElement)){
				found = true;
			}
		}
		return found;
	}
	
	public int frequencyOf(Element anElement){ //�־��� ���Ұ� Bag�� �� �� �ִ��� �˷��ش�.
		int frequencyCount = 0;
		for(int i = 0; i < this._size; i++){
			if(this._elements[i].equals(anElement)){
				frequencyCount++;
			}
			else{}
		}
		return frequencyCount;
	}
	
	public boolean add(Element anElement){ //Bag�� �־��� ���Ҹ� �ִ´�.
		if(this.isFull()){ //Bag�� �� á���� false�� �����ش�.
			return false;
		}
		else{ //isFull�� true�� �ƴ� ���. �迭�� �� ������ ������ ����ĭ�� �ִ´�.
			this._elements[this._size] = anElement;
			this._size++;
			return true;
		}
	}
	
	public boolean remove(Element anElement){ //Bag�� �־��� ���Ҹ� �����Ѵ�.
		if(this.isEmpty()){ //Bag�� ����ִٸ� false.
			return false;
		}
		else{
			int foundIndex;
			boolean found = false;
			
			for(foundIndex = 0; foundIndex < this._size; foundIndex++){ //�־��� ������ ��ġ�� ã�´�.
				if(this._elements[foundIndex].equals(anElement)){
					found = true;
					break;
				}
			}
			
			if(!found){
				return false;
			}
			else{ //�� ���Ҹ� ã������ �����ϰ� �� ������ ��� ���Ҹ� �������� �� ĭ�� �̵���Ų��.
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
	
	public void clear(){ //Bag�� ����.
		for(int i = 0; i < this._size; i++){
			this._elements[i] = null;
		}
		this._size = 0;
	}
}


