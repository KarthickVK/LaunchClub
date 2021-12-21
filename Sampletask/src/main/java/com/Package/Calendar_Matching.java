package com.Package;

import java.text.*;
import java.util.*;
public class Calendar_Matching {
	public static void main(String[] args) throws Exception {

		String time1 = "18:00:00";
		String time2 = "12:00:0	0";

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");

		Date date1 = simpleDateFormat.parse(time1);
		Date date2 = simpleDateFormat.parse(time2);

		long differenceInMilliSeconds = Math.abs(date2.getTime() - date1.getTime());

		long differenceInHours = (differenceInMilliSeconds / (60 * 60 * 1000)) % 24;

		// Calculating the difference in Minutes
		long differenceInMinutes = (differenceInMilliSeconds / (60 * 1000)) % 60;

		// Calculating the difference in Seconds
		long differenceInSeconds = (differenceInMilliSeconds / 1000) % 60;

		// Printing the answer
		System.out.println("Difference is " + differenceInHours + " hours " + differenceInMinutes + " minutes "
				+ differenceInSeconds + " Seconds. ");
	}
}
