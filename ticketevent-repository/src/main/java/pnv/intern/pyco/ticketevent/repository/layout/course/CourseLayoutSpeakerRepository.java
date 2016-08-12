package pnv.intern.pyco.ticketevent.repository.layout.course;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pnv.intern.pyco.ticketevent.repository.entity.layout.course.CourseLayoutSpeakerEntity;

public interface CourseLayoutSpeakerRepository extends JpaRepository<CourseLayoutSpeakerEntity, Long> {
	@Query("SELECT courseSpeaker FROM CourseLayoutSpeakerEntity courseSpeaker WHERE courseSpeaker.image = ?1")
	CourseLayoutSpeakerEntity getCourseSpeakerByImageUrl(final String imageUrl);
}
