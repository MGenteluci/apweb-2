package br.com.escola.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class Student {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String code;
	private String name;
	private String gender;
	
	@Column(name="birth_date")
	private String birthDate;
	
	@ManyToOne
	@JoinColumn(name="id_parent_fk")
	private Parent parent;
	
}