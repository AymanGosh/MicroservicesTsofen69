package linkedlists;


public class MiddleElement {

	
	
	private static int getLenght(Node head)
	{
		int len=0;
		if(head == null)
			return 0;
		if(head.next == null)
			return 1;
		Node curr = head ;
		while(curr.next != null)
		{
			len +=1;
			curr =curr.next;
		}
		
		return len;
	}
	
	
	private static Node getMiddleNode(Node head)
	{
		int len= getLenght(head);
		int index=0;
		Node curr = head;
		while(index != len/2)
		{
			index = index +1;
			curr = curr.next;
		}
		
		curr.next =null;
		return curr;
	}
	
	
    private static Node initList(int[] list) {

        Node head = null;
        Node prev = null;

        for (int i : list) {
            Node curr = new Node();
            curr.val = i;
            if (head == null) {
                head = curr;
            } else {
                prev.next = curr;
            }
            prev = curr;
        }

        return head;
    }

    private static void printList(Node result) {
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

	
	public static void main(String[] args) {
		 Node head = initList(new int[]{1,2,3,4,5,6});
	        Node result = getMiddleNode(head);
	        printList(result);
	}
	
	
}
class Node
{
	int val ;
	Node next;
}

