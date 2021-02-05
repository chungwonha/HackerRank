package com.chung.hackerrank.solution.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	static class SinglyLinkedListNode {
		public int data;
		public SinglyLinkedListNode next;

		public SinglyLinkedListNode(int nodeData) {
			this.data = nodeData;
			this.next = null;
		}
	}

	static class SinglyLinkedList {
		public SinglyLinkedListNode head;
		public SinglyLinkedListNode tail;

		public SinglyLinkedList() {
			this.head = null;
			this.tail = null;
		}

		public void insertNode(int nodeData) {
			SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

			if (this.head == null) {
				this.head = node;
			} else {
				this.tail.next = node;
			}

			this.tail = node;
		}
	}

	public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep) {
		while (node != null) {
			System.out.print(node.data);

			node = node.next;

			if (node != null) {
				System.out.print(sep);
			}
		}
	}


	static SinglyLinkedListNode buildLinkedList(int[] arr){
		SinglyLinkedList llist = new SinglyLinkedList();
		for (int i = 0; i < arr.length; i++) {
			llist.insertNode(arr[i]);
		}

		return llist.head;
	}
	static void reversePrint(SinglyLinkedListNode head) {
		SinglyLinkedListNode currentNode = head;
		SinglyLinkedListNode nextNode;

		ArrayList<Integer> elements = new ArrayList<>();

		while(currentNode!=null) {
			elements.add(currentNode.data);
			nextNode = currentNode.next;
			currentNode = nextNode;
		}

		for(int j=elements.size()-1;j>=0;j--){
			System.out.println(elements.get(j));
		}
	}

}
