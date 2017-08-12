package mum.ea.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
public class Event {
	
	@Id @GeneratedValue
	private int id;
	@NotNull
	@Column
	private String name;
	@NotNull
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date startDate;
	@NotNull
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date endDate;
	
	@ManyToOne
	private Facility facility;
	
	@NotNull
	@Column
	private int noOfPeople;
	@Column
	private boolean status;
	
	@OneToMany
	private List<Category> categories = new ArrayList<>();
	
	public Event(){
		
	}
	
	public Event(String name, Date startDate, Date endDate, Facility facility, int noOfPeople, boolean status, List<Category> categories){
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.facility = facility;
		this.noOfPeople = noOfPeople;
		this.status = status;
		this.categories = categories;
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

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Facility getFacility() {
		return facility;
	}

	public void setFacility(Facility facility) {
		this.facility = facility;
	}

	public int getNoOfPeople() {
		return noOfPeople;
	}

	public void setNoOfPeople(int noOfPeople) {
		this.noOfPeople = noOfPeople;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
}