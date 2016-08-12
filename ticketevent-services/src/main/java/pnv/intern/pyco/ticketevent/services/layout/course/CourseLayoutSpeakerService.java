package pnv.intern.pyco.ticketevent.services.layout.course;

import pnv.intern.pyco.ticketevent.services.model.layout.course.CourseLayoutSpeakerModel;

public interface CourseLayoutSpeakerService {
	public CourseLayoutSpeakerModel getCourseLayoutSpeakerById(Long id);
	public CourseLayoutSpeakerModel save(CourseLayoutSpeakerModel courseLayoutSpeakerModel);
	public CourseLayoutSpeakerModel update(CourseLayoutSpeakerModel courseLayoutSpeakerModel);
	public void deleteByImageUrl(String url);
}
