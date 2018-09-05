package br.com.escola.controllers;

import javax.faces.bean.ManagedBean;

import br.com.escola.models.Parent;
import br.com.escola.repository.ParentDAO;
import lombok.Data;

@ManagedBean
@Data
public class ParentMB {

	private ParentDAO dao = new ParentDAO();
	private Parent parent = new Parent();
	
	/*
	 * Methods |
	 * 		   v
	 */
	
	public String pushParentPage() {
		//this.parent = new Parent();
		
		return "parent.jsf";
	}
	
	public String create() {
		this.dao.create(this.parent);
		
		return findAll();
	}
	
	public String findAll() {
		//List<Parent> parents = this.dao.findAll();
		
		return "parents.jsf";
	}
	
	public String findByUsername(String username) {
		
		return "";
	}
	
	public String remove() {
		
		return "";
	}
	
}