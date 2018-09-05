package br.com.escola.models;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class User {

	@Id
	private Long id;
	private String name = "Matheus";
	private String surname;
	private String username;
	private String password = "123";
	
	public boolean isPasswordCorrect(String password) {
		if(this.password.equals(password)) 
			return true;
		
		return false;
	}
	
}