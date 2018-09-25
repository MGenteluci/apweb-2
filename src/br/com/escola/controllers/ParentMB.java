package br.com.escola.controllers;

import static br.com.escola.components.UrlBuilder.FACES_REDIRECT;
import static br.com.escola.components.UrlBuilder.REQUEST_PATH_PARENT;
import static br.com.escola.components.UrlBuilder.REQUEST_PATH_PARENTS;

import java.util.List;

import javax.faces.bean.ManagedBean;

import br.com.escola.models.Parent;
import br.com.escola.repository.ParentDAO;
import lombok.Data;

@ManagedBean
@Data
public class ParentMB {

	private ParentDAO dao = new ParentDAO();
	private Parent parent = new Parent();
	private List<Parent> parents = null;
	
	/*
	 * Methods |
	 * 		   v
	 */
	
	public List<Parent> getParents(){
		return this.parents == null ? this.dao.findAll() : this.parents;
	}
	
	public String pushParentPage() {
		return REQUEST_PATH_PARENT;
	}
	
	public String pushUpdateParent(Long id) {
		this.parent = this.dao.findById(id);
		
		return REQUEST_PATH_PARENT;
	}
	
	public String create() {
		this.dao.create(this.parent);
		
		return findAll();
	}
	
	public String findAll() {
		return REQUEST_PATH_PARENTS + FACES_REDIRECT;
	}
	
	public String remove(Long id) {
		Parent parent = this.dao.findById(id);
		this.dao.remove(parent);
		return findAll();
	}
	
}