
package agecalculator;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
public class Agecalculator 
{ 
	@SuppressWarnings("unused")
	private static  void Agecalculate(Date birthDate)
{


int months = 0;
int days = 0;
int age=0;
//create calendar object for birth day
Calendar birthDay = Calendar.getInstance();
birthDay.setTimeInMillis(birthDate.getTime());
//create calendar object for current day
long currentTime = System.currentTimeMillis();
Calendar now = Calendar.getInstance();
now.setTimeInMillis(currentTime);
//Get difference between years
int years = now.get(Calendar.YEAR) - birthDay.get(Calendar.YEAR);
int currMonth = now.get(Calendar.MONTH) + 1;
int birthMonth = birthDay.get(Calendar.MONTH) + 1;
//Get difference between months
months = currMonth - birthMonth;
//if month difference is in negative then reduce years by one
//and calculate the number of months.
if (months < 0)
{
years--;
months = 12 
- birthMonth + currMonth;
if (now.get(Calendar.DATE) < birthDay.get(Calendar.DATE))
months--;
} else if (months == 0 && now.get(Calendar.DATE) < birthDay.get(Calendar.DATE))
{
years--;
months = 11;
}
//Calculate the days
if (now.get(Calendar.DATE) > birthDay.get(Calendar.DATE))
days = now.get(Calendar.DATE) - birthDay.get(Calendar.DATE);
else if (now.get(Calendar.DATE) < birthDay.get(Calendar.DATE))
{
int today = now.get(Calendar.DAY_OF_MONTH);
now.add(Calendar.MONTH, -1);
days = now.getActualMaximum(Calendar.DAY_OF_MONTH) - birthDay.get(Calendar.DAY_OF_MONTH) + today;
}
else
{
days = 0;
if (months == 12)
{
years++;
months = 0;
}
}
//Create new Age object
if(years>18)
{
System.out.println("congratulations you are Eligible");
}
else
{
System.out.println("sorry you are not eligiblle");
}
//return new age(days, months, years);
}
public static void main(String[] args) throws ParseException
{
System.out.print("Enter your date of birth in the form of dd//mm//yyyy=");
Scanner sc = new Scanner(System.in);
String date=sc.next();
SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
Date birthDate = sdf.parse(date);
Agecalculator age = Agecalculator(birthDate);
System.out.println("You are Passed:"+age);
}
private static Agecalculator Agecalculator(Date birthDate) {
	// TODO Auto-generated method stub
	return null;
}
private static void Age(int days, int months, int years) {
throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
}}
/*package agecalculator;
class Age {
private int days;
private int months;
private int years;
private Age()
{
//Prevent default constructor
}
public Age(int days, int months, int years)
{
this.days = days;
this.months = months;
this.years = years;
}
public int getDays()
{
return this.days;
}
public int getMonths()
{
return this.months;
}
public int getYears()
{
return this.years;
}
@Override
public String toString()
{
return years + " Years, " + months + " Months, " + days + " Days";
}
}

package agecalculator;

public class Agecalculator {

}*/