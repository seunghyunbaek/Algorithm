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

		int n = sc.nextInt();
		sc.nextLine();
		String s = sc.nextLine();

		if (s.equals("")) {
			System.out.println(0);
			return;
		}

		String[] sarr = s.split(" ");

		int[] arr = new int[sarr.length];

		for (int i = 0; i < sarr.length; i++) {
			arr[i] = Integer.parseInt(sarr[i]);
		}

		Stack stack = new Stack(arr.length);
		Stack stack2 = new Stack(arr.length);

		for (int i = 0; i < arr.length; i++) {
			stack.push(arr[i]);
		}

		for (int j = 0; j < arr.length; j++) {
			boolean z = false;
			for (int i = stack.top; i > -1; i--) {
				if (stack.At(i) > stack.peek()) {
					stack.pop();
					stack2.push(i + 1);
					z = true;
					break;
				}
			}
			if (!z) {
				stack.pop();
				stack2.push(0);
			}
		}

		for (int i = 0; i < arr.length; i++) {
			arr[i] = stack2.pop();
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}

	}
}
