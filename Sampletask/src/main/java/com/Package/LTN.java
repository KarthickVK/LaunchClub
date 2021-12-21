package com.Package;

import java.util.Arrays;
import java.util.Scanner;

public class LTN {

 
   
    public static void main(String[] args)
    {
    
    	Scanner sc = new Scanner(System.in);
		System.out.println("Enter the no of elements in array");
		int no = sc.nextInt();
		System.out.println("Enter the array");
		int[] n = new int[no];
	

		for (int i = 0; i < no; i++) {
			n[i] = sc.nextInt();
		}
		System.out.println("Array is:");
		Arrays.sort(n);
		for (int i = 0; i < no; i++) {
			System.out.println(n[i]);
		}
		System.out.println("largest three number are:");
		       
		        int check = 0, count = 1;
		        for (int i = 1; i <= no; i++) {
		 
		            if (count < 4) {
		                if (check != n[no - i]) {
		                    // to handle duplicate values
		                    System.out.print(n[no - i] + " ");
		                    check = n[no - i];
		                    count++;
		                }
		            }
		            else
		                break;
		        }
		    }

		
    }




