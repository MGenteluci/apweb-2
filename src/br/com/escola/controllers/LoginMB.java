package br.com.escola.controllers;

import javax.faces.bean.ManagedBean;

import lombok.Data;

@ManagedBean(name="loginMB")
@Data
public class LoginMB {

	private String user = "Teste!";
	
}