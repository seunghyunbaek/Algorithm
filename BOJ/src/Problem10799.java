import java.util.ArrayList;
import java.util.Scanner;

class StackNode {
	char item;
	StackNode next;
} // StackNode

class LinkedStack {

	StackNode top;
	int size;

	public LinkedStack() {
		this.top = null;
		size = 0;
	}

	public boolean isEmpty() {
		return (top == null);
	}

	public void push(char item) {
		StackNode node = new StackNode(); // 货肺款 畴靛 积己
		node.item = item;
		node.next = top;
		top = node;
		++size;
	}

	public char pop() {
		if (isEmpty()) {
			return 0;
		} else {
			StackNode node = top;
			top = node.next;
			--size;
			return node.item;
		}
	}
    
    public int size() {
        return size;
    }
} // LinkedStack

public class Problem10799 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();

		LinkedStack stack = new LinkedStack();
        int result = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') stack.push(s.charAt(i));
            else {
                stack.pop();
                if(s.charAt(i-1)=='(')
                    result += stack.size();
                else
                    result++;
            }
        }
        
        System.out.println(result);
	}
}
