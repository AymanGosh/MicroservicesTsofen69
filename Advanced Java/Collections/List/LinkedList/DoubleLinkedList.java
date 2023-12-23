package linkedlists;

public class DoubleLikedList {

	public static Node head,tail=null ;
	
	class Node{
		int data;
		Node next;
		Node prev;
		
		
		public Node(int data) {
				this.data =data;
				next = null;
				prev = null;
		}
	}
	
	
	public boolean isEmpty() {
		return (head == null);
	}
	
	
	
	public void insertNodeAtEnd (Node node )
	{
		if(head == null)
		{
			head =tail= node;
			node.next=node.prev=null;
		}else {
			tail.next = node;
			node.prev = tail;
			tail = node;
			tail.next =null;
		}
	}
	
	
	public void insertNodeFirst(Node node)
	{
		if(head == null)
			head = node;
		
		head.prev = node;
		node.next = head;
		node.prev= null;
		head = node;
	}
	
	
	public void deleteNodeFirst ( )
	{
		if(head == null)
			System.out.println("the linked list is null!!");
		
		head = head.next;
		head.prev =null;
	}
	 public void deleteNodeLast()
	 {
		 tail = tail.prev;
	 }
	
}
