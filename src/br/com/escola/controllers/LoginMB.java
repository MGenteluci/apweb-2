package br.com.escola.controllers;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.escola.models.User;
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
		
		return "index.jsf";
	}
	
}