package pnv.intern.pyco.ticketevent.repository.entity.layout.free;

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
@Table(name = DatabaseConstantUtil.FREE_LAYOUT_IMAGE_LIBRARY_TABLE)
public class FreeLayoutImageLibraryEntity {
	@Id
	@Column(name = DatabaseConstantUtil.FREE_LAYOUT_IMAGE_LIBRARY_FIELD_ID)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = DatabaseConstantUtil.FREE_LAYOUT_IMAGE_LIBRARY_FIELD_FREE_LAYOUT_ID)
	private FreeLayoutEntity freeLayout;
	
	@Column(name = DatabaseConstantUtil.FREE_LAYOUT_IMAGE_LIBRARY_FIELD_IMAGE)
	private String image;

	public FreeLayoutImageLibraryEntity() {
		super();
	}

	public FreeLayoutImageLibraryEntity(FreeLayoutEntity freeLayout,
			String image) {
		super();
		this.freeLayout = freeLayout;
		this.image = image;
	}

	public FreeLayoutImageLibraryEntity(Long id, FreeLayoutEntity freeLayout,
			String image) {
		super();
		this.id = id;
		this.freeLayout = freeLayout;
		this.image = image;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public FreeLayoutEntity getFreeLayout() {
		return freeLayout;
	}

	public void setFreeLayout(FreeLayoutEntity freeLayout) {
		this.freeLayout = freeLayout;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
}
