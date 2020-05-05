package level1;

import java.util.Arrays;
import java.util.HashMap;

public class _1_An_incomplete_player {

	public static void main(String[] args) {
		/*
		 *  Test Case
		 *  participant	// completion
		 *  {"leo", "kiki", "eden"}  //  {"eden", "kiki"}
		 *  {"mislav", "stanko", "mislav", "ana"}  //  {"stanko", "ana", "mislav"}
		 */
		String[] participant = {"mislav", "stanko", "mislav", "ana"};
		String[] completion = {"stanko", "ana", "mislav"};
		
		
		String answer = solution(participant, completion);
		
		System.out.println(answer);
	}
	
	// ���� Ȱ��
//	public static String solution(String[] participant, String[] completion) {
//        /*
//            participant : ������ ������ �̸�
//            completion : ������ ������ �̸�
//            
//            return �������� ���� ���� �̸�
//        */
//		Arrays.sort(participant);
//		Arrays.sort(completion);
//		int index = 0;
//		for(String c : completion) {
//			if(!c.equals(participant[index]))
//				return participant[index];
//			index++;
//		}
//		return participant[participant.length-1];
//    }
	
	
	// HashMap Ȱ��
	public static String solution(String[] participant, String[] completion) {
        /*
            participant : ������ ������ �̸�
            completion : ������ ������ �̸�
            
            return �������� ���� ���� �̸�
        */
		
		String answer = "";
		HashMap<String, Integer> prtcpt_map = new HashMap<>();
		for(String name : participant) {
			prtcpt_map.put(name, prtcpt_map.getOrDefault(name, 0)+1);
			// getOrDefault() : ���� ������ 0���� �ʱ�ȭ�ϰ� ������ �ش� ���� �����´�
		}
		
		for(String name: completion) {
			prtcpt_map.put(name,  prtcpt_map.get(name)-1);
		}
		
		for(String name: prtcpt_map.keySet()) {
			if(prtcpt_map.get(name) != 0) {
				answer = name;
				break;
			}
		}
		
		return answer;
    }

}
