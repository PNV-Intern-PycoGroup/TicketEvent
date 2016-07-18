package pnv.intern.pyco.ticketevent.services.model.layout.activity;

import java.util.Set;

import pnv.intern.pyco.ticketevent.services.model.EventModel;

public class ActivityLayoutModel {
	
	private Long id;
	
	private Long eventId;
	
	private String backgroundImage;
	
	private String eventLogo;
	
	private String losogan;
	
	private Set<ActivityLayoutImageLibraryModel> listActivityLayoutImageLibrary;
	
	//TODO
	// - Need change this function to get exactly Event
	public EventModel getEvent() {
		return new EventModel();
	}

	public ActivityLayoutModel() {
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

	public Set<ActivityLayoutImageLibraryModel> getListActivityLayoutImageLibrary() {
		return listActivityLayoutImageLibrary;
	}

	public void setListActivityLayoutImageLibrary(
			Set<ActivityLayoutImageLibraryModel> listActivityLayoutImageLibrary) {
		this.listActivityLayoutImageLibrary = listActivityLayoutImageLibrary;
	}
	
}
