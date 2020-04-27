public class SListNode{
	Object item; 
	SListNode next;


	public SListNode(Object obj){
		item = obj; 
		next = null;
	}

	public SListNode(Object obj, SListNode next){
		item = obj; 
		this.next = next;
	}
}