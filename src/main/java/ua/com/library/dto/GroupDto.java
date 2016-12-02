package ua.com.library.dto;

public class GroupDto {
	private String name;
	int id;

	public GroupDto(String name, int id) {
		super();
		this.name = name;
		this.id = id;
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

	public GroupDto() {
		super();
	
	}

	public GroupDto(String name) {
		super();
		this.name = name;
	}

	@Override
	public String toString() {
		return "GroupDto [name=" + name + "]";
	}
	
}
