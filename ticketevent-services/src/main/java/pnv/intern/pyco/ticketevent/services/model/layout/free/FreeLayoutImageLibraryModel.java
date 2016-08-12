package pnv.intern.pyco.ticketevent.services.model.layout.free;


public class FreeLayoutImageLibraryModel {
	
	private Long id;
	
	private FreeLayoutModel freeLayout;
	
	private String image;

	public FreeLayoutImageLibraryModel() {
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public FreeLayoutModel getFreeLayout() {
		return freeLayout;
	}

	public void setFreeLayout(FreeLayoutModel freeLayout) {
		this.freeLayout = freeLayout;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

}
