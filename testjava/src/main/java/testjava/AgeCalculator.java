package testjava;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.Scanner;

public class AgeCalculator {
public static void main(String[] args) throws ParseException {
        
       
	
	
		Scanner sca=new Scanner(System.in);
		System.out.println("Enter your date of birth(dd-mm-yyyy)");
		String dob=sca.nextLine();
		
		SimpleDateFormat formatter=new SimpleDateFormat("dd-mm-yyyy");
		Date date=formatter.parse(dob);
		Instant instant=date.toInstant();
		ZonedDateTime zone=instant.atZone(ZoneId.systemDefault());
		LocalDate givenDate=zone.toLocalDate();
		Period period=Period.between(givenDate,LocalDate.now());
		System.out.println(period.getYears()+"years"+period.getMonths()+"months"+"-");
	    int input=period.getYears();
	   
		if(input>18){	
			System.out.println("Congratulation");
		}
		else
		{
			System.out.println("Sorry");

		}
}
}
