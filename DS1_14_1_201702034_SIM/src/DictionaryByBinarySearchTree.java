
public class DictionaryByBinarySearchTree<Key extends Comparable <Key>, Obj>
		extends Dictionary<Key, Obj>
{	
	private BinaryNode<DictionaryElement<Key, Obj>> _root;
	@SuppressWarnings("rawtypes")
	private VisitEventSourceForTreeTraversal _visitEvent;
	
	@SuppressWarnings("rawtypes")
	public VisitEventSourceForTreeTraversal visitEvent(){
		return this._visitEvent;
	}
	@SuppressWarnings("rawtypes")
	public void setVisitEvent(VisitEventSourceForTreeTraversal newVisitEvent){
		this._visitEvent = newVisitEvent;
	}
	
	private BinaryNode<DictionaryElement<Key, Obj>> root(){
		return this._root;
	}
	
	private void setRoot(BinaryNode<DictionaryElement<Key,Obj>> newRoot){
		this._root = newRoot;
	}
	
	public DictionaryByBinarySearchTree(){
		this.clear();
	}
	
	@Override
	public boolean isFull() {
		return false;
	}
	
	private DictionaryElement<Key, Obj> elementForKey(Key aKey){
		BinaryNode<DictionaryElement<Key, Obj>> current = this.root();
		while(current != null){
			if(current.element().key().compareTo(aKey) == 0){
				return current.element();
			}
			else if(current.element().key().compareTo(aKey) > 0){
				current = current.left();
			}
			else{
				current = current.right();
			}	
		}
		return null;
	}

	@Override
	public boolean keyDoesExist(Key aKey) {
		return (this.elementForKey(aKey) != null);
	}

	@Override
	public Obj objectForKey(Key aKey) {
		DictionaryElement<Key, Obj> element = this.elementForKey(aKey);
		if(element != null){
			return element.object();
		}
		else{
			return null;
		}
	}

	@Override
	public boolean addKeyAndObject(Key aKey, Obj anObject) {
		DictionaryElement<Key,Obj> elementForAdd = new DictionaryElement<Key, Obj>(aKey, anObject);
		BinaryNode<DictionaryElement<Key, Obj>> nodeForAdd = 
				new BinaryNode<DictionaryElement <Key, Obj>>(elementForAdd, null, null);
		
		if(this.root() == null){
			this.setRoot(nodeForAdd);
			this.setSize(1);
			return true;
		}
		BinaryNode<DictionaryElement<Key, Obj>> current = this.root();
		while(aKey.compareTo(current.element().key()) != 0){
			if(aKey.compareTo(current.element().key()) < 0){
				if(current.left() == null){
					current.setLeft(nodeForAdd);
					this.setSize(this.size() + 1);
					return true;
				}
				else{
					current = current.left();
				}
			}
			else{
				if(current.right() == null){
					current.setRight(nodeForAdd);
					this.setSize(this.size() + 1);
					return true;
				}
				else{
					current = current.right();
				}
			}
		}
		return false;
	}
	
	private DictionaryElement<Key, Obj>
				removeRightMostElementOfLeftSubTree(BinaryNode<DictionaryElement<Key, Obj>> root){
		BinaryNode<DictionaryElement<Key, Obj>> leftOfRoot = root.left();
		if(leftOfRoot.right() == null){
			root.setLeft(leftOfRoot.left());
			return leftOfRoot.element();
		}
		else{
			BinaryNode<DictionaryElement<Key, Obj>> parentOfRightMost = leftOfRoot;
			BinaryNode<DictionaryElement<Key, Obj>> rightMost = parentOfRightMost.right();
			
			while(rightMost.right() != null){
				parentOfRightMost = rightMost;
				rightMost = rightMost.right();
			}
			parentOfRightMost.setRight(rightMost.left());
			return rightMost.element();
		}
	}

	@Override
	public Obj removeObjectForKey(Key aKey) {
		if(this.root() == null){
			return null;
		}
		if(aKey.compareTo(this.root().element().key()) == 0){
			Obj objectForRemove = this.root().element().object();
			if((this.root().left() == null) && (this.root().right() == null)){
				this.setRoot(null);
			}
			else if(this.root().left() == null){
				this.setRoot(this.root().right());
			}
			else if(this.root().right() == null){
				this.setRoot(this.root().left());
			}
			else{
				this.root().setElement(this.removeRightMostElementOfLeftSubTree(this.root()));
			}
			this.setSize(this.size()-1);
			return objectForRemove;
		}
		
		BinaryNode<DictionaryElement<Key, Obj>> current = this.root();
		BinaryNode<DictionaryElement<Key, Obj>> child = null;
		
		do{
			if(aKey.compareTo(current.element().key()) < 0){
				child = current.left();
				if(child == null){
					return null;
				}
				if(aKey.compareTo(child.element().key()) == 0){
					Obj objectForRemove = child.element().object();
					if(child.left() == null && child.right() == null){
						current.setLeft(null);
					}
					else if(child.left() == null){
						current.setLeft(child.left());
					}
					else if(child.right() == null){
						current.setLeft(child.left());
					}
					else{
						child.setElement(this.removeRightMostElementOfLeftSubTree(child));
					}
					this.setSize(this.size()-1);
					return objectForRemove;
				}
			}
			else{
				child = current.right();
				if(child == null){
					return null;
				}
				if(aKey.compareTo(child.element().key()) == 0){
					Obj objectForRemove = child.element().object();
					if(child.left() == null && child.right() == null){
						current.setRight(null);
					}
					else if(child.left() == null){
						current.setRight(child.right());
					}
					else if(child.right() == null){
						current.setRight(child.left());
					}
					else{
						child.setElement(this.removeRightMostElementOfLeftSubTree(child));
					}
					this.setSize(this.size()-1);
					return objectForRemove;
				}
			}
			current = child;
		}while(true);
	}

	@Override
	public void clear() {
		this.setSize(0);
		this.setRoot(null);
	}
	
	private void inorderRecursively(
			BinaryNode<DictionaryElement<Key, Obj>> aRootOfSubtree, int aLevel){
		
		if(aRootOfSubtree != null){
			this.inorderRecursively(aRootOfSubtree.left(), aLevel);
			this.visitEvent().visitByCallBack(aRootOfSubtree.element(), aLevel);
			this.inorderRecursively(aRootOfSubtree.right(), aLevel);
		}
	}
	
	public void scanInSortedOrder(){
		this.inorderRecursively(this.root(), 1);
	}
	
	private void reverseOfInorderRecursively(BinaryNode<DictionaryElement<Key, Obj>> aRootOfSubtree, int aLevel){
		if(aRootOfSubtree != null){
			this.reverseOfInorderRecursively(aRootOfSubtree.right(), aLevel + 1);
			this.visitEvent().visitByCallBack(aRootOfSubtree.element(), aLevel);
			this.reverseOfInorderRecursively(aRootOfSubtree.left(), aLevel + 1);
		}
	}
	
	public void scanReverseOfSortedOrder(){
		this.reverseOfInorderRecursively(this.root(), 1);
	}

}
