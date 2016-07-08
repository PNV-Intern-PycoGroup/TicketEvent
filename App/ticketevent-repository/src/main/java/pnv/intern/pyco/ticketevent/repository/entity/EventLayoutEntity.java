package pnv.intern.pyco.ticketevent.repository.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import pnv.intern.pyco.ticketevent.repository.util.DatabaseConstantUtil;

@Entity
@Table(name = DatabaseConstantUtil.EVENT_LAYOUT_TABLE)
public class EventLayoutEntity {
	@Id
	@Column(name = DatabaseConstantUtil.EVENT_LAYOUT_FIELD_ID)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = DatabaseConstantUtil.EVENT_LAYOUT_FIELD_NAME)
	private String name;

	public EventLayoutEntity() {
		super();
	}

	public EventLayoutEntity(String name) {
		super();
		this.name = name;
	}

	public EventLayoutEntity(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
