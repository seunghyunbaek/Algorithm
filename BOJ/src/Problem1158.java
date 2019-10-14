import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Problem1158 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();

		Queue<Integer> q = new LinkedList<Integer>();

		for (int i = 1; i <= n; i++) {
			q.add(i);
		}

		String s = "<";
		int cnt = 1;
		int t = 0;
		while (!q.isEmpty()) {

			if (cnt % m == 0) {
				t++;
				if (t == n)
					s = s + q.poll().toString();
				else
					s = s + q.poll().toString() + ", ";
			} else {
				q.add(q.poll());
			}

			cnt++;
		}

		s += ">";
		
		System.out.println(s);
	}

}
