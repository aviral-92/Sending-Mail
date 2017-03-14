package com.mail.sendMail;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Email {

	public static void main(String[] args) {

		final String username = "aviralmittal@srydada.96.lt";
		final String password = "aviral";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "mx1.hostinger.in");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("aviralmittal@srydada.96.lt"));

			InternetAddress[][] internetAddressesArray = { InternetAddress.parse("agg.mahima@gmail.com"),
					InternetAddress.parse("rinkuvatscs@gmail.com"), InternetAddress.parse("satendergautam@gmail.com"),
					InternetAddress.parse("aviralmittal2012@gmail.com") };

			// InternetAddress[] internetAddresses =
			// InternetAddress.parse("agg.mahima@gmail.com");

			for (InternetAddress[] internetAddresses : internetAddressesArray) {
				message.setRecipients(Message.RecipientType.TO, internetAddresses);

				// message.setRecipients(Message.RecipientType.TO,
				// internetAddresses[1]);
				// message.setRecipients(Message.RecipientType.CC,
				// InternetAddress.parse("satendergautam@gmail.com"));
				// message.setRecipients(Message.RecipientType.BCC,
				// InternetAddress.parse("aviralmittal2012@gmail.com"));
				message.setSubject("Testing Subject for multiple reciepients...");
				message.setText("Dear Mail Crawler," + "\n\n No spam to my email, please!"
						+ "This mail has been sent via code.... hurreeeyyyy" + " Trying again...."
						+ " Now send to multiple to reciepients");

				Transport.send(message);

				System.out.println("Done");
			}

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}
