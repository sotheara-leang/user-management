package com.mcnc.usermanagement.service.impl;

import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import com.mcnc.usermanagement.dto.UserDTO;
import com.mcnc.usermanagement.service.MailService;

@Service("loginNotificationService")
public class LoginNotificationService implements MailService {

	@Autowired
	private MailSender mailSender;

	@Autowired
	private VelocityEngine velocityEngine;
	
	private final String TEMPLATE_PATH = "com/mcnc/usermanagement/mail/login-notification-template.vm";

	@Override
	public void sendMail(Map<String, Object> mailParam) {
		if (mailParam != null) {
			UserDTO user = (UserDTO) mailParam.get("user");
			Template template = velocityEngine.getTemplate(TEMPLATE_PATH);
			
			Date now = new Date();
			VelocityContext velocityContext = new VelocityContext();
			velocityContext.put("username", user.getUsername());
			velocityContext.put("loginDate", new SimpleDateFormat("dd/MM/yyyy").format(now));
			StringWriter stringWriter = new StringWriter();
			template.merge(velocityContext, stringWriter);
			
			SimpleMailMessage message = new SimpleMailMessage();
			message.setTo(user.getEmail());
			message.setSubject("Login Notification");
			message.setText(stringWriter.toString());
			message.setSentDate(now);
			mailSender.send(message);
		}
	}
}
