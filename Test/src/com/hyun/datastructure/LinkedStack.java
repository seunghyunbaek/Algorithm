package com.hyun.datastructure;

public class LinkedStack implements Stack {
	/*
	 * List�� Ȱ���Ͽ� Stack�� �����մϴ�. 
	 * ������ ������ ��α�: https://songeunjung92.tistory.com/18
	 */

	StackNode top; // ���ÿ� �����Ǵ� ���

	public LinkedStack() {
		this.top = null;
	}

	@Override
	public boolean isEmpty() {
		return (top == null);
	}

	@Override
	public void push(char item) {
		StackNode node = new StackNode();
		node.item = item;
		node.next = top;
		top = node;
	}

	@Override
	public char pop() {
		if (isEmpty()) {
			return 0;
		} else {
			StackNode node = top;
			top = node.next;
			return node.item;
		}
	}

	@Override
	public void delete() {
		if(isEmpty()) {
			return;
		} else {
			top = top.next;
		}
	}

	@Override
	public char peek() {
		if(isEmpty()) {
			return 0;
		} else {
			return top.item;
		}
	}
}
