
public class Node<E> { // Node를 객체로 만든 것.

	private E _Element; // 현재 노드에 있는 코인.
	private Node <E> _next; // 다음 노드.

	public Node(){ // 생성자.
		this._Element = null;
		this._next = null;
	}

	public Node(E givenElement){ // 현재 노드를 입력 받았을 때의 생성자.
		this._Element = givenElement;
		this._next = null;
	}

	public Node(E givenElement, Node<E> givenNext){ // 현재 노드와 다음 노드를 입력 받았을 때의 생성자.
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
