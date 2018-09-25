package br.com.escola.controllers;

import java.util.List;

import javax.faces.bean.ManagedBean;

import br.com.escola.models.Student;
import lombok.Data;

@ManagedBean
@Data
public class StudentMB {

	private Student student = new Student();
	private List<Student> students = null;
	
	/*
	 * Methods |
	 * 		   v
	 */
	
}