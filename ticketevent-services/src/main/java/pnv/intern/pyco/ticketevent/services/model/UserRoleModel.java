package pnv.intern.pyco.ticketevent.services.model;


public class UserRoleModel {
	
	private long id;
	
	private String role;

	public long getId() {
		return id;
	}
	
	public UserRoleModel() {
	}

	public UserRoleModel(long i, String string) {
		this.id = i;
		this.role = string;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
