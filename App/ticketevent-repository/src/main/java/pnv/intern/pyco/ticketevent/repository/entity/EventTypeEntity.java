package pnv.intern.pyco.ticketevent.repository.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import pnv.intern.pyco.ticketevent.repository.util.DatabaseConstantUtil;

@Entity
@Table(name = DatabaseConstantUtil.EVENT_TYPE_TABLE)
public class EventTypeEntity {
	@Id
	@Column(name = DatabaseConstantUtil.EVENT_TYPE_FIELD_ID)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = DatabaseConstantUtil.EVENT_TYPE_FIELD_NAME)
	private String name;
	
	@OneToMany(mappedBy = "eventType")
	private Set<EventEntity> listEvent;

	public EventTypeEntity() {
		super();
	}

	public EventTypeEntity(String name) {
		super();
		this.name = name;
	}

	public EventTypeEntity(Long id, String name) {
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
