package pnv.intern.pyco.ticketevent.services.model;

import java.util.Date;

public class MusicLayoutFamousPersonModel {

	private Integer id;
	private Integer musicLayoutId;
	private String image;
	private String name;
	private Date dayOfBirth;
	private String tailent;
	private String history;
	
	public MusicLayoutFamousPersonModel() {}

	public MusicLayoutFamousPersonModel(Integer id, Integer musicLayoutId,
			String image, String name, Date dayOfBirth, String tailent,
			String history) {
		this.id = id;
		this.musicLayoutId = musicLayoutId;
		this.image = image;
		this.name = name;
		this.dayOfBirth = dayOfBirth;
		this.tailent = tailent;
		this.history = history;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getMusicLayoutId() {
		return musicLayoutId;
	}

	public void setMusicLayoutId(Integer musicLayoutId) {
		this.musicLayoutId = musicLayoutId;
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

	public Date getDayOfBirth() {
		return dayOfBirth;
	}

	public void setDayOfBirth(Date dayOfBirth) {
		this.dayOfBirth = dayOfBirth;
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
