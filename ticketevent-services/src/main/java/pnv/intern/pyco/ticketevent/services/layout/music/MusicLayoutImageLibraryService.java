package pnv.intern.pyco.ticketevent.services.layout.music;

import pnv.intern.pyco.ticketevent.services.model.layout.music.MusicLayoutImageLibraryModel;

public interface MusicLayoutImageLibraryService {
	public MusicLayoutImageLibraryModel getMusicLayoutImageLibraryById(Long id);
	public MusicLayoutImageLibraryModel save(MusicLayoutImageLibraryModel musicLayoutImageLibraryModel);
	public void deleteByUrl(String url);
}
