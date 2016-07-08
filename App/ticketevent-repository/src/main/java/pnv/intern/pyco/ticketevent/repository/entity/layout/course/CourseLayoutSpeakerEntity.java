package pnv.intern.pyco.ticketevent.repository.entity.layout.course;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import pnv.intern.pyco.ticketevent.repository.util.DatabaseConstantUtil;

@Entity
@Table(name = DatabaseConstantUtil.COURSE_LAYOUT_SPEAKER_TABLE)
public class CourseLayoutSpeakerEntity {
	@Id
	@Column(name = DatabaseConstantUtil.COURSE_LAYOUT_SPEAKER_FIELD_ID)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = DatabaseConstantUtil.COURSE_LAYOUT_SPEAKER_FIELD_COURSE_LAYOUT_ID)
	private CourseLayoutEntity courseLayout;
	
	@Column(name = DatabaseConstantUtil.COURSE_LAYOUT_SPEAKER_FIELD_NAME)
	private String name;
	
	@Column(name = DatabaseConstantUtil.COURSE_LAYOUT_SPEAKER_FIELD_FIELD)
	private String filed;
	
	@Column(name = DatabaseConstantUtil.COURSE_LAYOUT_SPEAKER_FIELD_HISTORY)
	private String history;
	
	@Column(name = DatabaseConstantUtil.COURSE_LAYOUT_SPEAKER_FIELD_IMAGE)
	private String image;

	public CourseLayoutSpeakerEntity() {
		super();
	}

	public CourseLayoutSpeakerEntity(CourseLayoutEntity courseLayout,
			String name, String filed, String history, String image) {
		super();
		this.courseLayout = courseLayout;
		this.name = name;
		this.filed = filed;
		this.history = history;
		this.image = image;
	}

	public CourseLayoutSpeakerEntity(Long id, CourseLayoutEntity courseLayout,
			String name, String filed, String history, String image) {
		super();
		this.id = id;
		this.courseLayout = courseLayout;
		this.name = name;
		this.filed = filed;
		this.history = history;
		this.image = image;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public CourseLayoutEntity getCourseLayout() {
		return courseLayout;
	}

	public void setCourseLayout(CourseLayoutEntity courseLayout) {
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
