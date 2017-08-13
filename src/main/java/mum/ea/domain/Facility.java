package mum.ea.domain;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 * @author Kisi1
 *
 */
@Entity
public class Facility {

	@Id
	@GeneratedValue
	private int id;
	private String code;
	private String name;
	private int maxPeople;

	@OneToOne
	@JoinColumn(name = "roomId", nullable = true)
	private Room room;

	@Enumerated(EnumType.STRING)
	private FacilityType type;

	private String description;

	private boolean isAvailable;

	public Facility() {
	}

	public Facility(int id, String code, String name, int maxPeople, Room room, boolean isAvailable) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
		this.maxPeople = maxPeople;
		this.room = room;
		this.isAvailable = isAvailable;
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

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public FacilityType getType() {
		return type;
	}

	public void setType(FacilityType type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
