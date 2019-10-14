import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem10866 {

	static StringTokenizer st;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		Deque dq = new Deque();

		int orderCount = Integer.parseInt(st.nextToken());

		for (int i = 0; i < orderCount; i++) {
			st = new StringTokenizer(br.readLine());
			String order = st.nextToken();

			if (order.equals("push_front")) {
				dq.push_front(Integer.parseInt(st.nextToken()));
			} else if (order.equals("push_back")) {
				dq.push_back(Integer.parseInt(st.nextToken()));
			} else if (order.equals("pop_front")) {
				sb.append(dq.pop_fornt() + "\n");
			} else if (order.equals("pop_back")) {
				sb.append(dq.pop_back() + "\n");
			} else if (order.equals("size")) {
				sb.append(dq.size() + "\n");
			} else if (order.equals("empty")) {
				sb.append(dq.empty() + "\n");
			} else if (order.equals("front")) {
				sb.append(dq.front() + "\n");
			} else if (order.equals("back")) {
				sb.append(dq.back() + "\n");
			}
		}

		bw.write(sb.toString());
		bw.flush();
	}

}

class Deque {
	List<Integer> list;

	Deque() {
		list = new ArrayList<Integer>();
	}

	public void push_front(int X) {
		list.add(0, X);
	}

	public void push_back(int X) {
		list.add(X);
	}

	public int pop_fornt() {
		if (list.size() > 0) {
			int num = list.get(0);
			list.remove(0);
			return num;
		} else {
			return -1;
		}
	}

	public int pop_back() {
		if (list.size() > 0) {
			int idx = list.size() - 1;
			int num = list.get(idx);
			list.remove(idx);
			return num;
		} else {
			return -1;
		}
	}

	public int size() {
		return list.size();
	}

	public int empty() {
		if (list.isEmpty()) {
			return 1;
		}
		return 0;
	}

	public int front() {
		return list.get(0);
	}

	public int back() {
		return list.get(list.size() - 1);
	}

	public int idx(int i) {
		return list.get(i);
	}
}
