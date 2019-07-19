package com.hyun.test;

import com.hyun.sort.Search;

public class Test {

	public static void main(String[] args) {
//		int[] arr = {1,2,3,4,5,6,7,8,9,10,11,12,13};
		int len = 100000000;
		int[] arr = new int[len];
		for(int i = 0; i < len; i++) {
			arr[i] = i+1;
		}
		int target = len-1;
		
		long startTime = System.currentTimeMillis();
		System.out.println("¼øÂ÷Å½»ö  ÀÎµ¦½º: "+Search.SequentialSearch(arr, target));
		long endTime = System.currentTimeMillis();
		System.out.println("¼øÂ÷Å½»ö : " + (endTime - startTime));
		
		
		startTime = System.currentTimeMillis();
		System.out.println("ÀÌÁøÅ½»ö ÀÎµ¦½º: " + Search.BinarySearch(arr, target, 0, arr.length));
		endTime = System.currentTimeMillis();
		System.out.println("ÀÌÁøÅ½»ö : " + (endTime - startTime));
	}

}
