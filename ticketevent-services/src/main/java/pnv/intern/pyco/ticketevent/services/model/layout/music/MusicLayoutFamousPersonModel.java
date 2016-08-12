package pnv.intern.pyco.ticketevent.services.model.layout.music;

import java.text.SimpleDateFormat;
import java.util.Date;


public class MusicLayoutFamousPersonModel {
	
	private Long id;
	
	private MusicLayoutModel musicLayout;
	
	private String image;
	
	private String name;
	
	private Date dateOfBirth;
	
	private String introduction;

	public MusicLayoutFamousPersonModel() {
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public MusicLayoutModel getMusicLayout() {
		return musicLayout;
	}

	public void setMusicLayout(MusicLayoutModel musicLayout) {
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
	
	public String getDateOfBirthString() {
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy"); 
		String result = null;
		if (dateOfBirth != null) {
			result = format.format(dateOfBirth);
		}
		return result;
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
