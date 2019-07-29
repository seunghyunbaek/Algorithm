package com.hyun.datastructure;

public class LinkedStack2 implements Stack2 {
	/*
	 * List�� Ȱ���Ͽ� Stack�� �����մϴ�. ������ ������ ��α�: https://songeunjung92.tistory.com/18
	 */

	StackNode2 top; // ���ÿ� �����Ǵ� ���
	int idx;

	public LinkedStack2() {
		// ������ ������ ������ ���� ����
		this.top = null;
		idx = 0;
	}

	@Override
	public boolean isEmpty() {
		// ������ ����ִ��� Ȯ���ϴ� �޼ҵ�
		return (top == null);
	}

	@Override
	public void push(int item) {
		// ���ÿ� �����͸� �߰��ϴ� �޼ҵ�
		StackNode2 node = new StackNode2(); // ���ο� ��� ����
		node.item = item; // ������ ��忡 ������ �Է�
		node.next = top; // ������ ����� ������ ����
		top = node; // ������ ��尡 ������ ���� ���� ��ġ
		++idx;
	}

	@Override
	public int pop() {
		// ������ �����͸� ������ �޼ҵ� (���� �����ʹ� ���̻� ���ÿ� �������� ����)
		if (isEmpty()) {
			return 0; // ������ ����� ��� 0�� ����
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
