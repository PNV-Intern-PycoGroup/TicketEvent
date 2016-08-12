package pnv.intern.pyco.ticketevent.repository.layout.course;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pnv.intern.pyco.ticketevent.repository.entity.layout.course.CourseLayoutEntity;

public interface CourseLayoutRepository extends JpaRepository<CourseLayoutEntity, Long> {
	@Query("SELECT courseLayout FROM CourseLayoutEntity courseLayout WHERE courseLayout.eventId = ?1")
	CourseLayoutEntity findCourseLayoutByEventId(final Long eventId);

	@Query("SELECT courseLayout FROM CourseLayoutEntity courseLayout WHERE courseLayout.eventId = ?1 AND courseLayout.id = ?2")
	CourseLayoutEntity findCourseLayoutByEventIdAndCourseLayoutId(final Long eventId, final Long courseLayoutId);
}
