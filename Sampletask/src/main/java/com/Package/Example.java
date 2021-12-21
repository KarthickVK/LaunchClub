package com.Package;

import java.util.*;

public class Example {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the value");
		int no = sc.nextInt();
		System.out.println("enter the array");

		int[] a = new int[no];
		for (int i = 0; i < no; i++) {
			a[i] = sc.nextInt();

		}

		// Arrays.sort(a);
		System.out.println("enter array is:");
		Arrays.sort(a);

		for (int i = 0; i < no; i++) {
			System.out.println(a[i]);
		}
		System.out.println(a[no - 1] + " " + a[no - 2] + " " + a[no - 3]);
	}

}
