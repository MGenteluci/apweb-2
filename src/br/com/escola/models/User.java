package br.com.escola.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="access_user")
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String name;
	private String surname;
	private String username;
	private String password;
	
	public boolean isPasswordIncorrect(String password) {
		if(this.password.equals(password)) 
			return false;
		
		return true;
	}
	
}