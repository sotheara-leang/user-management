package com.mcnc.usermanagement.service;

import java.util.Map;

public interface MailService {
	
	void sendMail(Map<String, Object> params);
}
