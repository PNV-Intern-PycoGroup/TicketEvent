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
public class MusicLayouFamousPersonEntity {
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
	
	@Column(name = DatabaseConstantUtil.MUSIC_LAYOUT_FAMOUS_PERSON_FIELD_TALENT)
	private String tailent;
	
	@Column(name = DatabaseConstantUtil.MUSIC_LAYOUT_FAMOUS_PERSON_FIELD_HISTORY)
	private String history;

	public MusicLayouFamousPersonEntity() {
		super();
	}

	public MusicLayouFamousPersonEntity(MusicLayoutEntity musicLayout,
			String image, String name, Date dateOfBirth, String tailent,
			String history) {
		super();
		this.musicLayout = musicLayout;
		this.image = image;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.tailent = tailent;
		this.history = history;
	}

	public MusicLayouFamousPersonEntity(Long id, MusicLayoutEntity musicLayout,
			String image, String name, Date dateOfBirth, String tailent,
			String history) {
		super();
		this.id = id;
		this.musicLayout = musicLayout;
		this.image = image;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.tailent = tailent;
		this.history = history;
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

	public String getTailent() {
		return tailent;
	}

	public void setTailent(String tailent) {
		this.tailent = tailent;
	}

	public String getHistory() {
		return history;
	}

	public void setHistory(String history) {
		this.history = history;
	}
	
}
