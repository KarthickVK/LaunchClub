
package com.Package;

import java.util.*;

public class Practice {
	void merge(int arr[], int beg, int mid, int end) {
		int i, j, k, a, n;
		int n1 = mid - beg + 1;
		int n2 = end - mid;
		int la[] = new int[n1];
		int lu[] = new int[n2];
		for (i = 0; i < n1; i++) {
			la[i] = arr[beg + 1];
		}
		for (j = 0; j < n2; j++) {
			lu[j] = arr[mid + 1 + j];
		}
		i = 0;
		j = 0;
		k = beg;
		while (i < n1 && j < n2) {
			if (la[i] <= lu[j]) {
				arr[k] = la[i];
				i++;
			} else {
				arr[k] = lu[j];
				j++;
			}
			k++;
		}
		/* Copy remaining elements of L[] if any */
		while (i < n1) {
			arr[k] = la[i];
			i++;
			k++;
		}
		/* Copy remaining elements of R[] if any */
		while (j < n2) {
			arr[k] = lu[j];
			j++;
			k++;
		}
	}

// Main function that sorts arr[l..r] using
// merge()
	void sort(int arr[], int beg, int end) {
		if (beg < end) {
// Find the middle point
			int m = (beg + end) / 2;
// Sort first and second halves
			sort(arr, beg, m);
			sort(arr, m + 1, end);
// Merge the sorted halves
			merge(arr, beg, m, end);
		}
	}

	/* A utility function to print array of size n */
	static void printArray(int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n; ++i)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the value of array");
		int a = sc.nextInt();
		int[] arr = new int[a];
		System.out.println("enter the array");
		for (int i = 0; i < a; i++) {
			arr[i] = sc.nextInt();
		}
 Practice ob = new Practice();
	ob.sort(arr,0, a - 1);
	 System.out.println("\nSorted array");
     printArray(arr);
	}
}
