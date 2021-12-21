package com.Package;

import java.util.*;

public class Calculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the two numbers");
		Double one = sc.nextDouble();
		Double two = sc.nextDouble();
		System.out.println("Enter the operator(+,-,*,/)");
		char operator = sc.next().charAt(0);
		Double result = null;
		switch (operator) {
		case '+':
			result = one + two;
			break;
		case '-':
			result = one - two;
			break;
		case '*':
			result = one * two;
			break;
		case '/':
			result = one / two;
			break;
		default:
			System.out.println("not eligible");
		}
		System.out.println(result);
	}

}
