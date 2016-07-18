package pnv.intern.pyco.ticketevent.services.model.layout.music;

import java.util.Set;

import pnv.intern.pyco.ticketevent.services.model.EventModel;

public class MusicLayoutModel {
	
	private Long id;
	
	private Long eventId;
	
	private String linkHighlight;
	
	private String placeImage;
	
	private Set<MusicLayouFamousPersonModel> listMusicLayouFamousPerson;
	
	private Set<MusicLayoutImageLibraryModel> listMusicLayoutImageLibrary;
	
	//TODO
	// - Need change this function to get exactly Event
	public EventModel getEvent() {
		return new EventModel();
	}
	
	public MusicLayoutModel() {
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

	public String getLinkHighlight() {
		return linkHighlight;
	}

	public void setLinkHighlight(String linkHighlight) {
		this.linkHighlight = linkHighlight;
	}

	public String getPlaceImage() {
		return placeImage;
	}

	public void setPlaceImage(String placeImage) {
		this.placeImage = placeImage;
	}

	public Set<MusicLayouFamousPersonModel> getListMusicLayouFamousPerson() {
		return listMusicLayouFamousPerson;
	}

	public void setListMusicLayouFamousPerson(
			Set<MusicLayouFamousPersonModel> listMusicLayouFamousPerson) {
		this.listMusicLayouFamousPerson = listMusicLayouFamousPerson;
	}

	public Set<MusicLayoutImageLibraryModel> getListMusicLayoutImageLibrary() {
		return listMusicLayoutImageLibrary;
	}

	public void setListMusicLayoutImageLibrary(
			Set<MusicLayoutImageLibraryModel> listMusicLayoutImageLibrary) {
		this.listMusicLayoutImageLibrary = listMusicLayoutImageLibrary;
	}
	
}
