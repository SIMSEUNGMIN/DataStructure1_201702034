
public class DictionaryBySortedArray<Key extends Comparable<Key>, Obj> 
			extends Dictionary<Key, Obj>
{
	//Constants
	private static final int DEFAULT_CAPACITY = 100000;
	
	//Private instance variables
	private int _capacity;
	private DictionaryElement<Key, Obj>[] _elements;
	
	public int capacity(){
		return this._capacity;
	}
	
	private void setCapacity(int newCapacity){
		this._capacity = newCapacity;
	}
	
	public DictionaryBySortedArray(){
		this(DictionaryBySortedArray.DEFAULT_CAPACITY);
	}
	
	@SuppressWarnings("unchecked")
	public DictionaryBySortedArray(int givenCapacity){
		this.setCapacity(givenCapacity);
		this._elements = new DictionaryElement[this.capacity()];
	}
	
	private int positionFor(Key aKey){
		int left = 0;
		int right = this.size() - 1;
		
		while(left <= right){
			int mid = (left + right) / 2;
			switch(aKey.compareTo(this._elements[mid].key())){
			case -1:
				right = mid - 1;
				break;
			case 0:
				return mid;
			case +1:
				left = mid + 1;
				break;
			}
		}
		return -(left + 1);
	}
	
	private void makeRoomAt(int aPosition){
		for(int i = this.size(); i > aPosition; i--){
			this._elements[i] = this._elements[i-1];
		}
	}
	
	private void removeGapAt(int aPosition){
		for(int i = aPosition; i < this.size()-1; i++){
			this._elements[i] = this._elements[i + 1];
		}
	}
	
	@Override
	public boolean isFull() {
		return (this.size() == this.capacity());
	}

	@Override
	public boolean keyDoesExist(Key aKey) {
		return (this.positionFor(aKey) == 0);
	}

	@Override
	public Obj objectForKey(Key aKey) {
		int positionWithKey = this.positionFor(aKey);
		if(positionWithKey < 0){
			return null;
		}
		return this._elements[positionWithKey].object();
	}

	@Override
	public boolean addKeyAndObject(Key aKey, Obj anObject) {
		int positionForAdd = this.positionFor(aKey);
		if(positionForAdd >= 0){
			return false;
		}
		
		positionForAdd = -(positionForAdd + 1);
		this.makeRoomAt(positionForAdd);
		this._elements[positionForAdd] = new DictionaryElement<Key, Obj>(aKey, anObject);
		this.setSize(this.size()+1);
		return true;
	}

	@Override
	public Obj removeObjectForKey(Key aKey) {
		int positionForRemove = this.positionFor(aKey);
		if(positionForRemove < 0){
			return null;
		}
		Obj removedObject = this._elements[positionForRemove].object();
		this.removeGapAt(positionForRemove);
		this.setSize(this.size()-1);
		return removedObject;
	}

	@Override
	public void clear() {
		this.setSize(0);
	}

}
