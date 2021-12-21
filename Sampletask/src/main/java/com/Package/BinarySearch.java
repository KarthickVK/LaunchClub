package com.Package;

import java.util.Scanner;

public class BinarySearch {

	public static void binarySearch(int arr[], int first, int last, int k) {

		int mid = (first + last) / 2;
		while (first <= last) {
			if (arr[mid] < k) {
				first = mid + 1;
			} else if (arr[mid] == k) {
				System.out.println("Element is found at index: " + mid);
				break;
			} else {
				last = mid - 1;
			}
			mid = (first + last) / 2;
		}
		if (first > last) {
			System.out.println("Element is not found!");
		}
	}

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the no of elements in array");
		int no = sc.nextInt();
		System.out.println("Enter the array");
		int[] arr = new int[no];

		for (int i = 0; i < no; i++) {
			arr[i] = sc.nextInt();
		}

		System.out.println("Enter the key");
		int k = sc.nextInt();
		int last = arr.length - 1;
		binarySearch(arr, 0, last, k);
	}

}
