package pnv.intern.pyco.ticketevent.repository.entity.layout.course;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import pnv.intern.pyco.ticketevent.repository.entity.EventsEntity;
import pnv.intern.pyco.ticketevent.repository.util.DatabaseConstantUtil;

@Entity
@Table(name = DatabaseConstantUtil.COURSE_LAYOUT_TABLE)
public class CourseLayoutEntity {
	@Id
	@Column(name = DatabaseConstantUtil.COURSE_LAYOUT_FIELD_ID)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = DatabaseConstantUtil.COURSE_LAYOUT_FIELD_EVENT_ID)
	private Long eventId;
	
	@Column(name = DatabaseConstantUtil.COURSE_LAYOUT_FIELD_BANNER_IMAGE)
	private String bannerImage;
	
	@Column(name = DatabaseConstantUtil.COURSE_LAYOUT_FIELD_PLACE_IMAGE)
	private String placeImage;
	
	@OneToMany(mappedBy = "courseLayout")
	private Set<CourseLayoutContentEntity> listCourseLayoutContent;
	
	@OneToMany(mappedBy = "courseLayout")
	private Set<CourseLayoutSpeakerEntity> listCourseLayoutSpeaker;

	public CourseLayoutEntity() {
		super();
	}

	public CourseLayoutEntity(Long eventId, String bannerImage,
			String placeImage) {
		super();
		this.eventId = eventId;
		this.bannerImage = bannerImage;
		this.placeImage = placeImage;
	}

	public CourseLayoutEntity(Long id, Long eventId, String bannerImage,
			String placeImage) {
		super();
		this.id = id;
		this.eventId = eventId;
		this.bannerImage = bannerImage;
		this.placeImage = placeImage;
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

	public String getBannerImage() {
		return bannerImage;
	}

	public void setBannerImage(String bannerImage) {
		this.bannerImage = bannerImage;
	}

	public String getPlaceImage() {
		return placeImage;
	}

	public void setPlaceImage(String placeImage) {
		this.placeImage = placeImage;
	}
	
}
