package pnv.intern.pyco.ticketevent.services.model;

public class MusicLayoutImageLibModel {

	private Integer id;
	private Integer musicLayoutId;
	private String image;
	
	public MusicLayoutImageLibModel() {}

	public MusicLayoutImageLibModel(Integer id, Integer musicLayoutId,
			String image) {
		this.id = id;
		this.musicLayoutId = musicLayoutId;
		this.image = image;
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
	
	
	
}
