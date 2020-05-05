package level1;

import java.util.ArrayList;

public class 모의고사 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] answers = { 1, 2, 3, 4, 5 };

		int[] result = solution(answers);

		for (int i : result) {
			System.out.println(i);
		}
	}

	public static int[] solution(int[] answers) {

		int[] p1 = { 1, 2, 3, 4, 5 };
		int[] p2 = { 2, 1, 2, 3, 2, 4, 2, 5 };
		int[] p3 = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };

		int[] cnt = new int[3];

		for (int i = 0; i < answers.length; ++i) {
			if (answers[i] == p1[i % p1.length]) {
				cnt[0]++;
			}
			if (answers[i] == p2[i % p2.length]) {
				cnt[1]++;
			}
			if (answers[i] == p3[i % p3.length]) {
				cnt[2]++;
			}
		}

		int top = cnt[0];

		for (int i = 0; i < cnt.length; ++i) {
			if (cnt[i] > top) {
				top = cnt[i];
			}
		}

		ArrayList<Integer> arr = new ArrayList<Integer>();

		for (int i = 0; i < cnt.length; i++) {
			if (cnt[i] == top) {
				arr.add(i + 1);
			}
		}
	
		int[] answer = new int[arr.size()];
		
		for(int i = 0; i < arr.size(); ++i) {
			answers[i] = arr.get(i);
		}

		return answer;
	}
}
