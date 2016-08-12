package pnv.intern.pyco.ticketevent.repository.entity.layout.music;

import java.util.Date;

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
@Table(name = DatabaseConstantUtil.MUSIC_LAYOUT_FAMOUS_PERSON_TABLE)
public class MusicLayoutFamousPersonEntity {
	@Id
	@Column(name = DatabaseConstantUtil.MUSIC_LAYOUT_FAMOUS_PERSON_FIELD_ID)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = DatabaseConstantUtil.MUSIC_LAYOUT_FAMOUS_PERSON_FIELD_MUSIC_LAYOUT_ID)
	private MusicLayoutEntity musicLayout;
	
	@Column(name = DatabaseConstantUtil.MUSIC_LAYOUT_FAMOUS_PERSON_FIELD_IMAGE)
	private String image;
	
	@Column(name = DatabaseConstantUtil.MUSIC_LAYOUT_FAMOUS_PERSON_FIELD_NAME)
	private String name;
	
	@Column(name = DatabaseConstantUtil.MUSIC_LAYOUT_FAMOUS_PERSON_FIELD_DATE_OF_BIRTH)
	private Date dateOfBirth;
	
	@Column(name = DatabaseConstantUtil.MUSIC_LAYOUT_FAMOUS_PERSON_FIELD_INTRODUCTION)
	private String introduction;
	
	public MusicLayoutFamousPersonEntity() {
		super();
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	
}
