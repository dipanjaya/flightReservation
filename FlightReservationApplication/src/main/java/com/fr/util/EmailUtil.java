package com.fr.util;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.fr.controllers.FlightController;

@Component
public class EmailUtil {

	@Value("${itinerary.email.subject}")
	private String EMAIL_SUBJECT = "Itinerary for your Flight" ;
	
	@Value("${itinerary.email.body}")
	private String EMAIL_BODY = "Please find itinerary attached to this email";

	private static final Logger LOGGER = LoggerFactory.getLogger(EmailUtil.class);
	
	@Autowired
	private JavaMailSender mailSender;

	public void sendItinerary(String address, String filePath) {

		LOGGER.info("Inside SendItinerary()");
		MimeMessage mimeMessage = mailSender.createMimeMessage();

		try {
			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
			
			helper.setTo(address);
			helper.setSubject(EMAIL_SUBJECT);
			helper.setText(EMAIL_BODY);
			helper.addAttachment("itinerary", new File(filePath));
			mailSender.send(mimeMessage);

		} catch (MessagingException e) {
			LOGGER.info("Exception inside sendItinerary() "+ e);
		}
	}

}
