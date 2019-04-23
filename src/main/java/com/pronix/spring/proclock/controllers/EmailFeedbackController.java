package com.pronix.spring.proclock.controllers;

import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pronix.spring.proclock.config.EmailConfig;
import com.pronix.spring.proclock.config.EmailFeedback;
import com.pronix.spring.proclock.pojos.UserDetailsPojo;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/proClock/Feebback")
public class EmailFeedbackController {
	
	@Autowired
	private EmailConfig emailConfig;
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	@Autowired
	private EmailFeedback emailFeedback;
	
	@RequestMapping(method = RequestMethod.POST, value = "/sendFeedback")
	public void sendFeedback(@RequestBody EmailFeedback emailFeedback, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			throw new ValidationException("Feedback is not valid");
		}
		JavaMailSenderImpl javaMailSenderImpl = new JavaMailSenderImpl();
		javaMailSenderImpl.setHost(this.emailConfig.getHost());
		javaMailSenderImpl.setPort(this.emailConfig.getPort());
		javaMailSenderImpl.setUsername(this.emailConfig.getUsername());
		javaMailSenderImpl.setPassword(this.emailConfig.getPassword());
		
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setFrom(emailFeedback.getEmail());
		simpleMailMessage.setTo("koduriharibabu@gmail.com");
		simpleMailMessage.setSubject("proClock - New Email from "+emailFeedback.getName());
		simpleMailMessage.setText(emailFeedback.getFeedback());
		
		javaMailSenderImpl.send(simpleMailMessage);
	}
	
	@RequestMapping("/sendEmail")
	public void sendEmail() {
		
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		//simpleMailMessage.setFrom(emailFeedback.getEmail());
		simpleMailMessage.setTo("koduriharibabu@gmail.com");
		simpleMailMessage.setSubject("proClock - New Email");
		simpleMailMessage.setText("Hai this is hari");
		
		javaMailSender.send(simpleMailMessage);
	}

}
