package pnv.intern.pyco.ticketevent.repository.entity.layout.music;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import pnv.intern.pyco.ticketevent.repository.util.DatabaseConstantUtil;

@Entity
@Table(name = DatabaseConstantUtil.MUSIC_LAYOUT_IMAGE_LIBRARY_TABLE)
public class MusicLayoutImageLibraryEntity {
	@Id
	@Column(name = DatabaseConstantUtil.MUSIC_LAYOUT_IMAGE_LIBRARY_FIELD_ID)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = DatabaseConstantUtil.MUSIC_LAYOUT_IMAGE_LIBRARY_FIELD_MUSIC_LAYOUT_ID)
	private MusicLayoutEntity musicLayout;
	
	@Column(name = DatabaseConstantUtil.MUSIC_LAYOUT_IMAGE_LIBRARY_FIELD_IMAGE)
	private String image;

	public MusicLayoutImageLibraryEntity() {
		super();
	}

	public MusicLayoutImageLibraryEntity(MusicLayoutEntity musicLayout,
			String image) {
		super();
		this.musicLayout = musicLayout;
		this.image = image;
	}

	public MusicLayoutImageLibraryEntity(Long id,
			MusicLayoutEntity musicLayout, String image) {
		super();
		this.id = id;
		this.musicLayout = musicLayout;
		this.image = image;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public MusicLayoutEntity getMusicLayout() {
		return musicLayout;
	}

	public void setMusicLayout(MusicLayoutEntity musicLayout) {
		this.musicLayout = musicLayout;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
}
