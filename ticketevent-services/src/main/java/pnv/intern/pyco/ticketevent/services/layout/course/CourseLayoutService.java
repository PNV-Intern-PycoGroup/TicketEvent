package pnv.intern.pyco.ticketevent.services.layout.course;

import pnv.intern.pyco.ticketevent.services.model.layout.course.CourseLayoutModel;

public interface CourseLayoutService {

	public CourseLayoutModel getCourseLayoutById(Long id);
	public CourseLayoutModel save(CourseLayoutModel courseLayoutModel);
	public CourseLayoutModel findCourseLayoutByEventId(Long eventId);
	public CourseLayoutModel update(CourseLayoutModel courseLayoutModel);
	public boolean isExistCourseLayoutByEventId(Long eventId, Long courseLayoutId);
}
