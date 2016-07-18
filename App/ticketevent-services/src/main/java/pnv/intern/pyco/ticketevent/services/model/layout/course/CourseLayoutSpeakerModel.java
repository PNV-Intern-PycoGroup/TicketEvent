package pnv.intern.pyco.ticketevent.services.model.layout.course;


public class CourseLayoutSpeakerModel {
	
	private Long id;
	
	private CourseLayoutModel courseLayout;
	
	private String name;
	
	private String filed;
	
	private String history;
	
	private String image;

	public CourseLayoutSpeakerModel() {
		// TODO Auto-generated constructor stub
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public CourseLayoutModel getCourseLayout() {
		return courseLayout;
	}

	public void setCourseLayout(CourseLayoutModel courseLayout) {
		this.courseLayout = courseLayout;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFiled() {
		return filed;
	}

	public void setFiled(String filed) {
		this.filed = filed;
	}

	public String getHistory() {
		return history;
	}

	public void setHistory(String history) {
		this.history = history;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

}
