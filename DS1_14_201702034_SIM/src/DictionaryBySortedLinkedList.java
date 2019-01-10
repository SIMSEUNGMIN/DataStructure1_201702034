
public class DictionaryBySortedLinkedList<Key extends Comparable <Key>, Obj>
		extends Dictionary<Key, Obj>
{
	private LinkedNode<DictionaryElement<Key, Obj>> _head;
	
	private LinkedNode<DictionaryElement<Key, Obj>> head(){
		return this._head;
	}
	
	private void setHead(LinkedNode<DictionaryElement<Key, Obj>> newHead){
		this._head = newHead;
	}
	
	public DictionaryBySortedLinkedList(){
		this.clear();
	}
	
	@Override
	public boolean isFull() {
		return false;
	}

	@Override
	public boolean keyDoesExist(Key aKey) {
		LinkedNode<DictionaryElement<Key, Obj>> current = this.head();
		while(current != null){
			switch(current.element().key().compareTo(aKey)){
			case -1:
				current = current.next();
				break;
			case 0:
				return true;
			case +1:
				return false;
			}
		}
		return false;
	}

	@Override
	public Obj objectForKey(Key aKey) {
		LinkedNode<DictionaryElement<Key, Obj>> current = this.head();
		while((current != null) && (current.element().key().compareTo(aKey)) < 0){
			current = current.next();
		}
		if((current != null) && ((current.element().key().compareTo(aKey)) == 0)){
			return current.element().object();
		}
		else{
			return null;
		}
	}

	@Override
	public boolean addKeyAndObject(Key aKey, Obj anObject) {
		LinkedNode<DictionaryElement<Key, Obj>> previous = null;
		LinkedNode<DictionaryElement<Key, Obj>> current = this.head();
		
		while((current != null) && (current.element().key().compareTo(aKey)) < 0){
			previous = current;
			current = current.next();
		}
		if((current != null) && (current.element().key().compareTo(aKey) == 0)){
			return false;
		}
		DictionaryElement<Key,Obj> addElement = 
				new DictionaryElement<Key, Obj>(aKey, anObject);
		LinkedNode<DictionaryElement<Key, Obj>> addNode = 
				new LinkedNode<DictionaryElement<Key, Obj>>();
		addNode.setElement(addElement);
		addNode.setNext(current);
		if(previous == null){
			this.setHead(addNode);
		}
		else{
			previous.setNext(addNode);
		}
		this.setSize(this.size() + 1);
		return true;
	}

	@Override
	public Obj removeObjectForKey(Key aKey) {
		LinkedNode<DictionaryElement<Key,Obj>> previous = null;
		LinkedNode<DictionaryElement<Key,Obj>> current = this.head();
		
		while((current != null) && (current.element().key().compareTo(aKey) < 0)){
			previous = current;
			current = current.next();
		}
		if((current != null) && (current.element().key().compareTo(aKey) == 0)){
			if(current == this.head()){
				this.setHead(current.next());
			}
			else{
				previous.setNext(current.next());
			}
			this.setSize(this.size()-1);
			return current.element().object();
		}
		else{
			return null;
		}
	}

	@Override
	public void clear() {
		this.setSize(0);
		this.setHead(null);
	}

}
