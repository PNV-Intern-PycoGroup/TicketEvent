package pnv.intern.pyco.ticketevent.repository.entity.layout.activity;

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
@Table(name = DatabaseConstantUtil.ACTIVITY_LAYOUT_IMAGE_LIBRARY_TABLE)
public class ActivityLayoutImageLibraryEntity {
	@Id
	@Column(name = DatabaseConstantUtil.ACTIVITY_LAYOUT_IMAGE_LIBRARY_FIELD_ID)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = DatabaseConstantUtil.ACTIVITY_LAYOUT_IMAGE_LIBRARY_FIELD_ACTIVITY_LAYOUT_ID)
	private ActivityLayoutEntity activityLayout;
	
	@Column(name = DatabaseConstantUtil.ACTIVITY_LAYOUT_IMAGE_LIBRARY_FIELD_IMAGE)
	private String image;
	
	public ActivityLayoutImageLibraryEntity() {
		super();
	}

	public ActivityLayoutImageLibraryEntity(
			ActivityLayoutEntity activityLayout, String image) {
		super();
		this.activityLayout = activityLayout;
		this.image = image;
	}

	public ActivityLayoutImageLibraryEntity(Long id,
			ActivityLayoutEntity activityLayout, String image) {
		super();
		this.id = id;
		this.activityLayout = activityLayout;
		this.image = image;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ActivityLayoutEntity getActivityLayout() {
		return activityLayout;
	}

	public void setActivityLayout(ActivityLayoutEntity activityLayout) {
		this.activityLayout = activityLayout;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
}
