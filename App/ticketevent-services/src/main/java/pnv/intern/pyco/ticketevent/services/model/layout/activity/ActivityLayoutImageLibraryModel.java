package pnv.intern.pyco.ticketevent.services.model.layout.activity;


public class ActivityLayoutImageLibraryModel {
	
	private Long id;
	
	private ActivityLayoutModel activityLayout;
	
	private String image;

	public ActivityLayoutImageLibraryModel() {
		// TODO Auto-generated constructor stub
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ActivityLayoutModel getActivityLayout() {
		return activityLayout;
	}

	public void setActivityLayout(ActivityLayoutModel activityLayout) {
		this.activityLayout = activityLayout;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
}
