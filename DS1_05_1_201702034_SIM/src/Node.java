
public class Node<E> { // Node�� ��ü�� ���� ��.

	private E _Element; // ���� ��忡 �ִ� ����.
	private Node <E> _next; // ���� ���.

	public Node(){ // ������.
		this._Element = null;
		this._next = null;
	}

	public Node(E givenElement){ // ���� ��带 �Է� �޾��� ���� ������.
		this._Element = givenElement;
		this._next = null;
	}

	public Node(E givenElement, Node<E> givenNext){ // ���� ���� ���� ��带 �Է� �޾��� ���� ������.
		this._Element = givenElement;
		this._next = givenNext;
	}

	public E element(){ // getter.
		return this._Element;
	}

	public Node<E> next(){ // getter.
		return this._next;
	}

	public void setElement(E anElement){
		this._Element = anElement; // setter.
	}

	public void setNext(Node<E> aNext){
		this._next = aNext; // setter.
	}

}
