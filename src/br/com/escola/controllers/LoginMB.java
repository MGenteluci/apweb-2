package br.com.escola.controllers;

import static javax.faces.application.FacesMessage.SEVERITY_ERROR;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

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
		
		/*if(userDAO.findOne(username).equals(null)) {
			FacesMessage message = new FacesMessage(SEVERITY_ERROR, "Usuário ou senha inválidos", null);
			FacesContext.getCurrentInstance().addMessage(null, message);
			
			return "index.jsf";
		}*/
		
		if(!user.isPasswordCorrect(password)) {
			FacesMessage message = new FacesMessage(SEVERITY_ERROR, "Usuário ou senha inválidos", null);
			FacesContext.getCurrentInstance().addMessage(null, message);
			
			return "index.jsf";
		}
		
		return "home.jsf";
	}
	
}