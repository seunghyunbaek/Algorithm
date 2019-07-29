package com.hyun.datastructure;

public class LinkedStack2 implements Stack2 {
	/*
	 * List를 활용하여 Stack을 구현합니다. 구현에 참고한 블로그: https://songeunjung92.tistory.com/18
	 */

	StackNode2 top; // 스택에 구현되는 노드
	int idx;

	public LinkedStack2() {
		// 스택을 생성시 스택은 공백 상태
		this.top = null;
		idx = 0;
	}

	@Override
	public boolean isEmpty() {
		// 스택이 비어있는지 확인하는 메소드
		return (top == null);
	}

	@Override
	public void push(int item) {
		// 스택에 데이터를 추가하는 메소드
		StackNode2 node = new StackNode2(); // 새로운 노드 생성
		node.item = item; // 생성한 노드에 데이터 입력
		node.next = top; // 생성한 노드의 다음은 없음
		top = node; // 생성된 노드가 스택의 제일 위의 위치
		++idx;
	}

	@Override
	public int pop() {
		// 스택의 데이터를 꺼내는 메소드 (꺼낸 데이터는 더이상 스택에 남아있지 않음)
		if (isEmpty()) {
			return 0; // 스택이 비었을 경우 0을 리턴
		} else {
			StackNode2 node = top; //
			top = node.next; //
			--idx;
			return node.item; //
		}
	}

	@Override
	public void delete() {
		if (isEmpty()) {
			return;
		} else {
			top = top.next;
			--idx;
		}
	}

	@Override
	public int peek() {
		if (isEmpty()) {
			return 0;
		} else {
			return top.item;
		}
	}

}
