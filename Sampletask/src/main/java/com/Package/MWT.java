
package com.Package;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class MWT {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the no of elements in array");
		int no = sc.nextInt();
		System.out.println("Enter the array");
		int[] n = new int[no];
		// int[] t = new int[no];

		for (int i = 0; i < no; i++) {
			n[i] = sc.nextInt();
		}
		System.out.println("Array is:");
		Arrays.sort(n);
		for (int i = 0; i < no; i++) {
			System.out.println(n[i]);
		}
		System.out.println("-------------------------");
		int t = 0;
		int i = 0;
		int sum = 0;

		while (i < no - 1) {

			t += n[i];
			i++;
			sum = sum + t;

		}
		System.out.print(" " + sum + " ");

		// System.out.println(time);
	}
}
