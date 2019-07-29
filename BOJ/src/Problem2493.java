import java.util.Scanner;

class Stack {
	int top;
	int[] stack;
	int size;

	public Stack(int size) {
		top = -1;
		stack = new int[size];
		this.size = size;
	}

	public int peek() {
		return stack[top];
	}

	public void push(int value) {
		stack[++top] = value;
	}

	public int pop() {
		return stack[top--];
	}

	public void printStack() {
		System.out.println("-- STACK LIST --");
		for (int i = top; i >= 0; i--)
			System.out.println(stack[i]);
		System.out.println("-- END OF LIST --");
	}

	public int top() {
		return top;
	}

	public int At(int idx) {
		return stack[idx];
	}
}

public class Problem2493 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt(); // 타워갯수 입력받기
		sc.nextLine(); // 입력버퍼 비우기
		String s = sc.nextLine(); // 타워 높이 입력받기

		if (s.equals("")) { // 타워가 없으면 0 출력 후 리턴
			System.out.println(0);
			return;
		}

		String[] sarr = s.split(" "); // 타워 높이 입력받을시 숫자 사이에 공백이 존재하므로 공백을 구분점으로 배열로 값을 얻음

		// 문자열인 배열을 숫자로 바꿔 저장하기
		int[] arr = new int[sarr.length];
		for (int i = 0; i < sarr.length; i++) {
			arr[i] = Integer.parseInt(sarr[i]);
		}

		Stack stack = new Stack(arr.length);
		Stack stack2 = new Stack(arr.length);

		// 배열의 데이터를 스택에 모두 넣어준다. ( 레이저가 왼쪽방향으로만 발사되기에 뒤에서부터 앞으로 오면서 판단해야 된다고 생각함 )
		for (int i = 0; i < arr.length; i++) {
			stack.push(arr[i]);
		}

		for (int j = 0; j < arr.length; j++) { // 모든 타워가 어떤지 체크하기위한 사이클을 만든다
			boolean isReceive = false; // 자기보다 큰 타워가 존재하는지 확인하기 위한 변수
			int peek = stack.pop();
			for (int i = stack.top; i > -1; i--) {
				if (arr[i] > peek) {
					stack2.push(i + 1);
					isReceive = true;
					break;
				}
			}
			if (!isReceive) {
				stack2.push(0);
			}
		}

		for (int i = 0; i < arr.length; i++) {
			System.out.print(stack2.pop() + " ");
		}

	}
}

//import java.util.Scanner;
//
//class Stack {
//	int top;
//	int[] stack;
//	int size;
//
//	public Stack(int size) {
//		top = -1;
//		stack = new int[size];
//		this.size = size;
//	}
//
//	public int peek() {
//		return stack[top];
//	}
//
//	public void push(int value) {
//		stack[++top] = value;
//	}
//
//	public int pop() {
//		return stack[top--];
//	}
//
//	public void printStack() {
//		System.out.println("-- STACK LIST --");
//		for (int i = top; i >= 0; i--)
//			System.out.println(stack[i]);
//		System.out.println("-- END OF LIST --");
//	}
//
//	public int top() {
//		return top;
//	}
//
//	public int At(int idx) {
//		return stack[idx];
//	}
//}
//
//public class Problem2493 {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//		Scanner sc = new Scanner(System.in);
//
//		int n = sc.nextInt(); // 타워갯수 입력받기
//		sc.nextLine(); // 입력버퍼 비우기
//		String s = sc.nextLine(); // 타워 높이 입력받기
//
//		if (s.equals("")) { // 타워가 없으면 0 출력 후 리턴
//			System.out.println(0);
//			return;
//		}
//
//		String[] sarr = s.split(" "); // 타워 높이 입력받을시 숫자 사이에 공백이 존재하므로 공백을 구분점으로 배열로 값을 얻음
//
//		// 문자열인 배열을 숫자로 바꿔 저장하기
//		int[] arr = new int[sarr.length];
//		for (int i = 0; i < sarr.length; i++) {
//			arr[i] = Integer.parseInt(sarr[i]);
//		}
//
//		Stack stack = new Stack(arr.length);
//		Stack stack2 = new Stack(arr.length);
//
//		// 배열의 데이터를 스택에 모두 넣어준다. ( 레이저가 왼쪽방향으로만 발사되기에 뒤에서부터 앞으로 오면서 판단해야 된다고 생각함 )
//		for (int i = 0; i < arr.length; i++) {
//			stack.push(arr[i]);
//		}
//
//		for (int j = 0; j < arr.length; j++) { // 모든 타워가 어떤지 체크하기위한 사이클을 만든다
//			boolean isReceive = false; // 자기보다 큰 타워가 존재하는지 확인하기 위한 변수
//			
//			for (int i = stack.top; i > -1; i--) {
////				if (stack.At(i) > stack.peek()) {
////					stack.pop();
////					stack2.push(i + 1);
////					isReceive = true;
////					break;
////				}
//				if (arr[i] > stack.peek()) {
//					stack.pop();
//					stack2.push(i + 1);
//					isReceive = true;
//					break;
//				}
//			}
//			if (!isReceive) {
//				stack.pop();
//				stack2.push(0);
//			}
//		}
//		
//		for (int i = 0; i < arr.length; i++) {
//			System.out.print(stack2.pop() + " ");
//		}
//
////		for (int i = 0; i < arr.length; i++) {
////			arr[i] = stack2.pop();
////		}
////		for (int i = 0; i < arr.length; i++) {
////			System.out.print(arr[i] + " ");
////		}
//
//	}
//}
