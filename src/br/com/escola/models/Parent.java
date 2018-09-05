package br.com.escola.models;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Parent {

	@Id
	private Long id;
	private String cpf;
	private String name;
	private String gender;
	private String contact;
	private String address;
	private String birthDate;
	
}