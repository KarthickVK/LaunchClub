package Airline;
	

	import java.util.Properties;

import javax.mail.Message;
	import javax.mail.MessagingException;
	import javax.mail.PasswordAuthentication;
	import javax.mail.Session;
	import javax.mail.Transport;
	import javax.mail.internet.InternetAddress;
	import javax.mail.internet.MimeMessage;

	public class Mail {

		static String recipient = "pandiarajkumar8@gmail.com";
		static String sender = "devidurga201299@gmail.com";
		static String password = "deepika@12345";
		static String subject = "Holiday Tracker";
		static String message;
		static String body="today holiday";

		public static void main(String[] args) {

			sendMail(sender,password,recipient,subject,body);
			
			
		}
		

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
					return new PasswordAuthentication("devidurga201299@gmail.com", "deepika@12345");
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
	}

	
	

