package com.Package;
import java.util.*;
public class RLE {

	

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		// TODO Auto-generated method stub
		System.out.println("Enter the String:");
		String str=sc.nextLine();
		String outstr="" ;
    	int count = 1;

        for(int i=0;i<str.length();i++)
        {
        	   count = 1;

        while(i<str.length() -1 && str.charAt(i) == str.charAt(i+1))	
        {
       // count++;
        i++;
        }
         outstr = outstr + str.charAt(i) + count;

        }
        
        
        System.out.println(outstr);
        }
	}


