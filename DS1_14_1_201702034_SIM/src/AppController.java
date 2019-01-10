
public class AppController implements VisitEventSourceForTreeTraversal<Integer, Integer> {
	
	private static final int DEFAULT_DATA_SIZE = 20;
	
	private AppView _appView;
	private DictionaryByBinarySearchTree<Integer, Integer> _dictionary;
	private int[] _list;
	
	public AppController(){
		this._appView = new AppView();
	}
	
	public void run(){
		
		this._list = DataGenerator.randomList(DEFAULT_DATA_SIZE);
		
		this._appView.outputLine("<< 삽입 과정에서의 이진검색트리의 변화 >>");
		this._dictionary = new DictionaryByBinarySearchTree<Integer, Integer>();
		
		this._dictionary.setVisitEvent(this);
		
		this.addToBinarySearchTreeAndShowShape();
		this.showInorderOfBinaryScearchTree();
		this.reomoveFromBinarySearchTreeAndShowShape();
		
	}
	
	private void addToBinarySearchTreeAndShowShape(){
		for(int i = 0; i < DEFAULT_DATA_SIZE; i++){
			this._dictionary.addKeyAndObject(this._list[i], i);
			this._appView.outputLine(String.format("%d(%d) 원소를 삽입한 후의 이진검색트리 : ", this._list[i], i));
			this._dictionary.scanReverseOfSortedOrder();
		}
	}
	
	private void showInorderOfBinaryScearchTree(){
		this._appView.outputLine("<<Inorder Traversal>>");
		this._dictionary.scanInSortedOrder();
	}
	
	private void reomoveFromBinarySearchTreeAndShowShape(){
		this._appView.outputLine("<<삭제 과정에서의 이진검색트리의 변화 >>");
		
		for(int i = 0; i < DEFAULT_DATA_SIZE; i++){
			this._dictionary.removeObjectForKey(this._list[i]);
			this._appView.outputLine(String.format("Key값이 %d인 원소를 삭제한 후의 이진검색트리: ", this._list[i]));
			this._dictionary.scanReverseOfSortedOrder();
		}
	}
	
	@Override
	public void visitByCallBack(DictionaryElement<Integer, Integer> anElement, int aLevel) {
		for(int i = 0; i < aLevel; i++){
			this._appView.output("   ");
		}
		this._appView.outputLine(String.format("%4d(%2d)", anElement.key(), anElement.object()));
	}

	@Override
	public void visitForReverseOfInorder(DictionaryElement<Integer, Integer> anElement, int aLevel) {
		for(int i = 0; i < aLevel; i++){
			this._appView.output("      ");
		}
		this._appView.outputLine(String.format("%4d(%2d)", anElement.key(), anElement.object()));
	}
	
	
}
