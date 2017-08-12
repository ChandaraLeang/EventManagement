package mum.ea.domain;


import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Building {
	@Id
	@GeneratedValue
	private int id;
	@NotNull
	private String code;
	private String name;
	
	@Enumerated(EnumType.STRING)
	private BuildingType type;

	public Building() {
	}

	public Building(int id, String code, String name, BuildingType type) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
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

	public BuildingType getType() {
		return type;
	}

	public void setType(BuildingType type) {
		this.type = type;
	}

}
