package pnv.intern.pyco.ticketevent.services.model.layout.music;

import java.util.Set;

public class MusicLayoutModel {
	
	private Long id;
	
	private Long eventId;
	
	private String bannerImage;
	
	private String linkHighlight;
	
	private String placeImage;
	
	private Set<MusicLayoutFamousPersonModel> listMusicLayouFamousPerson;
	
	private Set<MusicLayoutImageLibraryModel> listMusicLayoutImageLibrary;
	
	public MusicLayoutModel() {
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

	public Set<MusicLayoutFamousPersonModel> getListMusicLayouFamousPerson() {
		return listMusicLayouFamousPerson;
	}

	public void setListMusicLayouFamousPerson(
			Set<MusicLayoutFamousPersonModel> listMusicLayouFamousPerson) {
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
