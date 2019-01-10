
abstract class Dictionary<Key extends Comparable<Key>, Obj>{
	private int _size;
	
	public int size(){
		return this._size;
	}
	
	protected void setSize (int newSize){ //�ܺο� ���� X. ���� �ν��Ͻ� ���� ���� X.
		this._size = newSize;
	}
	
	public Dictionary(){
		this.setSize(0); //��ӹ޴� Ŭ������ �����ڴ� �Ϲ������� ���� Ŭ������ �����ڸ� ���Ѵ�.
	}
	
	public boolean isEmpty(){
		return (this._size == 0); //��� �������� �̰� �����ϰ� ����ǹǷ� ���⼭ ����.
	}
	
	//public abstract methods.
	public abstract boolean isFull();
	public abstract boolean keyDoesExist(Key aKey);
	public abstract Obj objectForKey(Key aKey);
	public abstract boolean addKeyAndObject(Key aKey, Obj anObject);
	public abstract Obj removeObjectForKey(Key aKey);
	public abstract void clear();
}
