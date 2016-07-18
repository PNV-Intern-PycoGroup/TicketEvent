package pnv.intern.pyco.ticketevent.services.model.layout.course;


public class CourseLayoutContentModel {
	
	private Long id;
	
	private CourseLayoutModel courseLayout;
	
	private String title;
	
	private String content;

	public CourseLayoutContentModel() {
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
