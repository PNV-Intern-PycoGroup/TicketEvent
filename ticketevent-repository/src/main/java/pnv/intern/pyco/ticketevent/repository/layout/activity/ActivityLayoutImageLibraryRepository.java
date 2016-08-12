package pnv.intern.pyco.ticketevent.repository.layout.activity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pnv.intern.pyco.ticketevent.repository.entity.layout.activity.ActivityLayoutImageLibraryEntity;

public interface ActivityLayoutImageLibraryRepository extends JpaRepository<ActivityLayoutImageLibraryEntity, Long>{
	@Query("SELECT activityImageLib FROM ActivityLayoutImageLibraryEntity activityImageLib WHERE activityImageLib.image = ?1")
	ActivityLayoutImageLibraryEntity getActivityImageLibraryByUrl(final String urlImage);
}
