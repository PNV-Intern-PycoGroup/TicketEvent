package pnv.intern.pyco.ticketevent.services.model.layout.activity;

import java.util.Set;

public class ActivityLayoutModel {
	
	private Long id;
	
	private Long eventId;
	
	private String backgroundImage;
	
	private String eventLogo;
	
	private String sologan;
	
	private Set<ActivityLayoutImageLibraryModel> listActivityLayoutImageLibrary;
	
	public ActivityLayoutModel() {
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

	public Set<ActivityLayoutImageLibraryModel> getListActivityLayoutImageLibrary() {
		return listActivityLayoutImageLibrary;
	}

	public void setListActivityLayoutImageLibrary(
			Set<ActivityLayoutImageLibraryModel> listActivityLayoutImageLibrary) {
		this.listActivityLayoutImageLibrary = listActivityLayoutImageLibrary;
	}
	
}
