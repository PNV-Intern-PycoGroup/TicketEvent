package pnv.intern.pyco.ticketevent.repository.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import pnv.intern.pyco.ticketevent.repository.util.DatabaseConstantUtil;

@Entity
@Table(name = DatabaseConstantUtil.USER_ROLE_TABLE)
public class UserRoleEntity {
	
	@Id
	@Column(name = DatabaseConstantUtil.USER_ROLE_FIELD_ID)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = DatabaseConstantUtil.USER_ROLE_FIELD_ROLE)
	private String role;

	public UserRoleEntity() {
		super();
	}

	public UserRoleEntity(String role) {
		super();
		this.role = role;
	}

	public UserRoleEntity(long id, String role) {
		super();
		this.id = id;
		this.role = role;
	}

	public Long getId() {
		return id;
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
