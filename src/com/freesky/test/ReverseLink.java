package com.freesky.test;

public class ReverseLink {

	public static void main(String[] args) {
		ListNode source = new ListNode(1);
		ListNode n2 = new ListNode(2);
		source.next = n2;
		ListNode n3 = new ListNode(3);
		n2.next = n3;
		ListNode n4 = new ListNode(4);
		n3.next = n4;
		
		printListNode(source);
		
		ListNode rev = reverseListNode(source);
		printListNode(rev);

	}
	
	public static ListNode reverseListNode(ListNode source) {
		if (source.next == null) {
			return source;
		}
		
		ListNode dest = null;
		ListNode last = source;
		ListNode pre = null;
		while (last.next != null) {
			pre = last;
			last = last.next;
		}
		
		dest = last;
		dest.next = pre;
		ListNode node = pre;
		ListNode begin = source;
		if (source.next != pre) {
			ListNode temp = node;
			ListNode current = pre;
			while (current != source) {
				temp = findPre(source, temp);
				current.next = temp;
				current = temp;
			}
			current.next = null;
			
		} else {
			pre.next = begin;
			begin.next = null;
		}
		
		
		return dest;
	}
	
	public static ListNode findPre(ListNode source, ListNode node) {
		ListNode pre = source;
		while (pre.next != node) {
			pre = pre.next;
		}
		
		return pre;
	}

	public static void printListNode(ListNode source) {
		ListNode node = source;
		while (node != null) {
			System.out.print(node.val);
			System.out.print(" ");
			node = node.next;
		}
		System.out.println();
	}
	
}
