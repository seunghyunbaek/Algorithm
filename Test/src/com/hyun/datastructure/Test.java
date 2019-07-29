package com.hyun.datastructure;

import java.util.ArrayList;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		// �߰��� �бⰡ ������ ����� ������ ���� ����
		// (((()())(())()))
		// �� ���ȿ� ª������ �� �������°� ��� �ؾ��ұ�

		// �Է¹ޱ����� ��ĳ��
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine(); // ()(((()())(())()))(())

		// stack ����
		LinkedStack stack = new LinkedStack();

		int isPoint = 0; // 0: �ƹ��͵� �ƴѻ���, 1: point�� �� �� �ִ»���, 2: point�� �ϼ��Ȼ���

		int pointCnt = 0;

		int total = 0;
		int total2 = 0;
		
		ArrayList<Integer> list = new ArrayList<>();
		int lidx = 0;

		for (int i = 0; i < s.length(); i++) {
			if (i > 0 && stack.isEmpty()) {
				pointCnt = 0;
			}

			if (s.charAt(i) == '(') {
				if(i > 0 && isPoint == 0) {
					list.add(0);
					lidx++;
				}
				stack.push(s.charAt(i));
				isPoint = 1; // ������ ')'�� ������ ����Ʈ�� �ȴ�
			} else {
				stack.pop();
				if (isPoint == 0) {
					total = total + pointCnt + 1;
					total2 = total2 + list.get(lidx) + 1;
					list.remove(lidx);
					lidx--;
				}
				if (isPoint == 1) { // isPoint�� true�����϶� : ������ ���� �� �ִ� ����
					isPoint = 2; // ���� ��������� ������ push�� �Ͼ�� ���� ���� ���� �� ���� ���°� ��
				}
			}

			if (isPoint == 2) { // point�� �ϼ��Ǿ��� ��
				isPoint = 0; // �ƹ��͵� �ƴ� ����
				pointCnt++;
				
				if(list.size() == 0) {
					list.add(pointCnt);
				} else {					
					list.set(lidx, pointCnt);
				}
				// ����Ʈ �ϼ��Ǿ����� ���� �� �� �ִ� stack�� �˾ƾ��ϳ�
			}
		}

		
//		System.out.println(total);
		System.out.println(total2+1);

		// ()(((()())(())()))(())
	} // main
} // class



//package com.hyun.datastructure;
//
//import java.util.Scanner;
//
//public class Test {
//
//	public static void main(String[] args) {
//		// �߰��� �бⰡ ������ ����� ������ ���� ����
//		// (((()())(())()))
//
//		// �Է¹ޱ����� ��ĳ��
//		Scanner sc = new Scanner(System.in);
//		String s = sc.nextLine(); // ()(((()())(())()))(())
//
//		// stack ����
//		LinkedStack stack = new LinkedStack();
//
//		int isPoint = 0; // 0: �ƹ��͵� �ƴѻ���, 1: point�� �� �� �ִ»���, 2: point�� �ϼ��Ȼ���
//
//		int pointCnt = 0;
//
//		int total = 0;
//
//		for (int i = 0; i < s.length(); i++) {
//			if (i > 0 && stack.isEmpty()) {
//				pointCnt = 0;
//			}
//
//			if (s.charAt(i) == '(') {
//				stack.push(s.charAt(i));
//				isPoint = 1; // ������ ')'�� ������ ����Ʈ�� �ȴ�
//			} else {
//				stack.pop();
//				if (isPoint == 0) {
//					total = total + pointCnt + 1;
//				}
//				if (isPoint == 1) { // isPoint�� true�����϶� : ������ ���� �� �ִ� ����
//					isPoint = 2; // ���� ��������� ������ push�� �Ͼ�� ���� ���� ���� �� ���� ���°� ��
//				}
//			}
//
//			if (isPoint == 2) { // point�� �ϼ��Ǿ��� ��
//				isPoint = 0; // �ƹ��͵� �ƴ� ����
//				pointCnt++;
//				// ����Ʈ �ϼ��Ǿ����� ���� �� �� �ִ� stack�� �˾ƾ��ϳ�
//			}
//		}
//
//		
//		System.out.println(total);
//
//		// ()(((()())(())()))(())
//	} // main
//} // class

