package br.com.escola.controllers;

import javax.faces.bean.ManagedBean;

@ManagedBean(name="loginMB")
public class LoginMB {

	private String user = "test";

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}
	
}