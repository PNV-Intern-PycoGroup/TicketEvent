package pnv.intern.pyco.ticketevent.services.model.layout.course;


public class CourseLayoutSpeakerModel {
	
	private Long id;
	
	private CourseLayoutModel courseLayout;
	
	private String name;
	
	private String field;
	
	private String history;
	
	private String image;

	public CourseLayoutSpeakerModel() {
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

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
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
