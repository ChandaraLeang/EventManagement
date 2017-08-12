package mum.ea.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Category {

	@Id @GeneratedValue
	private int id;
	@NotNull
	@Column
	private String name;
	@Column
	private String description;
	
	@ManyToOne
	private Event event;
	
	public Category(){
		
	}
	
	public Category(String name, String description, Event event){
		this.name = name;
		this.description = description;
		this.event = event;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}