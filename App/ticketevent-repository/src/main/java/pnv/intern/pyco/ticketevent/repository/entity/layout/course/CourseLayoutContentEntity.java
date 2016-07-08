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
@Table(name = DatabaseConstantUtil.COURSE_LAYOUT_CONTENT_TABLE)
public class CourseLayoutContentEntity {
	@Id
	@Column(name = DatabaseConstantUtil.COURSE_LAYOUT_CONTENT_FIELD_ID)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = DatabaseConstantUtil.COURSE_LAYOUT_CONTENT_FIELD_COURSE_LAYOUT_ID)
	private CourseLayoutEntity courseLayout;
	
	@Column(name = DatabaseConstantUtil.COURSE_LAYOUT_CONTENT_FIELD_TITLE)
	private String title;
	
	@Column(name = DatabaseConstantUtil.COURSE_LAYOUT_CONTENT_FIELD_CONTENT)
	private String content;

	public CourseLayoutContentEntity() {
		super();
	}

	public CourseLayoutContentEntity(CourseLayoutEntity courseLayout,
			String title, String content) {
		super();
		this.courseLayout = courseLayout;
		this.title = title;
		this.content = content;
	}

	public CourseLayoutContentEntity(Long id, CourseLayoutEntity courseLayout,
			String title, String content) {
		super();
		this.id = id;
		this.courseLayout = courseLayout;
		this.title = title;
		this.content = content;
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
