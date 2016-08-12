package pnv.intern.pyco.ticketevent.repository.layout.activity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pnv.intern.pyco.ticketevent.repository.entity.layout.activity.ActivityLayoutEntity;

public interface ActivityLayoutRepository extends JpaRepository<ActivityLayoutEntity, Long> {
	@Query("SELECT activityLayout FROM ActivityLayoutEntity activityLayout WHERE activityLayout.eventId = ?1")
	ActivityLayoutEntity findActivityLayoutByEventId(final Long eventId);

	@Query("SELECT activityLayout FROM ActivityLayoutEntity activityLayout WHERE activityLayout.eventId = ?1 AND activityLayout.id = ?2")
	ActivityLayoutEntity findActivityLayoutByEventIdAndActivityLayoutId(final Long eventId, final Long activityLayoutId);
}
