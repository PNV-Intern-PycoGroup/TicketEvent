package pnv.intern.pyco.ticketevent.repository.layout.music;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pnv.intern.pyco.ticketevent.repository.entity.layout.music.MusicLayoutImageLibraryEntity;

public interface MusicLayoutImageLibraryRepository extends JpaRepository<MusicLayoutImageLibraryEntity, Long>{
	@Query("SELECT musicImageLib FROM MusicLayoutImageLibraryEntity musicImageLib WHERE musicImageLib.image = ?1")
	MusicLayoutImageLibraryEntity getMusicImageLibraryByUrl(final String urlImage);
}
