package com.freesky.test;

import java.util.ArrayList;
import java.util.List;

public class ReverseLinkOperation {

	public static void main(String[] args) {
//		testReverseListNode();
		
//		testCircle();
		
//		testMergeLink();
		
//		testDelete();
		
		testFindMiddle();
	}
	
	public static void testFindMiddle() {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		n1.next = n2;
		ListNode n3 = new ListNode(3);
		n2.next = n3;
		ListNode n4 = new ListNode(4);
		n3.next = n4;
		ListNode n5 = new ListNode(5);
		n4.next = n5;
		
		printListNode(n1);
//		ListNode middle = findMiddle(n1);
		ListNode middle = findMiddle2(n1);
		System.out.println(middle.val);
	}
	
	/**
	 * spend less time, occupy more space
	 * @param source
	 * @return
	 */
	public static ListNode findMiddle(ListNode source) {
		List<ListNode> nodeList = new ArrayList<>();
		ListNode node = source;
		while (node != null) {
			nodeList.add(node);
			node = node.next;
		}
		
		return nodeList.get(nodeList.size() / 2);
	}
	
	/**
	 * less space, more time
	 * @param source
	 * @return
	 */
	public static ListNode findMiddle2(ListNode source) {
		int length = 1;
		ListNode node = source;
		while (node.next != null) {
			length++;
			node = node.next;
		}
		
		if (length < 3) {
			return source;
		}
		
		int i = length / 2;
		ListNode begin = null;
		while (i > 0) {
			begin = source;
			while (begin.next != node) {
				begin = begin.next;
			}
			node = begin;
			
			i--;
		}
		
		return node;
	}
	
	
	
	public static void testDelete() {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		n1.next = n2;
		ListNode n3 = new ListNode(3);
		n2.next = n3;
		ListNode n4 = new ListNode(4);
		n3.next = n4;
		
//		ListNode deleted = deleteNode(n1, 2);
//		ListNode deleted = deleteNode2(n1, 0);
		ListNode deleted = deleteNode3(n1, -1);
		printListNode(deleted);
	}
	
	
	public static ListNode deleteNode(ListNode source, int n) {
		// delete the last n node
		// {1 2 3 4 5 6} if n =2, then
		// {1 2 3 4}
		if (n <= 0) {
			return source;
		}
		ListNode temp = source;
		while (temp.next != null) {
			if (temp.next.next == null) {
				temp.next = null;
				if (n == 1) {
					return source;
				} else {
					return deleteNode(source, n-1);
				}
			}
			temp = temp.next;
		}
		
		return source;
	}
	
	public static ListNode deleteNode2(ListNode source, int n) {
		// delete the reversed n-th node
		// {1 2 3 4 5 6} if n =2, then
		// {1 2 3 4 6}
		if (n <= 0) {
			return source;
		}
		
		List<ListNode> nodeList = new ArrayList<>();
		ListNode node = source;
		while (node != null) {
			nodeList.add(node);
			node = node.next;
		}
		
		int size = nodeList.size();
		if (n > size) {
			return source;
		}
		if (n == size) {
			return nodeList.get(1);
		}
		
		nodeList.get(size - n - 1).next = nodeList.get(size - n).next;
		
		return source;
	}
	
	public static ListNode deleteNode3(ListNode source, int n) {
		// delete the reversed n-th node
		// {1 2 3 4 5 6} if n =2, then
		// {1 2 3 4 6}
		if (n <= 0) {
			return source;
		}
		
		int i = n;
		ListNode flag = null;
		ListNode tail = null;
		while (i > 0) {
			tail = source;
			while (tail.next.next != flag) {
				tail = tail.next;
				if (tail.next == null) {
					if (i == 1) {
						return flag;
					}
					return source;
				}
			}
			flag = tail.next;
			i--;
		}
		
		if (i == 0) {
			tail.next = tail.next.next;
		}
		
		return source;
	}
	
	
	public static void testMergeLink() {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		ListNode n6 = new ListNode(6);
		ListNode n7 = new ListNode(7);
		ListNode n8 = new ListNode(8);
		ListNode n9 = new ListNode(9);
		
		n1.next = n3;
		n3.next = n5;
		n5.next = n7;
		
		n2.next = n4;
		n4.next = n6;
		n6.next = n8;
		n8.next = n9;
		
		ListNode merged = mergeLink(n2, n1);
		printListNode(merged);
	}
	
	public static ListNode mergeLink(ListNode node1, ListNode node2) {
		// 1 3 5 7
		// 2 4 6 8 9
		ListNode n1 = node1;
		ListNode n2 = node2;
		ListNode merged = null;
		
		if (n1.val < n2.val) {
			merged = n1;
			if (n1.next != null) {
				n1 = n1.next;
			}
		} else {
			merged = n2;
			if (n2.next != null) {
				n2 = n2.next;
			}
		}
		
		ListNode temp = merged;
		
		while (n1 != null || n2 != null) {
			
			if (n1 == null) {
				temp.next = n2;
				break;
			}
			if (n2 == null) {
				temp.next = n1;
				break;
			}
			
			if (n1.val < n2.val) {
				temp.next = n1;
				temp = n1;

				n1 = n1.next;

			} else {
				temp.next = n2;
				temp = n2;

				n2 = n2.next;

			}
			
		}

		return merged;
	}
	
	public static void testCircle() {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		n1.next = n2;
		ListNode n3 = new ListNode(3);
		n2.next = n3;
		ListNode n4 = new ListNode(4);
		n3.next = n4;
		// circle;
//		n4.next = n2;
		
		List<ListNode> nodeList = new ArrayList<>();
		int i = 0;
		ListNode node = n1;
		while (node != null) {
			if (nodeList.contains(node)) {
				System.out.println("--------There is a circle---------");
				System.out.println(node.val);
				
				nodeList.remove(node);
				break;
			}
			nodeList.add(node);
			i++;
			node = node.next;
		}
		
		if (nodeList.size() == i) {
			System.out.println("--------There is NO circle---------");

			printListNode(n1);
		}
		
	}
	
	public static void testReverseListNode() {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		n1.next = n2;
		ListNode n3 = new ListNode(3);
		n2.next = n3;
		ListNode n4 = new ListNode(4);
		n3.next = n4;
		
		printListNode(n1);
		
		ListNode node = reverseListNode(n1);
		printListNode(node);
	}

	public static ListNode reverseListNode(ListNode source) {
		// empty link or only one node
		if (null == source || null == source.next) {
			return source;
		}
		
		//
		ListNode last = source;
		while (last.next != null) {
			last = last.next;
		}
		
//		// only two nodes
//		if (source.next.next == null) {
//			last.next = source;
//			last.next.next = null;
//			
//			return last;
//		}

		ListNode temp = last;
		ListNode node = source;
		while (temp != source) {
			while (node.next != temp) {
				node = node.next;
			}
			temp.next = node;
			temp = node;
			node = source;
		}
		temp.next = null;
		
		return last;
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
