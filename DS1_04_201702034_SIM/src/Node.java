
public class Node<Element> { // Node�� ��ü�� ���� ��.
	
	private Element _Element; // ���� ��忡 �ִ� ����.
	private Node <Element> _next; // ���� ���.
	
	public Node(){ // ������.
		this._Element = null;
		this._next = null;
	}
	
	public Node(Element givenElement){ // ���� ��带 �Է� �޾��� ���� ������.
		this._Element = givenElement;
		this._next = null;
	}
	
	public Node(Element givenElement, Node<Element> givenNext){ // ���� ���� ���� ��带 �Է� �޾��� ���� ������.
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
