package pnv.intern.pyco.ticketevent.repository.layout.music;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pnv.intern.pyco.ticketevent.repository.entity.layout.music.MusicLayoutEntity;

public interface MusicLayoutRepository extends JpaRepository<MusicLayoutEntity, Long> {
	@Query("SELECT musicLayout FROM MusicLayoutEntity musicLayout WHERE musicLayout.eventId = ?1")
	MusicLayoutEntity findMusicLayoutByEventId(final Long eventId);

	@Query("SELECT musicLayout FROM MusicLayoutEntity musicLayout WHERE musicLayout.eventId = ?1 AND musicLayout.id = ?2")
	MusicLayoutEntity findMusicLayoutByEventIdAndMusicLayoutId(final Long eventId, final Long musicLayoutId);
}
