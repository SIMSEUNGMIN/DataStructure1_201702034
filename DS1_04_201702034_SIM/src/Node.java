
public class Node<Element> { // Node를 객체로 만든 것.
	
	private Element _Element; // 현재 노드에 있는 코인.
	private Node <Element> _next; // 다음 노드.
	
	public Node(){ // 생성자.
		this._Element = null;
		this._next = null;
	}
	
	public Node(Element givenElement){ // 현재 노드를 입력 받았을 때의 생성자.
		this._Element = givenElement;
		this._next = null;
	}
	
	public Node(Element givenElement, Node<Element> givenNext){ // 현재 노드와 다음 노드를 입력 받았을 때의 생성자.
		this._Element = givenElement;
		this._next = givenNext;
	}
	
	public Element element(){ // getter.
		return this._Element;
	}
	
	public Node<Element> next(){ // getter.
		return this._next;
	}
	
	public void setElement(Element anElement){
		this._Element = anElement; // setter.
	}
	
	public void setNext(Node<Element> aNext){
		this._next = aNext; // setter.
	}
}
