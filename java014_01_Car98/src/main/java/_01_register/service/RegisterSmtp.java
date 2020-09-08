package _01_register.service;

import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.hibernate.Session;

import com.google.protobuf.Message;

public class RegisterSmtp {
	public static void main(String args[]) {
		String host = "smtp.gmail.com";
		int port = 587;
		final String username = "Car98system@gmail.com";
		final String password = "1qaz@WSX9527";// your password

		Properties props = new Properties();
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.port", port);
		Session session = Session.getInstance(props, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("fromn@gmail.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("o9000889@gmail.com"));
			message.setSubject("測試寄信.");
			message.setText("Car98 測試信 email !");

			Transport transport = session.getTransport("smtp");
			transport.connect(host, port, username, password);

			Transport.send(message);

			System.out.println("寄送email結束.");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}
