package pnv.intern.pyco.ticketevent.repository.entity.layout.activity;

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
@Table(name = DatabaseConstantUtil.ACTIVITY_LAYOUT_TABLE)
public class ActivityLayoutEntity {
	@Id
	@Column(name = DatabaseConstantUtil.ACTIVITY_LAYOUT_FIELD_ID)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = DatabaseConstantUtil.ACTIVITY_LAYOUT_FIELD_EVENT_ID)
	private Long eventId;
	
	@Column(name = DatabaseConstantUtil.ACTIVITY_LAYOUT_FIELD_BACKGROUND_IMAGE)
	private String backgroundImage;
	
	@Column(name = DatabaseConstantUtil.ACTIVITY_LAYOUT_FIELD_EVENT_LOGO)
	private String eventLogo;
	
	@Column(name = DatabaseConstantUtil.ACTIVITY_LAYOUT_FIELD_SOLOGAN)
	private String sologan;
	
	@OneToMany(mappedBy = "activityLayout")
	private Set<ActivityLayoutImageLibraryEntity> listActivityLayoutImageLibrary;

	public ActivityLayoutEntity() {
		super();
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

	public String getBackgroundImage() {
		return backgroundImage;
	}

	public void setBackgroundImage(String backgroundImage) {
		this.backgroundImage = backgroundImage;
	}

	public String getEventLogo() {
		return eventLogo;
	}

	public void setEventLogo(String eventLogo) {
		this.eventLogo = eventLogo;
	}

	public String getSologan() {
		return sologan;
	}

	public void setSologan(String sologan) {
		this.sologan = sologan;
	}

	public Set<ActivityLayoutImageLibraryEntity> getListActivityLayoutImageLibrary() {
		return listActivityLayoutImageLibrary;
	}

	public void setListActivityLayoutImageLibrary(
			Set<ActivityLayoutImageLibraryEntity> listActivityLayoutImageLibrary) {
		this.listActivityLayoutImageLibrary = listActivityLayoutImageLibrary;
	}
	
}