//package com.hyun.datastructure;
//
//import java.util.Scanner;
//
//public class Test {
//
//	public static void main(String[] args) { 
//		// �߰��� �бⰡ ������ ����� ������ ���� ����
//		// (((()())(())()))
//
//		// �Է¹ޱ����� ��ĳ��
//		Scanner sc = new Scanner(System.in);
//		String s = sc.nextLine(); // ()(((()())(())()))(())
//
//		// stack ����
//		LinkedStack stack = new LinkedStack();
//		LinkedStack2 lineStack = new LinkedStack2();
//		LinkedStack pointStack = new LinkedStack();
//
//		int isPoint = 0; // 0: �ƹ��͵� �ƴѻ���, 1: point�� �� �� �ִ»���, 2: point�� �ϼ��Ȼ���
//
//		int pointCnt = 0;
//
//		int total = 0;
//		int total2 = 0;
//
//		for (int i = 0; i < s.length(); i++) {
//			if (i > 0 && stack.isEmpty()) {
//				boolean once = true;
////				System.out.println(pointCnt);
//				while (!lineStack.isEmpty()) {
//					if (once) {
//						total = total + lineStack.pop() * 2;
//						once = false;
//					} else {
//						total = total + lineStack.pop();
//					}
//				}
//				pointCnt = 0;
//			}
//
//			if (s.charAt(i) == '(') {
//				stack.push(s.charAt(i));
//				isPoint = 1; // ������ ')'�� ������ ����Ʈ�� �ȴ�
//			} else {
//				stack.pop();
//				if(isPoint == 0) {
//					total2 = total2 + pointCnt + 1;
//				}
//				if (isPoint == 1) { // isPoint�� true�����϶� : ������ ���� �� �ִ� ����
//					isPoint = 2; // ���� ��������� ������ push�� �Ͼ�� ���� ���� ���� �� ���� ���°� ��
//				}
//			}
//
//			if (isPoint == 2) { // point�� �ϼ��Ǿ��� ��
//				isPoint = 0; // �ƹ��͵� �ƴ� ����
//				pointCnt++;
//				// ����Ʈ �ϼ��Ǿ����� ���� �� �� �ִ� stack�� �˾ƾ��ϳ�
//				lineStack.push(/* �� ���� */stack.idx); // �� ���� ��� ������ ������ �Ǵ���
//			}
//		}
//
//
//		boolean once = true;
//
//		while (!lineStack.isEmpty()) {
//			if (once) {
//				total = total + lineStack.pop() * 2;
//				once = false;
//			} else {
//				total = total + lineStack.pop();
//			}
//		}
//
//		System.out.println(total);
//		total2 = total2 + pointCnt;
//		System.out.println(total2);
//
//		// ()(((()())(())()))(())
//	} // main
//} // class

