package com.capital.dragon.service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
public class EmailSender {
	
	public static void sendEmail(JavaMailSender javaMailSender,String email,String subject,String body) {
		MimeMessage mail = javaMailSender.createMimeMessage();
		try {
			MimeMessageHelper helper = new MimeMessageHelper(mail, true);
			helper.setText(body);
			helper.setTo(email);			
			helper.setFrom("robotMTS@dragon-capital.com");
			helper.setSubject(subject);			
			javaMailSender.send(mail);
		} catch (MessagingException e) {
			e.printStackTrace();
		} finally {
		}
		
	}

}
