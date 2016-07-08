package pnv.intern.pyco.ticketevent.repository.entity.layout.activity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import pnv.intern.pyco.ticketevent.repository.entity.EventsEntity;
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
	private String losogan;

	public ActivityLayoutEntity() {
		super();
	}

	public ActivityLayoutEntity(Long eventId, String backgroundImage,
			String eventLogo, String losogan) {
		super();
		this.eventId = eventId;
		this.backgroundImage = backgroundImage;
		this.eventLogo = eventLogo;
		this.losogan = losogan;
	}

	public ActivityLayoutEntity(Long id, Long eventId, String backgroundImage,
			String eventLogo, String losogan) {
		super();
		this.id = id;
		this.eventId = eventId;
		this.backgroundImage = backgroundImage;
		this.eventLogo = eventLogo;
		this.losogan = losogan;
	}

	//TODO
	// - Need change this function to get exactly Event
	public EventsEntity getEvent() {
		return new EventsEntity();
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

	public String getLosogan() {
		return losogan;
	}

	public void setLosogan(String losogan) {
		this.losogan = losogan;
	}
	
}
