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

		int n = sc.nextInt(); // Ÿ������ �Է¹ޱ�
		sc.nextLine(); // �Է¹��� ����
		String s = sc.nextLine(); // Ÿ�� ���� �Է¹ޱ�

		if (s.equals("")) { // Ÿ���� ������ 0 ��� �� ����
			System.out.println(0);
			return;
		}

		String[] sarr = s.split(" "); // Ÿ�� ���� �Է¹����� ���� ���̿� ������ �����ϹǷ� ������ ���������� �迭�� ���� ����

		// ���ڿ��� �迭�� ���ڷ� �ٲ� �����ϱ�
		int[] arr = new int[sarr.length];
		for (int i = 0; i < sarr.length; i++) {
			arr[i] = Integer.parseInt(sarr[i]);
		}

		Stack stack = new Stack(arr.length);
		Stack stack2 = new Stack(arr.length);

		// �迭�� �����͸� ���ÿ� ��� �־��ش�. ( �������� ���ʹ������θ� �߻�Ǳ⿡ �ڿ������� ������ ���鼭 �Ǵ��ؾ� �ȴٰ� ������ )
		for (int i = 0; i < arr.length; i++) {
			stack.push(arr[i]);
		}

		for (int j = 0; j < arr.length; j++) { // ��� Ÿ���� ��� üũ�ϱ����� ����Ŭ�� �����
			boolean isReceive = false; // �ڱ⺸�� ū Ÿ���� �����ϴ��� Ȯ���ϱ� ���� ����
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
//	public static void LeetCode.main(String[] args) {
//		// TODO Auto-generated method stub
//
//		Scanner sc = new Scanner(System.in);
//
//		int n = sc.nextInt(); // Ÿ������ �Է¹ޱ�
//		sc.nextLine(); // �Է¹��� ����
//		String s = sc.nextLine(); // Ÿ�� ���� �Է¹ޱ�
//
//		if (s.equals("")) { // Ÿ���� ������ 0 ��� �� ����
//			System.out.println(0);
//			return;
//		}
//
//		String[] sarr = s.split(" "); // Ÿ�� ���� �Է¹����� ���� ���̿� ������ �����ϹǷ� ������ ���������� �迭�� ���� ����
//
//		// ���ڿ��� �迭�� ���ڷ� �ٲ� �����ϱ�
//		int[] arr = new int[sarr.length];
//		for (int i = 0; i < sarr.length; i++) {
//			arr[i] = Integer.parseInt(sarr[i]);
//		}
//
//		Stack stack = new Stack(arr.length);
//		Stack stack2 = new Stack(arr.length);
//
//		// �迭�� �����͸� ���ÿ� ��� �־��ش�. ( �������� ���ʹ������θ� �߻�Ǳ⿡ �ڿ������� ������ ���鼭 �Ǵ��ؾ� �ȴٰ� ������ )
//		for (int i = 0; i < arr.length; i++) {
//			stack.push(arr[i]);
//		}
//
//		for (int j = 0; j < arr.length; j++) { // ��� Ÿ���� ��� üũ�ϱ����� ����Ŭ�� �����
//			boolean isReceive = false; // �ڱ⺸�� ū Ÿ���� �����ϴ��� Ȯ���ϱ� ���� ����
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
