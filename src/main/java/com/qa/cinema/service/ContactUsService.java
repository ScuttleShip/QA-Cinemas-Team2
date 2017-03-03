package com.qa.cinema.service;

import java.util.Properties;

import javax.inject.Inject;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.qa.cinema.model.EmailModel;
import com.qa.cinema.util.JSONUtil;

public class ContactUsService {
	
	@Inject
	JSONUtil util;
	
	public String getFirstName() {
		return "";
	}

	public String getLastName() {
		return "";
	}

	public String getEmail() {
		return "";
	}

	public String getPhone() {
		return "";
	}
	
	public String getMessage() {
		return "";
	}
	
	public String sendEmail(String messageToSend) {
		
		EmailModel emailToSend = util.getObjectForJSON(messageToSend, EmailModel.class);
		
		String username = "qacinemas@gmail.com";
		String password = "IHeartHisoka121";
		String emailToSendTo = "qacinemas@gmail.com";
		String subject = "";
		
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.port", "465");
		
		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
		
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(username));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailToSendTo));
			message.setSubject(emailToSend.getCinemaConcerned());
			message.setText(emailToSend.getMessage().toString());
			Transport.send(message);
			System.out.println("Message sent");		
			
		} catch (Exception e) {
			System.out.println("Uh oh " + e);
		}
		
		return "{\"message\":\"Mail sent\"}";
		
	}
}
