
abstract class Dictionary<Key extends Comparable<Key>, Obj>{
	private int _size;
	
	public int size(){
		return this._size;
	}
	
	protected void setSize (int newSize){ //외부에 공개 X. 직접 인스턴스 변수 접근 X.
		this._size = newSize;
	}
	
	public Dictionary(){
		this.setSize(0); //상속받는 클래스의 생성자는 암묵적으로 상위 클래스의 생성자를 콜한다.
	}
	
	public boolean isEmpty(){
		return (this._size == 0); //모든 사전에서 이건 동일하게 적용되므로 여기서 구현.
	}
	
	//public abstract methods.
	public abstract boolean isFull();
	public abstract boolean keyDoesExist(Key aKey);
	public abstract Obj objectForKey(Key aKey);
	public abstract boolean addKeyAndObject(Key aKey, Obj anObject);
	public abstract Obj removeObjectForKey(Key aKey);
	public abstract void clear();
}
