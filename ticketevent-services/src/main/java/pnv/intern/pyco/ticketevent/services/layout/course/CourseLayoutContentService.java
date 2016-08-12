package pnv.intern.pyco.ticketevent.services.layout.course;

import pnv.intern.pyco.ticketevent.services.model.layout.course.CourseLayoutContentModel;

public interface CourseLayoutContentService {
	public CourseLayoutContentModel getCourseLayoutContentById(Long id);
	public CourseLayoutContentModel save(CourseLayoutContentModel courseLayoutContentModel);
	public CourseLayoutContentModel update(CourseLayoutContentModel courseLayoutContentModel);
	public void deleteById(Long id);
}
