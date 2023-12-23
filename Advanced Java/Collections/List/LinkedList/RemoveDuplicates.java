package linkedlists;

public class RemoveDuplicates {


/**
 * Given a head of sorted list, remove all duplicates.
 * Return the list to the sorted list head.
 *
 * Examples:
 * 1.
 * Input: head = [1,1,2,3,3]
 * Output: [1,2,3]
 * 2.
 * Input: head = [1,1,2]
 * Output: [1,2]
 *
 * 
 */

    private static ListNode removeDuplicates(ListNode head) {
          ListNode curr =head; 
          if(curr ==null || curr.next ==null)
        	  return curr;
          while(curr.next !=null)
          {
        	  if(curr.val == curr.next.val)
        	  {
        		  curr.next =curr.next.next;
        	  }else {
        		  curr= curr.next;
        	  }
        	  
        
          }
        
        return head;
    }

    public static void main(String args[]) {

        ListNode head = initList(new int[]{1,2,2,2,3,4,4});
        ListNode result = removeDuplicates(head);
        printList(result);
    }

    private static ListNode initList(int[] list) {

        ListNode head = null;
        ListNode prev = null;

        for (int i : list) {
            ListNode curr = new ListNode();
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

    private static void printList(ListNode result) {
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

}



class ListNode {
    int val;
    ListNode next;
}

