package br.com.escola.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class Parent {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String cpf;
	private String name;
	private String gender;
	private String contact;
	private String address;
	
	@Column(name="birth_date")
	private String birthDate;
	
	@OneToMany(mappedBy="parent", fetch=FetchType.LAZY)
	private List<Student> students;
	
}