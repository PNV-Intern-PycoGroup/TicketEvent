package pnv.intern.pyco.ticketevent.repository.entity.layout.free;

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
@Table(name = DatabaseConstantUtil.FREE_LAYOUT_TABLE)
public class FreeLayoutEntity {
	@Id
	@Column(name = DatabaseConstantUtil.FREE_LAYOUT_FIELD_ID)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = DatabaseConstantUtil.FREE_LAYOUT_FIELD_EVENT_ID)
	private Long eventId;
	
	@Column(name = DatabaseConstantUtil.FREE_LAYOUT_FIELD_CONTENT)
	private String content;
	
	@OneToMany(mappedBy = "freeLayout")
	private Set<FreeLayoutImageLibraryEntity> listFreeLayoutImageLibrary;

	public FreeLayoutEntity() {
		super();
	}

	public FreeLayoutEntity(Long eventId, String content) {
		super();
		this.eventId = eventId;
		this.content = content;
	}

	public FreeLayoutEntity(Long id, Long eventId, String content) {
		super();
		this.id = id;
		this.eventId = eventId;
		this.content = content;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getEventId() {
		return eventId;
	}

	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Set<FreeLayoutImageLibraryEntity> getListFreeLayoutImageLibrary() {
		return listFreeLayoutImageLibrary;
	}

	public void setListFreeLayoutImageLibrary(
			Set<FreeLayoutImageLibraryEntity> listFreeLayoutImageLibrary) {
		this.listFreeLayoutImageLibrary = listFreeLayoutImageLibrary;
	}
	
}
