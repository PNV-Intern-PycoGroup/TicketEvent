package pnv.intern.pyco.ticketevent.repository.entity.layout.music;

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
@Table(name = DatabaseConstantUtil.MUSIC_LAYOUT_TABLE)
public class MusicLayoutEntity {
	@Id
	@Column(name = DatabaseConstantUtil.MUSIC_LAYOUT_FIELD_ID)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = DatabaseConstantUtil.MUSIC_LAYOUT_FIELD_EVENT_ID)
	private Long eventId;
	
	@Column(name = DatabaseConstantUtil.MUSIC_LAYOUT_FIELD_BANNER_IMAGE)
	private String bannerImage;
	
	@Column(name = DatabaseConstantUtil.MUSIC_LAYOUT_FIELD_LINK_HIGHLIGHT)
	private String linkHighlight;
	
	@Column(name = DatabaseConstantUtil.MUSIC_LAYOUT_FIELD_PLACE_IMAGE)
	private String placeImage;
	
	@OneToMany(mappedBy = "musicLayout")
	private Set<MusicLayoutFamousPersonEntity> listMusicLayouFamousPerson;
	
	@OneToMany(mappedBy = "musicLayout")
	private Set<MusicLayoutImageLibraryEntity> listMusicLayoutImageLibrary;

	public MusicLayoutEntity() {
		super();
	}

	public MusicLayoutEntity(Long eventId, String linkHighlight,
			String placeImage) {
		super();
		this.eventId = eventId;
		this.linkHighlight = linkHighlight;
		this.placeImage = placeImage;
	}

	public MusicLayoutEntity(Long id, Long eventId, String linkHighlight,
			String placeImage) {
		super();
		this.id = id;
		this.eventId = eventId;
		this.linkHighlight = linkHighlight;
		this.placeImage = placeImage;
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

	public Set<MusicLayoutFamousPersonEntity> getListMusicLayouFamousPerson() {
		return listMusicLayouFamousPerson;
	}

	public void setListMusicLayouFamousPerson(
			Set<MusicLayoutFamousPersonEntity> listMusicLayouFamousPerson) {
		this.listMusicLayouFamousPerson = listMusicLayouFamousPerson;
	}

	public Set<MusicLayoutImageLibraryEntity> getListMusicLayoutImageLibrary() {
		return listMusicLayoutImageLibrary;
	}

	public void setListMusicLayoutImageLibrary(
			Set<MusicLayoutImageLibraryEntity> listMusicLayoutImageLibrary) {
		this.listMusicLayoutImageLibrary = listMusicLayoutImageLibrary;
	}
	
}