//package com.hyun.datastructure;
//
//import java.util.Scanner;
//
//public class Test {
//
//	public static void main(String[] args) { 
//		// �߰��� �бⰡ ������ ����� ������ ���� ����
//		// (((()())(())()))
//
//		// �Է¹ޱ����� ��ĳ��
//		Scanner sc = new Scanner(System.in);
//		String s = sc.nextLine(); // ()(((()())(())()))(())
//
//		// stack ����
//		LinkedStack stack = new LinkedStack();
//		LinkedStack2 lineStack = new LinkedStack2();
//		LinkedStack pointStack = new LinkedStack();
//
//		int isPoint = 0; // 0: �ƹ��͵� �ƴѻ���, 1: point�� �� �� �ִ»���, 2: point�� �ϼ��Ȼ���
//
////		int pointCnt = 0;
//
//		int total = 0;
//
//		for (int i = 0; i < s.length(); i++) {
//			if (i > 0 && stack.isEmpty()) {
//				boolean once = true;
////				System.out.println(pointCnt);
//				while (!lineStack.isEmpty()) {
//					if (once) {
//						total = total + lineStack.pop() * 2;
//						once = false;
//					} else {
//						total = total + lineStack.pop();
//					}
//				}
////				pointCnt = 0;
//			}
//
//			if (s.charAt(i) == '(') {
//				stack.push(s.charAt(i));
//				isPoint = 1; // ������ ')'�� ������ ����Ʈ�� �ȴ�
//			} else {
//				stack.pop();
//				if(isPoint == 0) {
//					
//				}
//				if (isPoint == 1) { // isPoint�� true�����϶� : ������ ���� �� �ִ� ����
//					isPoint = 2; // ���� ��������� ������ push�� �Ͼ�� ���� ���� ���� �� ���� ���°� ��
//				}
//			}
//
//			if (isPoint == 2) { // point�� �ϼ��Ǿ��� ��
//				isPoint = 0; // �ƹ��͵� �ƴ� ����
////				pointCnt++;
//				// ����Ʈ �ϼ��Ǿ����� ���� �� �� �ִ� stack�� �˾ƾ��ϳ�
//				lineStack.push(/* �� ���� */stack.idx); // �� ���� ��� ������ ������ �Ǵ���
//			}
//		}
//
////		int total = lineStack.pop() * 2;
////		while (!lineStack.isEmpty()) {
////			total += lineStack.pop();
////		}
//
//		boolean once = true;
////		System.out.println(pointCnt);
//		while (!lineStack.isEmpty()) {
//			if (once) {
//				total = total + lineStack.pop() * 2;
//				once = false;
//			} else {
//				total = total + lineStack.pop();
//			}
//		}
//
//		System.out.println(total);
////		int min = Integer.MAX_VALUE;
////		
////		StackNode2 tmp = lineStack.top;
////		while (tmp != null) {
////			min = Math.min(min, tmp.item);
////			tmp = tmp.next;
////		}
////		
////		int total = 0;
////		while(!lineStack.isEmpty()) {
////			total = total + lineStack.pop()*2;
////		}
////		total = total + min;
////		System.out.println(total);
//
//		// ()(((()())(())()))(())
//	} // main
//} // class

//package com.hyun.datastructure;
//
//import java.util.Scanner;
//import java.util.Stack;
//
//public class Test {
//
//	public static void main(String[] args) {
//
//		// �Է¹ޱ����� ��ĳ��
//		Scanner sc = new Scanner(System.in);
//		String s = sc.nextLine(); // ()(((()())(())()))(())
//
//		// stack ����
//		LinkedStack stack = new LinkedStack();
//		LinkedStack lineStack = new LinkedStack();
//		LinkedStack pointStack = new LinkedStack();
//
//		int isPoint = 0; // 0: �ƹ��͵� �ƴѻ���, 1: point�� �� �� �ִ»���, 2: point�� �ϼ��Ȼ���
//		
//		int pointCnt = 0;
//
//		for (int i = 0; i < s.length(); i++) {
//			if (i > 0 && stack.isEmpty()) {
//				System.out.println(pointCnt);
//				pointCnt = 0;
//			}
//
//			if (s.charAt(i) == '(') {
//				stack.push(s.charAt(i));
//				isPoint = 1; // ������ ')'�� ������ ����Ʈ�� �ȴ�
//			} else {
//				stack.pop();
//				if (isPoint == 1) { // isPoint�� true�����϶� : ������ ���� �� �ִ� ����
//					isPoint = 2; // ���� ��������� ������ push�� �Ͼ�� ���� ���� ���� �� ���� ���°� ��
//				}
//			}
//
//			if (isPoint == 2) { // point�� �ϼ��Ǿ��� ��
//				isPoint = 0; // �ƹ��͵� �ƴ� ����
//				pointCnt++;
//				// ����Ʈ �ϼ��Ǿ����� ���� �� �� �ִ� stack�� �˾ƾ��ϳ�
////				lineStack.push(/*�� ����*/stack.idx); // �� ���� ��� ������ ������ �Ǵ���
//			}
//		}
//		
//		System.out.println(pointCnt);
//
//		// ()(((()())(())()))(())
//	} // main
//} // class
