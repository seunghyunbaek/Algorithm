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

	public static int BinarySearch(int[] sortedArray, int target, int low, int high) {
		int index = Integer.MAX_VALUE;
		
		while (low <= high) {
			int mid = (low + high) / 2;
			if (sortedArray[mid] < target) {
				low = mid + 1;
			} else if (sortedArray[mid] > target) {
				high = mid - 1;
			} else if (sortedArray[mid] == target) {
				index = mid;
				break;
			}
		}

		return index;
	}
}
