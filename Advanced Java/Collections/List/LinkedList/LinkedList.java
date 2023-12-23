package linkedlists;

import java.util.Stack;

public class LinkedList {

	Node head;

	static class Node {
		int value;
		Node next;

		public Node(int value) {
			this.value = value;
		}
	}

	public static LinkedList insertNode(LinkedList list, int newVal) {

		Node newNode = new Node(newVal);
		newNode.next = null;
		if (list.head == null) {
			list.head = newNode;
		} else {
			// find last node , after that node please add the new node
			Node lastNode = list.head;
			while (lastNode.next != null) {
				lastNode = lastNode.next;
			}

			lastNode.next = newNode;
		}
		return list;
	}

	public static LinkedList insertNodeInPosition(LinkedList list, int n, int value) throws Exception {

		Node newNode = new Node(value);
		newNode.next = null;
		Node curr = list.head;
		Node next = null;
		if (list.head == null && n == 0) {
			list.head.next = newNode;
		}

		int counter = 0;
		while (counter < n) {
			curr = curr.next;
			counter++;
		}

		next = curr.next;
		curr.next = newNode;
		newNode.next = next;

		return list;
	}

	public static LinkedList deleteNode(LinkedList list, int value) {
		if (list.head == null) {
			return list;
		}
		Node curr = list.head, prev = null;
		if (curr != null && curr.value == value) {
			list.head = curr.next;
			return list;
		}

		while (curr != null && curr.value != value) {
			prev = curr;
			curr = curr.next;
		}
		return list;
	}

	public static LinkedList deleteTheNthNode(LinkedList list, int n) {
		Node nth = list.head;
		Node prev = null;
		int counter = 0;

		if (list.head == null) {
			return list;
		}

		while (counter < n) {
			prev = nth;
			nth = nth.next;
			counter++;
		}

		prev.next = nth.next;
		nth = nth.next;
		return list;
	}

	public static boolean isPalindrome(LinkedList list) {
		boolean result = true;
		Stack<Integer> nodeStack = new Stack<>();
		Node curr = list.head;
		while (curr.next != null) {
			nodeStack.push(curr.value);
			curr = curr.next;
		}

		curr = list.head;
		while (curr.next != null) {
			if (nodeStack.pop() != curr.value) {
				result = false;
			}
		}

		return result;

	}

	public static void reverseLK(LinkedList list) {
		Node prev = null;
		Node next = null;
		Node curr = list.head;

		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		list.head = prev;
	}

	public static void print(LinkedList list) {
		Node currNode = list.head;
		System.out.print("head");
		while (currNode != null) {

			System.out.print("-->" + currNode.value);
			currNode = currNode.next;
		}
	}

	public static LinkedList mergeTwoSortedLK(LinkedList list1, LinkedList list2) {
		LinkedList merge = new LinkedList();
		Node idx1 = list1.head, idx2 = list2.head;

		while (idx1 != null || idx2 != null) {
			if (idx1.value >= idx2.value) {
				insertNode(merge, idx2.value);
				insertNode(merge, idx1.value);
			} else {
				insertNode(merge, idx1.value);
				insertNode(merge, idx2.value);
			}
			idx1 = idx1.next;
			idx2 = idx2.next;
		}

		return merge;
	}
	
	public static LinkedList insertNodeq(LinkedList list, int newVal) {

		Node newNode = new Node(newVal);
		newNode.next = null;
		if (list.head == null) {
			list.head = newNode;
		} else {
			// find last node , after that node please add the new node
			Node lastNode = list.head;
			while (lastNode.next != null) {
				lastNode = lastNode.next;
			}

			lastNode.next = newNode;
		}
		return list;
	}

	public static void main(String[] args) throws Exception {
		LinkedList list = new LinkedList();
		LinkedList.insertNode(list, 1);
		LinkedList.insertNode(list, 3);
		LinkedList.insertNode(list, 5);
		LinkedList.insertNode(list, 6);
		LinkedList.insertNode(list, 9);

		LinkedList list2 = new LinkedList();
		LinkedList.insertNode(list2, 2);
		LinkedList.insertNode(list2, 2);
		LinkedList.insertNode(list2, 3);
		LinkedList.insertNode(list2, 7);
		LinkedList.insertNode(list2, 10);

		LinkedList merge = LinkedList.mergeTwoSortedLK(list, list2);
		print(merge);
		/*
		 * insertNodeInPosition(list, 2, 8); System.out.println(); print(list);
		 */
		/*
		 * insertNodeInPosition(list, 1, 9); System.out.println(); print(list);
		 * insertNodeInPosition(list, 2, 5); print(list); deleteTheNthNode(list,2);
		 * System.out.println(); print(list);
		 */
	}

}
