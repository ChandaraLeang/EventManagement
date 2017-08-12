package mum.ea.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class Building {
	@Id
	@GeneratedValue
	private int id;
	@NotNull
	private String code;
	private String name;
	private int maxNoOfOccupants;
	
	@Enumerated(EnumType.STRING)
	private BuildingType type;

	@NotNull
	@OneToMany(mappedBy = "building")
	@ElementCollection
	private List<Room> rooms = new ArrayList<>();

	public Building() {
	}

	public Building(int id, String code, String name, int maxNoOfOccupants, List<Room> rooms, BuildingType type) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
		this.maxNoOfOccupants = maxNoOfOccupants;
		this.rooms = rooms;
		this.type = type;
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

	public int getMaxNoOfOccupants() {
		return maxNoOfOccupants;
	}

	public void setMaxNoOfOccupants(int maxNoOfOccupants) {
		this.maxNoOfOccupants = maxNoOfOccupants;
	}

	public List<Room> getRooms() {
		return rooms;
	}

	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}

	public BuildingType getType() {
		return type;
	}

	public void setType(BuildingType type) {
		this.type = type;
	}

}
