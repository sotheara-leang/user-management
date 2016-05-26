package com.mcnc.usermanagement.dto;

import java.util.Collection;

import org.springframework.security.core.CredentialsContainer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.mcnc.usermanagement.constant.UserRole;

public class UserDTO implements UserDetails, CredentialsContainer {

	private static final long serialVersionUID = 7001985635280122914L;

	private Integer id;
	
	private String username;
	
	@JsonProperty(access = Access.WRITE_ONLY)
	private String password;
	
	private UserRole role;
	
	private String email;
	
	private DepartmentDTO department;
	
	private boolean allowLoginEmailNotification;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return AuthorityUtils.createAuthorityList(getRole().name());
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
    public boolean equals(Object o) {
        if (o instanceof UserDetails) {
            return username.equals(((UserDetails) o).getUsername());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return username.hashCode();
    }
    
	public DepartmentDTO getDepartment() {
		return department;
	}

	public void setDepartment(DepartmentDTO department) {
		this.department = department;
	}

	public boolean isAllowLoginEmailNotification() {
		return allowLoginEmailNotification;
	}

	public void setAllowLoginEmailNotification(boolean allowLoginEmailNotification) {
		this.allowLoginEmailNotification = allowLoginEmailNotification;
	}
	
	@Override
	public void eraseCredentials() {
		this.password = null;
	}

	@Override
	public String toString() {
		return "UserDTO [id=" + id + ", username=" + username + "]";
	}
}
