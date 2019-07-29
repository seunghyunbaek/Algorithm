package com.hyun.datastructure;

import java.util.ArrayList;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		// 중간에 분기가 있으면 제대로 갯수를 세지 못함
		// (((()())(())()))
		// 긴 선안에 짧은선일 때 갯수세는것 어떻게 해야할까

		// 입력받기위한 스캐너
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine(); // ()(((()())(())()))(())

		// stack 생성
		LinkedStack stack = new LinkedStack();

		int isPoint = 0; // 0: 아무것도 아닌상태, 1: point가 될 수 있는상태, 2: point가 완성된상태

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
				isPoint = 1; // 다음에 ')'가 나오면 포인트가 된다
			} else {
				stack.pop();
				if (isPoint == 0) {
					total = total + pointCnt + 1;
					total2 = total2 + list.get(lidx) + 1;
					list.remove(lidx);
					lidx--;
				}
				if (isPoint == 1) { // isPoint가 true상태일때 : 점으로 변할 수 있는 상태
					isPoint = 2; // 점을 만들었으니 다음에 push가 일어나기 전엔 점을 만들 수 없는 상태가 됨
				}
			}

			if (isPoint == 2) { // point가 완성되었을 때
				isPoint = 0; // 아무것도 아닌 상태
				pointCnt++;
				
				if(list.size() == 0) {
					list.add(pointCnt);
				} else {					
					list.set(lidx, pointCnt);
				}
				// 포인트 완성되었을때 선이 될 수 있는 stack을 알아야하네
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
//		// 중간에 분기가 있으면 제대로 갯수를 세지 못함
//		// (((()())(())()))
//
//		// 입력받기위한 스캐너
//		Scanner sc = new Scanner(System.in);
//		String s = sc.nextLine(); // ()(((()())(())()))(())
//
//		// stack 생성
//		LinkedStack stack = new LinkedStack();
//
//		int isPoint = 0; // 0: 아무것도 아닌상태, 1: point가 될 수 있는상태, 2: point가 완성된상태
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
//				isPoint = 1; // 다음에 ')'가 나오면 포인트가 된다
//			} else {
//				stack.pop();
//				if (isPoint == 0) {
//					total = total + pointCnt + 1;
//				}
//				if (isPoint == 1) { // isPoint가 true상태일때 : 점으로 변할 수 있는 상태
//					isPoint = 2; // 점을 만들었으니 다음에 push가 일어나기 전엔 점을 만들 수 없는 상태가 됨
//				}
//			}
//
//			if (isPoint == 2) { // point가 완성되었을 때
//				isPoint = 0; // 아무것도 아닌 상태
//				pointCnt++;
//				// 포인트 완성되었을때 선이 될 수 있는 stack을 알아야하네
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
//		// 중간에 분기가 있으면 제대로 갯수를 세지 못함
//		// (((()())(())()))
//
//		// 입력받기위한 스캐너
//		Scanner sc = new Scanner(System.in);
//		String s = sc.nextLine(); // ()(((()())(())()))(())
//
//		// stack 생성
//		LinkedStack stack = new LinkedStack();
//		LinkedStack2 lineStack = new LinkedStack2();
//		LinkedStack pointStack = new LinkedStack();
//
//		int isPoint = 0; // 0: 아무것도 아닌상태, 1: point가 될 수 있는상태, 2: point가 완성된상태
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
//				isPoint = 1; // 다음에 ')'가 나오면 포인트가 된다
//			} else {
//				stack.pop();
//				if(isPoint == 0) {
//					total2 = total2 + pointCnt + 1;
//				}
//				if (isPoint == 1) { // isPoint가 true상태일때 : 점으로 변할 수 있는 상태
//					isPoint = 2; // 점을 만들었으니 다음에 push가 일어나기 전엔 점을 만들 수 없는 상태가 됨
//				}
//			}
//
//			if (isPoint == 2) { // point가 완성되었을 때
//				isPoint = 0; // 아무것도 아닌 상태
//				pointCnt++;
//				// 포인트 완성되었을때 선이 될 수 있는 stack을 알아야하네
//				lineStack.push(/* 선 개수 */stack.idx); // 이 점이 몇개의 선분을 나누게 되는지
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
//		// 중간에 분기가 있으면 제대로 갯수를 세지 못함
//		// (((()())(())()))
//
//		// 입력받기위한 스캐너
//		Scanner sc = new Scanner(System.in);
//		String s = sc.nextLine(); // ()(((()())(())()))(())
//
//		// stack 생성
//		LinkedStack stack = new LinkedStack();
//		LinkedStack2 lineStack = new LinkedStack2();
//		LinkedStack pointStack = new LinkedStack();
//
//		int isPoint = 0; // 0: 아무것도 아닌상태, 1: point가 될 수 있는상태, 2: point가 완성된상태
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
//				isPoint = 1; // 다음에 ')'가 나오면 포인트가 된다
//			} else {
//				stack.pop();
//				if(isPoint == 0) {
//					
//				}
//				if (isPoint == 1) { // isPoint가 true상태일때 : 점으로 변할 수 있는 상태
//					isPoint = 2; // 점을 만들었으니 다음에 push가 일어나기 전엔 점을 만들 수 없는 상태가 됨
//				}
//			}
//
//			if (isPoint == 2) { // point가 완성되었을 때
//				isPoint = 0; // 아무것도 아닌 상태
////				pointCnt++;
//				// 포인트 완성되었을때 선이 될 수 있는 stack을 알아야하네
//				lineStack.push(/* 선 개수 */stack.idx); // 이 점이 몇개의 선분을 나누게 되는지
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
//		// 입력받기위한 스캐너
//		Scanner sc = new Scanner(System.in);
//		String s = sc.nextLine(); // ()(((()())(())()))(())
//
//		// stack 생성
//		LinkedStack stack = new LinkedStack();
//		LinkedStack lineStack = new LinkedStack();
//		LinkedStack pointStack = new LinkedStack();
//
//		int isPoint = 0; // 0: 아무것도 아닌상태, 1: point가 될 수 있는상태, 2: point가 완성된상태
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
//				isPoint = 1; // 다음에 ')'가 나오면 포인트가 된다
//			} else {
//				stack.pop();
//				if (isPoint == 1) { // isPoint가 true상태일때 : 점으로 변할 수 있는 상태
//					isPoint = 2; // 점을 만들었으니 다음에 push가 일어나기 전엔 점을 만들 수 없는 상태가 됨
//				}
//			}
//
//			if (isPoint == 2) { // point가 완성되었을 때
//				isPoint = 0; // 아무것도 아닌 상태
//				pointCnt++;
//				// 포인트 완성되었을때 선이 될 수 있는 stack을 알아야하네
////				lineStack.push(/*선 개수*/stack.idx); // 이 점이 몇개의 선분을 나누게 되는지
//			}
//		}
//		
//		System.out.println(pointCnt);
//
//		// ()(((()())(())()))(())
//	} // main
//} // class
