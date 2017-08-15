package mum.ea.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Event {
	
	@Id @GeneratedValue
	private int id;
	
	@NotBlank
	@Column
	private String name;
	
	@NotNull
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
	private Date startDate;
	
	@NotNull
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
	private Date endDate;
	
	@ManyToOne
	private Facility facility;
	
	@OneToOne
	private User eventOrganizer;
	
	@NotNull
	@Column
	private int noOfPeople;
	
	@Column
	private boolean status;
	
	@ManyToOne
	private Category category;
	
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

	public Date getStartDate(){
		return startDate;
	}
	
	public void setStartDate(Date startDate){
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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public User getEventOrganizer() {
		return eventOrganizer;
	}

	public void setEventOrganizer(User eventOrganizer) {
		this.eventOrganizer = eventOrganizer;
	}
}