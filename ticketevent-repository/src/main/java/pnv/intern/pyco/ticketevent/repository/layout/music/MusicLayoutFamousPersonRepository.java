package pnv.intern.pyco.ticketevent.repository.layout.music;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pnv.intern.pyco.ticketevent.repository.entity.layout.music.MusicLayoutFamousPersonEntity;

public interface MusicLayoutFamousPersonRepository extends JpaRepository<MusicLayoutFamousPersonEntity, Long> {
	@Query("SELECT musicFamousPerson FROM MusicLayoutFamousPersonEntity musicFamousPerson WHERE musicFamousPerson.image = ?1")
	MusicLayoutFamousPersonEntity getMusicFamouPersonByImageUrl(final String imageUrl);
}
