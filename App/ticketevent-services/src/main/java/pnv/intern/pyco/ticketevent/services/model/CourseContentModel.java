package pnv.intern.pyco.ticketevent.services.model;

public class CourseContentModel {

	private Integer id;
	private Integer courseId;
	private String title;
	private String content;
	
	public CourseContentModel() {}

	public CourseContentModel(Integer id, Integer courseId, String title,
			String content) {
		this.id = id;
		this.courseId = courseId;
		this.title = title;
		this.content = content;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCourseId() {
		return courseId;
	}

	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
