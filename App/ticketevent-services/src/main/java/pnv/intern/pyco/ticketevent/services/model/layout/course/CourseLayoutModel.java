package pnv.intern.pyco.ticketevent.services.model.layout.course;

import java.util.Set;

import pnv.intern.pyco.ticketevent.services.model.EventModel;

public class CourseLayoutModel {
	
	private Long id;
	
	private Long eventId;
	
	private String bannerImage;
	
	private String placeImage;
	
	private Set<CourseLayoutContentModel> listCourseLayoutContent;
	
	private Set<CourseLayoutSpeakerModel> listCourseLayoutSpeaker;
	
	//TODO
	// - Need change this function to get exactly Event
	public EventModel getEvent() {
		return new EventModel();
	}

	public CourseLayoutModel() {
		// TODO Auto-generated constructor stub
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

	public Set<CourseLayoutContentModel> getListCourseLayoutContent() {
		return listCourseLayoutContent;
	}

	public void setListCourseLayoutContent(
			Set<CourseLayoutContentModel> listCourseLayoutContent) {
		this.listCourseLayoutContent = listCourseLayoutContent;
	}

	public Set<CourseLayoutSpeakerModel> getListCourseLayoutSpeaker() {
		return listCourseLayoutSpeaker;
	}

	public void setListCourseLayoutSpeaker(
			Set<CourseLayoutSpeakerModel> listCourseLayoutSpeaker) {
		this.listCourseLayoutSpeaker = listCourseLayoutSpeaker;
	}

}
