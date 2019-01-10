
public class LinkedBag<Element> {
	private int _size; // 가방이 가지고 있는 원소의 개수.
	private Node<Element> _head; // 연결 체인의 맨 앞 노드를 소유한다.
	
	public LinkedBag(){
		this._size = 0;
		this._head = null;
	}
	
	public int size(){ // Bag에 들어있는 개수 확인, getter.
		return this._size;
	}
	
	public boolean isEmpty(){ // size와 head가 초기화 상태인지 확인.
		return (this._size == 0);
	}
	
	public boolean doesContain(Element anElement){
		Node<Element> currentNode = this._head; //search를 위한 Node를 선언하여 head부터 검색.
		while(currentNode != null){ // currentNode가 비어있지않고 아직 값을 찾지 못했으면.
			if(currentNode.element().equals(anElement)){ //currentNode의 element와 anElement를 비교한다.
				return true; // 같으면 true로 변환.
			}
			else currentNode = currentNode.next(); // 없으면 다음 노드로 이동 시킨다.
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
		// Bag이 비어 있는 경우 false를 반환한다.
		if(this.isEmpty()){
			return false;
		}
		else{
			//remove 하기 위해 이전 위치와 현재 노드를 알아야 한다.
			//이전 노드는 현재 존재하지 않으므로 초기화한다.
			Node<Element> previousNode = null;
			//현재 노드는 head를 가리킨다.
			Node<Element> currentNode = this._head;
			//코인의 존재 여부를 확인 하기 위한 변수를 선언한다.
			boolean found = false;
			
			//첫번째 단계 : 삭제할 위치 찾기.
			while(currentNode != null && !found){
				if(currentNode.element().equals(anElement)){
					found = true;
				}
				else{
					previousNode = currentNode;
					currentNode = currentNode.next();
				}
			}
			
			if(!found){ //찾지 못한 경우.
				return false;
			}
			else{
				//같은 금액의 코인이 있는 노드를 찾은 경우.
				if(currentNode == this._head){ //찾은 노드가 head일 경우.
					// head가 그냥 다음 노드를 가리키도록 한다.
					this._head = currentNode.next();
				}
				else{ //찾은 노드가 head가 아닐 경우.
					// 현재 노드를 삭제해야 하므로 이전 노드에서 다음 노드를 가리키는 next를 연결.
					previousNode.setNext(currentNode.next());
				}
				
				this._size--;
				return true;
			}
		}
	}
	
	public Element removeAny(){ //비어있지 않으면 맨 앞 노드의 코인 값을 삭제.
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
	
	public Element elementAt(int anOrder){ // 입력받은 숫자에 맞는 위치의 element값을 출력한다.
		if(isEmpty() || anOrder < 0 || this._size <= anOrder){ // 비어있거나 입력받은 숫자가 0보다 작거나 입력받은 숫자가 size보다 클 경우
			return null; // null 출력.
		}
		else{
			Node<Element> returnNode = this._head;
			for(int i = 0; i < anOrder; i++){ // 입력받은 숫자까지 돌아서 returnNode값이 입력받은 위치의 element값을 출력하도록 만듦.
				returnNode = returnNode.next();
			}
			return returnNode.element();
		}
		
	}
	
	public void clear(){ // 비운다.
		this._size = 0;
		this._head = null;
		
	}

}
