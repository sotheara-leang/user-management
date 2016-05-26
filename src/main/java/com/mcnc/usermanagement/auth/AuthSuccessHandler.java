package com.mcnc.usermanagement.auth;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import com.mcnc.usermanagement.constant.Url;
import com.mcnc.usermanagement.constant.UserContextDetail;
import com.mcnc.usermanagement.constant.UserRole;
import com.mcnc.usermanagement.dto.UserDTO;
import com.mcnc.usermanagement.service.DepartmentService;
import com.mcnc.usermanagement.service.MailService;

public class AuthSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

	@Autowired
	@Qualifier("loginNotificationService")
	private MailService loginNotificationMessageService;
	
	@Autowired
	private DepartmentService departmentService;
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
		super.onAuthenticationSuccess(request, response, authentication);
		UsernamePasswordAuthenticationToken auth = (UsernamePasswordAuthenticationToken) authentication;
		
		UserDTO user = (UserDTO) auth.getPrincipal();
		UserContextDetail userContextDetail = new UserContextDetail();
		userContextDetail.setDepartment(departmentService.findDepartmentForUser(user.getId()));
		auth.setDetails(userContextDetail);
		
		if (user.isAllowLoginEmailNotification() && user.getEmail() != null) {
			Map<String, Object> mailParam = new HashMap<>();
			mailParam.put("user", user);
			loginNotificationMessageService.sendMail(mailParam);
		}
	}
	
	@Override
	protected String determineTargetUrl(HttpServletRequest request, HttpServletResponse response) {
		UsernamePasswordAuthenticationToken auth = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
		UserDTO user = (UserDTO) ((UsernamePasswordAuthenticationToken) auth).getPrincipal();
		return user.getRole() == UserRole.ROLE_ADMIN ? Url.USER : Url.INDEX;
	}
}
