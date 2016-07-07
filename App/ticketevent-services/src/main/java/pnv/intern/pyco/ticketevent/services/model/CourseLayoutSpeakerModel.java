package pnv.intern.pyco.ticketevent.services.model;

public class CourseLayoutSpeakerModel {

	private Integer id;
	private Integer courseLayoutId;
	private String name;
	private String field;
	private String history;
	private String image;
	
	public CourseLayoutSpeakerModel() {	}

	public CourseLayoutSpeakerModel(Integer id, Integer courseLayoutId,
			String name, String field, String history, String image) {
		super();
		this.id = id;
		this.courseLayoutId = courseLayoutId;
		this.name = name;
		this.field = field;
		this.history = history;
		this.image = image;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCourseLayoutId() {
		return courseLayoutId;
	}

	public void setCourseLayoutId(Integer courseLayoutId) {
		this.courseLayoutId = courseLayoutId;
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
