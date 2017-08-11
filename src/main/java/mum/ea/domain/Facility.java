package mum.ea.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Facility {
	
	@Id @GeneratedValue
	private int id;
	private String code;
	private String name;
	private int maxPeople;
	
	public Facility() {
		
	}
	
	public Facility(int id, String code, String name, int maxPeople) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
		this.maxPeople = maxPeople;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMaxPeople() {
		return maxPeople;
	}
	public void setMaxPeople(int maxPeople) {
		this.maxPeople = maxPeople;
	}
	
	

}
