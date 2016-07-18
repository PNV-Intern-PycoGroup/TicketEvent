package pnv.intern.pyco.ticketevent.services.model.layout.music;


public class MusicLayoutImageLibraryModel {
	
	private Long id;
	
	private MusicLayoutModel musicLayout;
	
	private String image;

	public MusicLayoutImageLibraryModel() {
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

}
