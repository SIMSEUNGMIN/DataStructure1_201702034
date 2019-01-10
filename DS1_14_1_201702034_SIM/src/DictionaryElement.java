
public class DictionaryElement<Key, Obj> {
	private Key _key;
	private Obj _object;
	
	public DictionaryElement(){
		this._key = null;
		this._object = null;
	}
	
	public DictionaryElement(Key givenKey, Obj givenObject){
		this._key = givenKey;
		this._object = givenObject;
	}
	
	public void setkey(Key newKey){
		this._key = newKey;
	}
	
	public Key key(){
		return this._key;
	}
	
	public void setObject(Obj newObject){
		this._object = newObject;
	}
	
	public Obj object(){
		return this._object;
	}
}
