package br.com.escola.controllers;

import static br.com.escola.components.UrlBuilder.FACES_REDIRECT;
import static br.com.escola.components.UrlBuilder.REQUEST_PATH_STUDENT;
import static br.com.escola.components.UrlBuilder.REQUEST_PATH_STUDENTS;

import java.util.List;

import javax.faces.bean.ManagedBean;

import br.com.escola.models.Student;
import br.com.escola.repository.StudentDAO;
import lombok.Data;

@ManagedBean
@Data
public class StudentMB {
	
	private StudentDAO dao = new StudentDAO();
	private Student student = new Student();
	private List<Student> students = null;
	
	/*
	 * Methods |
	 * 		   v
	 */
	
	public List<Student> getStudents(){
		return this.students == null ? this.dao.findAll() : this.students;
	}
	
	public String create() {
		this.dao.create(this.student);
		return findAll();
	}
	
	public String findAll() {
		return REQUEST_PATH_STUDENTS + FACES_REDIRECT;
	}
	
	public String remove(Long id) {
		this.dao.remove(this.dao.findById(id));
		return findAll();
	}
	
	public String pushStudentPage() {
		return REQUEST_PATH_STUDENT;
	}
	
	public String pushUpdateParentPage(Long id) {
		this.student = this.dao.findById(id);
		return pushStudentPage();
	}
	
}