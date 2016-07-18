package pnv.intern.pyco.ticketevent.services.model.layout.music;


public class MusicLayouFamousPersonModel {
	
	private Long id;
	
	private MusicLayoutModel musicLayout;
	
	private String image;
	
	private String name;
	
	private String dateOfBirth;
	
	private String tailent;
	
	private String history;

	public MusicLayouFamousPersonModel() {
		// TODO Auto-generated constructor stub
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

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
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
