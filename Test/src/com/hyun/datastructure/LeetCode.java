package com.hyun.datastructure;

import java.util.ArrayList;
import java.util.Arrays;

public class LeetCode {

	public static void main(String[] args) {
//		int[] n1 = {4,9,5};
//		int[] n2 = {9,4,9,8,4};
//		int[] n = intersection(n1, n2);

//		int[] numbers = { 1, 2, 3, 4, 4, 9, 56, 90 };

//		int target = 8;

//		int[] result = twoSum(numbers, target);
//		System.out.println(result);
		
//		backspaceCompare("y#fo##f","y#f#o##f");
		
		String[] as = {"5", "2", "C", "D", "+"};
		System.out.println(calPoints(as));
	}
	
	public static int calPoints(String[] ops) {
        java.util.Stack<Integer> stack = new java.util.Stack<>();
        int sum = 0;
        
        for(int i = 0; i < ops.length; i++) { 
            if(ops[i].equals("C")) {
                sum -= stack.pop();
            } else if(ops[i].equals("D")) {
                int tmp = stack.peek()*2;
                sum += tmp;
                stack.push(tmp);
            } else if(ops[i].equals("+")) {
                int tmp = stack.peek() + stack.get(stack.size()-2);
                sum += tmp;
                stack.push(tmp);
            } else {
                int tmp = Integer.parseInt(ops[i]);
                sum += tmp;
                stack.push(tmp);
            }
        }
        
        return sum;
    }
	
	
	 public static boolean backspaceCompare(String S, String T) {
		 
		 java.util.Stack<Character> s = new java.util.Stack<>();
		 java.util.Stack<Character> t = new java.util.Stack<>();
	        
	        for(int i = 0; i < S.length(); i++) {
	            if(S.charAt(i) =='#') {
	            	if(!s.empty())
	            		s.pop();
	            } else {
	                s.push(S.charAt(i));
	            }
	        }
	        
	        for(int i = 0; i < T.length(); i++) {
	            if(T.charAt(i) =='#') {
	            	if(!t.empty())
	            		t.pop();
	            } else {
	                t.push(T.charAt(i));
	            }
	        }
	       
	        String _S="";
	        String _T="";
	        
	        while(!s.empty()) {
	            _S = _S.concat(s.pop().toString());
	        }
	        
	        while(!t.empty()) {
	            _T = _T.concat(t.pop().toString());
	        }
	        
	        if(_S.equals(_T)) return true;
	        else return false;
	        
	    }

	public static int[] twoSum(int[] numbers, int target) {
//        ArrayList<Integer> list = new ArrayList<>();

//        int low = 0;
//        int high = numbers.length;
//        int mid = (low + high)/2;
//        int center = -1;
//        int[] result = new int[2];
//        while(low <= high) {
//            
//            if(numbers[mid] < target) {
//                low = mid +1 ;
//            } else if(numbers[mid] > target) {
//            	center = mid;
//                break;
//            }
//        }
//        
//        int[] tmp = new int[mid];
//        
//        for(int i = 0; i < mid; i++) {
//        	int target2 = target - numbers[i];
//        	Arrays.binarySearch(numbers, key)
//        }

		int[] result = new int[2];

//		for (int i = 0; i < numbers.length; i++) {
//			int target2 = target - numbers[i];
//			int isFind = Arrays.binarySearch(numbers, i, numbers.length, target2);
//			
//			if (isFind >= 0 && i != isFind) {
//				if (i < isFind) {
//					result[0] = i + 1;
//					result[1] = isFind + 1;
//					break;
//				} else if (i > isFind) {
//					result[0] = isFind + 1;
//					result[1] = i + 1;
//					break;
//				}
//			}
//		}
		boolean find = false;
		for (int i = 0; i < numbers.length; i++) {
			int target2 = target - numbers[i];
			
			for (int j = i+1; j < numbers.length; j++) {
				if(numbers[j] == target2) {
					result[1] = j;
					find = true;
				}
			}
			
			if(find) {
				result[0] = i;
				break;
			}
		}

		return result;
	}

	public static int[] intersection(int[] nums1, int[] nums2) {

		Arrays.sort(nums1);
		Arrays.sort(nums2);

		ArrayList<Integer> list1 = new ArrayList<>();
		ArrayList<Integer> list2 = new ArrayList<>();

		// 중복 제거
		int tmp = -1;
		for (int n : nums1) {
			if (tmp != n)
				list1.add(n);
			tmp = n;
		}
		tmp = -1;
		for (int n : nums2) {
			if (tmp != n)
				list2.add(n);
			tmp = n;
		}

		// 중복 제거된 배열 생성
		int[] arr1 = new int[list1.size()];
		int[] arr2 = new int[list2.size()];

		for (int i = 0; i < list1.size(); i++) {
			arr1[i] = list1.get(i);
		}

		for (int i = 0; i < list2.size(); i++) {
			arr2[i] = list2.get(i);
		}

		// 겹치는 점 찾기
		list1.clear();

		for (int i = 0; i < arr1.length; i++) {
			if (Arrays.binarySearch(arr2, arr1[i]) < 0) {
				list1.add(arr1[i]);
			}
		}

		// 겹치는 점으로 배열 생성
		int[] result = new int[list1.size()];

		for (int i = 0; i < list1.size(); i++) {
			result[i] = list1.get(i);
		}

		return result;
	}

}
