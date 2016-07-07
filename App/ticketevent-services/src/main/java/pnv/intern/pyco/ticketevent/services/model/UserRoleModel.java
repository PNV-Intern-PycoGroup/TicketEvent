package pnv.intern.pyco.ticketevent.services.model;

public class UserRoleModel {
	private Integer id;
	private String role;
	
	public UserRoleModel(){}
	
	public UserRoleModel(Integer id, String role) {
		super();
		this.id = id;
		this.role = role;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	
}
