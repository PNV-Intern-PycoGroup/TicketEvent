package pnv.intern.pyco.ticketevent.services.model;

public class FreeLayoutImageLibModel {

	private Integer id;
	private Integer freeLayoutId;
	private String image;
	
	public FreeLayoutImageLibModel() {}

	public FreeLayoutImageLibModel(Integer id, Integer freeLayoutId, String image) {
		this.id = id;
		this.freeLayoutId = freeLayoutId;
		this.image = image;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getFreeLayoutId() {
		return freeLayoutId;
	}

	public void setFreeLayoutId(Integer freeLayoutId) {
		this.freeLayoutId = freeLayoutId;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
}
