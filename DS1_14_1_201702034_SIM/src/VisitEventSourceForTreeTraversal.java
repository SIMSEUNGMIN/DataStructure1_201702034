
public interface VisitEventSourceForTreeTraversal<Key, Obj> {
	
	public void visitByCallBack(DictionaryElement<Key, Obj> anElement, int aLevel);
	public void visitForReverseOfInorder(DictionaryElement<Key, Obj> anElement, int aLevel);
}
