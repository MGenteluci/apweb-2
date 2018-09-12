package br.com.escola.controllers;

import static br.com.escola.components.Message.UNAUTHORIZED_ACCESS;
import static br.com.escola.components.UrlBuilder.REQUEST_PATH_HOME;
import static br.com.escola.components.UrlBuilder.REQUEST_PATH_INDEX;
import static javax.faces.application.FacesMessage.SEVERITY_ERROR;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.apache.commons.lang3.ObjectUtils;

import br.com.escola.components.Message;
import br.com.escola.models.User;
import br.com.escola.repository.UserDAO;
import lombok.Data;

@ManagedBean(name="loginMB")
@SessionScoped
@Data
public class LoginMB {
	
	private User user = new User();
	private boolean authenticated = false;
	
	/**
	 * Data from login form
	 */
	private String username;
	private String password;
	
	/*
	 * Methods |
	 * 		   v
	 */
	
	public String signIn() {
		UserDAO userDAO = new UserDAO();
		user = userDAO.findByUsername(username);
		
		if(!ObjectUtils.allNotNull(user)) {
			FacesMessage message = new FacesMessage(SEVERITY_ERROR, UNAUTHORIZED_ACCESS, null);
			FacesContext.getCurrentInstance().addMessage(null, message);
			
			return REQUEST_PATH_INDEX;
		}
		
		if(user.isPasswordIncorrect(password)) {
			FacesMessage message = new FacesMessage(SEVERITY_ERROR, UNAUTHORIZED_ACCESS, null);
			FacesContext.getCurrentInstance().addMessage(null, message);
			
			return REQUEST_PATH_INDEX;
		}
		
		return REQUEST_PATH_HOME;
	}
	
}