package Airline;


	import java.sql.*;
	import java.util.*;

	import javax.crypto.Cipher;
	import javax.crypto.SecretKey;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
	public class Airline {

		//private static String AES;

		public Connection getConnection() throws SQLException {

			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/Airline", "root", "Karthi33");
			return c;
		}

		public void registerinfo() throws SQLException{
			Connection c = getConnection();
			Statement st = c.createStatement();
			   Cipher cipher = null;
			    SecretKey key = null;

			Scanner sc1 = new Scanner(System.in);

			System.out.println("Enter the FirstName \t LastName \t Address \t City \t State \t Country \t Gender");
			String FirstName = sc1.next();
			String LastName = sc1.next();
			String Address = sc1.next();
			String City = sc1.next();
			String State = sc1.next();
			String Country = sc1.next();
			String Gender = sc1.next();
			System.out.println("Enter the Contactno");
			String ContactNo = sc1.next();
			System.out.println("Enter the Email_id");
			String Email_id = sc1.next();
			if ((Email_id.length() > 10) && (Email_id.contains("@gmail.com"))) {
				ResultSet rs = st.executeQuery("select*from registration_info where Email_id='" + Email_id + "'");
				// rs.getFetchSize();
				String out = " ";
				while (rs.next()) {
					out = rs.getString(9);
				}

				if (out.equals(Email_id)) {
					System.out.println("Already exists");
		
					
					registerinfo();
				}

			}

			System.out.println("Enter the Password");

			String Password = sc1.next();
			String encodedPassword = Base64.getEncoder().encodeToString(Password.getBytes());
			if (Password.matches(".*[a-z]{1,}.*") && Password.matches(".*[A-Z]{1,}.*") && Password.matches(".*[0-9]{1,}.*")
					&& Password.matches(".*[@#$()!~%^&|*?.,]{1,}.*") && (Password.length() <= 10)
					&& (!Password.contains(" "))) {

	          
				System.out.println("Strong Password and it can be stored in db");

				st.executeUpdate("insert into registration_info values('" + FirstName + "','" + LastName + "','" + Address
						+ "','" + City + "','" + State + "','" + Country + "','" + Gender + "','" + ContactNo + "','"
						+ Email_id + "','" +encodedPassword+ "' )");
				System.out.println("Data entered Successfully");
				Reservationinfo();
			} else {
				System.out.println("Invalid pwd");
				registerinfo();
			}

		}

		public void logininfo() throws SQLException {
			// RegistrationPage rp = new RegistrationPage();
		   Cipher cipher;
		    SecretKey key;


			Connection c = getConnection();
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter the Email_id \t Password");
			String Email_id = sc.nextLine();
			String Password = sc.nextLine();
		
		String encodedPassword = Base64.getEncoder().encodeToString(Password.getBytes());
		

			Statement st = c.createStatement();
			ResultSet rs = st.executeQuery(
					"select*from registration_info where Email_id='" + Email_id + "'");
			String out = " ";
			String out1 = " ";
			int out2;
			while (rs.next()) {
				out = rs.getString(9);
				out1 = rs.getString(10);
			}

			if (out.equals(Email_id)) {
				//Object decryptedText = null;
				if (out1.equals(encodedPassword)) {

					st.executeUpdate("insert into Login_info values('" + Email_id + "','" + encodedPassword + "')");
					System.out.println("welcome");
					Reservationinfo();
				} else {
					System.out.println("invalid");
					// rp.logininfo();

				}
			} else {
				System.out.println("invalid");
				// rp.logininfo();

			}
		}

		public void Reservationinfo() throws SQLException {
			Connection c = getConnection();
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter the origin");
			String origin = sc.next();
			System.out.println("Enter the Destination");
			String Destination = sc.next();
			Statement st = c.createStatement();
			ResultSet rs = st.executeQuery(
					"select*from reservation_info where origin='" + origin + "'and Destination='" + Destination + "'");
			String out = " ";
			String out1 = " ";
			while (rs.next()) {
				out = rs.getString(5);
				out1 = rs.getString(6);

				if (out.equals(origin) && (out1.equals(Destination))) {

					System.out.println("Flight available");
					System.out.println("Available Flight is:" + "Flight_num:" + rs.getString(1) + "\t" + "Flight_name:"
							+ rs.getString(2) + "\t" + "Departuer_time:" + rs.getString(3) + "\t" + "Arrival_time:"
							+ rs.getString(4) + "\t" + "Origin:" + rs.getString(5) + "\t" + "Destination:" + rs.getString(6)
							+ "\t" + "First_class_seats:" + rs.getString(7) + "\t" + "Seconds_class_seats:"
							+ rs.getString(8) + "\t" + "First_class_price:" + rs.getString(9) + "\t"
							+ "Seconds_class_price:" + rs.getString(10));
					// Bookinginfo(origin, Destination);

				}

				else
					System.out.println("Flight not available");

			}
			Bookinginfo(origin, Destination);
		}

		public void Bookinginfo(String origin, String destination) throws SQLException {

			Connection c = getConnection();
			Statement st = c.createStatement();
			Scanner input = new Scanner(System.in);

			System.out.println("enter no of ticket");
			int no = input.nextInt();
			int q, s = 0;
			int id = 0;
			int p, fp = 0;
			int sp = 0;

			/*
			 * Scanner sc = new Scanner(System.in); System.out.println("Enter the origin");
			 * String origin = sc.next(); System.out.println("Enter the Destination");
			 * String Destination = sc.next();
			 */

			ResultSet rs = st.executeQuery(
					"Select * from reservation_info  where Origin='" + origin + "'and Destination='" + destination + "'");
			System.out.println("Choose Your preference : type '1' for First_class_seats or '2' for Seconds_class_seats:");
			int ch1 = input.nextInt();
			System.out.println("Choose payment type:type '1' for gpay or '2' for Netbanking");
			int ch2 = input.nextInt();

			if (ch1 == 1) {
				while (rs.next()) {
					id = rs.getInt(1);
					s = rs.getInt(7);
					fp = rs.getInt(9);

				}
				p = no * fp;
				if (no <= s) {

					// System.out.println("You have booked: " + no + "seats in 1st class");

					if (ch2 == 1) {
						System.out.println("Your Amount is:" + p + "");
						System.out.println("Airline gpayno is:8524025238");
						System.out.println("Are u pay money:type '1' for yes or '2'for no");
						int ch3 = input.nextInt();
						if (ch3 == 1) {
							System.out.println("You have booked: " + no + "seats in 1st class");
							System.out.println("Thank You");

						} else {
							System.out.println("pls pay money");
						}

					} else {
						System.out.println("Your Amount Is:" + p + "");

						System.out.println("Airline Account number is=67237798309");
						System.out.println("IFSC number is=SBINO070772");
						System.out.println("Are u pay money:type '1' for yes or '2'for no");
						int ch4 = input.nextInt();
						if (ch4 == 1) {
							System.out.println("You have booked: " + no + "seats in 1st class");
							System.out.println("Thank You");

						} else {
							System.out.println("pls pay money");
						}

					}

					q = s - no;
					st.executeUpdate(
							"Update reservation_info set First_class_seats ='" + q + "'where Flight_num='" + id + "'");
					// String userName;
					// long paymentAmount;
					// makePayment(userName,paymentAmount);

				}

				else {
					// provide passenger another available class option
					System.out.println("Sorry,First Class bookings are over.");

				}

			}

			else {
				while (rs.next()) {
					id = rs.getInt(1);
					s = rs.getInt(8);
					sp = rs.getInt(10);

					p = no * sp;
					if (no <= s) {
						if (ch2 == 1) {
							System.out.println("Your Amount Is:" + p + "");
							System.out.println("Airline gpayno is:8524025238");
							System.out.println("Are u pay money:type '1' for yes or '2'for no");
							int ch5 = input.nextInt();
							if (ch5 == 1) {
								System.out.println("You have booked: " + no + "seats in 2st class");
								System.out.println("Thank You");

							} else {
								System.out.println("pls pay money");
							}

						} else {
							System.out.println("Your Amount Is:" + p + "");

							System.out.println("Airline Account number is=67237798309");
							System.out.println("IFSC number is=SBINO070772");
							System.out.println("Are u pay money:type '1' for yes or '2'for no");
							int ch6 = input.nextInt();
							if (ch6 == 1) {
								System.out.println("You have booked: " + no + "seats in 2st class");
								System.out.println("Thank You");
							} else {
								System.out.println("pls pay money");
							}

						}

						//
						//System.out.println("You have booked: " + no + "seats in 2st class");

						q = s - no;

						st.executeUpdate(
								"Update reservation_info set Seconds_class_seats='" + q + "'where Flight_num='" + id + "'");
						break;

					}

					else {
						// provide passenger another available class option
						System.out.println("Sorry,Seconds Class bookings are over");
					}

				}
			}
			
			//sendMail();
		}
		
		 static String recipient = "nandinirak@gmail.com";
		 static  String sender = "launchclubmail@gmail.com";
		 static  String password = "Launchclub@123";
		 static String subject = "Holiday Tracker";
		 static String message;
		 static  String body="ticket confirmed";
			public static void sendMail(String sender, String password, String recipient, String subject, String body) {

				String host = "smtp.gmail.com";

				Properties properties = System.getProperties();

				properties.put("mail.smtp.host", host);
				properties.put("mail.smtp.port", "465");
				properties.put("mail.smtp.ssl.enable", "true");
				properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
				properties.put("mail.smtp.auth", "true");

				Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication("launchclubmail@gmail.com", "Launchclub@123");
					}

				});

				try {

					MimeMessage message = new MimeMessage(session);

					message.setFrom(new InternetAddress(sender));

					message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));

					message.setSubject(subject);
					message.setText(body);

					Transport.send(message);
					System.out.println("Mail sent successfully...");
				} catch (MessagingException mex) {
					mex.printStackTrace();
				}
			
					   }  
		
		

		public static void main(String args[]) throws SQLException
		{
			
			Airline obj = new Airline();
			Scanner sc = new Scanner(System.in);
			System.out.println("1.register \t 2.login");
			System.out.println("Enter the choice");
			int ch = sc.nextInt();
			if (ch == 1) {
				obj.registerinfo();
			} else {

				obj.logininfo();
			}
			sendMail(sender,password,recipient,subject,body);
    
		}
	
	
	
}
