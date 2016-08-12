package pnv.intern.pyco.ticketevent.repository.layout.free;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pnv.intern.pyco.ticketevent.repository.entity.layout.free.FreeLayoutImageLibraryEntity;

public interface FreeLayoutImageLibraryRepository extends JpaRepository<FreeLayoutImageLibraryEntity, Long> {
	@Query("SELECT freeImageLib FROM FreeLayoutImageLibraryEntity freeImageLib WHERE freeImageLib.image = ?1")
	FreeLayoutImageLibraryEntity getFreeImageLibraryByUrl(final String urlImage);
}
