package com.hyun.datastructure;

public class LinkedStack implements Stack {
	/*
	 * List를 활용하여 Stack을 구현합니다. 
	 * 구현에 참고한 블로그: https://songeunjung92.tistory.com/18
	 */

	StackNode top; // 스택에 구현되는 노드

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
