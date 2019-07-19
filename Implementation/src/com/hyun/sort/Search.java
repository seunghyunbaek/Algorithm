package com.hyun.sort;

public class Search {
	public static int SequentialSearch(int[] arr, int target) {
		if (arr.length > 0) {
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] == target)
					return i;
			}
		}
		return -1;
	}
}
