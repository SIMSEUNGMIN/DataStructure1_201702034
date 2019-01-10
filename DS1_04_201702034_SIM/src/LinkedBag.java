
public class LinkedBag<Element> {
	private int _size; // ������ ������ �ִ� ������ ����.
	private Node<Element> _head; // ���� ü���� �� �� ��带 �����Ѵ�.
	
	public LinkedBag(){
		this._size = 0;
		this._head = null;
	}
	
	public int size(){ // Bag�� ����ִ� ���� Ȯ��, getter.
		return this._size;
	}
	
	public boolean isEmpty(){ // size�� head�� �ʱ�ȭ �������� Ȯ��.
		return (this._size == 0);
	}
	
	public boolean doesContain(Element anElement){
		Node<Element> currentNode = this._head; //search�� ���� Node�� �����Ͽ� head���� �˻�.
		while(currentNode != null){ // currentNode�� ��������ʰ� ���� ���� ã�� ��������.
			if(currentNode.element().equals(anElement)){ //currentNode�� element�� anElement�� ���Ѵ�.
				return true; // ������ true�� ��ȯ.
			}
			else currentNode = currentNode.next(); // ������ ���� ���� �̵� ��Ų��.
		}
		
		return false;
	}
	
	public int frequencyOf(Element anElement){
		int frequencycount = 0;
		Node<Element> currentNode = this._head;
		while(currentNode != null){
			if(currentNode.element().equals(anElement)){
				frequencycount ++;
			}
			currentNode = currentNode.next();
		}
		
		return frequencycount;
	}
	
	public boolean add (Element anElement){
		Node<Element> nodeForAdd = new Node<Element>(anElement, this._head);
		this._head = nodeForAdd;
		this._size ++;
		return true;
		
	}
	
	public boolean remove(Element anElement){
		// Bag�� ��� �ִ� ��� false�� ��ȯ�Ѵ�.
		if(this.isEmpty()){
			return false;
		}
		else{
			//remove �ϱ� ���� ���� ��ġ�� ���� ��带 �˾ƾ� �Ѵ�.
			//���� ���� ���� �������� �����Ƿ� �ʱ�ȭ�Ѵ�.
			Node<Element> previousNode = null;
			//���� ���� head�� ����Ų��.
			Node<Element> currentNode = this._head;
			//������ ���� ���θ� Ȯ�� �ϱ� ���� ������ �����Ѵ�.
			boolean found = false;
			
			//ù��° �ܰ� : ������ ��ġ ã��.
			while(currentNode != null && !found){
				if(currentNode.element().equals(anElement)){
					found = true;
				}
				else{
					previousNode = currentNode;
					currentNode = currentNode.next();
				}
			}
			
			if(!found){ //ã�� ���� ���.
				return false;
			}
			else{
				//���� �ݾ��� ������ �ִ� ��带 ã�� ���.
				if(currentNode == this._head){ //ã�� ��尡 head�� ���.
					// head�� �׳� ���� ��带 ����Ű���� �Ѵ�.
					this._head = currentNode.next();
				}
				else{ //ã�� ��尡 head�� �ƴ� ���.
					// ���� ��带 �����ؾ� �ϹǷ� ���� ��忡�� ���� ��带 ����Ű�� next�� ����.
					previousNode.setNext(currentNode.next());
				}
				
				this._size--;
				return true;
			}
		}
	}
	
	public Element removeAny(){ //������� ������ �� �� ����� ���� ���� ����.
		if(this.isEmpty()){
			return null; 
		}
		else{
			Element removedElement = this._head.element();
			this._head = this._head.next();
			this._size --;
			return removedElement;
		}
	}
	
	public Element elementAt(int anOrder){ // �Է¹��� ���ڿ� �´� ��ġ�� element���� ����Ѵ�.
		if(isEmpty() || anOrder < 0 || this._size <= anOrder){ // ����ְų� �Է¹��� ���ڰ� 0���� �۰ų� �Է¹��� ���ڰ� size���� Ŭ ���
			return null; // null ���.
		}
		else{
			Node<Element> returnNode = this._head;
			for(int i = 0; i < anOrder; i++){ // �Է¹��� ���ڱ��� ���Ƽ� returnNode���� �Է¹��� ��ġ�� element���� ����ϵ��� ����.
				returnNode = returnNode.next();
			}
			return returnNode.element();
		}
		
	}
	
	public void clear(){ // ����.
		this._size = 0;
		this._head = null;
		
	}

}
