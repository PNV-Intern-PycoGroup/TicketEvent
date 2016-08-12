package pnv.intern.pyco.ticketevent.services.layout.music;

import pnv.intern.pyco.ticketevent.services.model.layout.music.MusicLayoutModel;

public interface MusicLayoutService {
	public MusicLayoutModel getMusicLayoutById(Long id);
	public MusicLayoutModel save(MusicLayoutModel musicLayoutModel);
	public MusicLayoutModel findMusicLayoutByEventId(Long eventId);
	public MusicLayoutModel update(MusicLayoutModel musicLayoutModel);
	public boolean isExistMusicLayoutByEventId(Long eventId, Long musicLayoutId);
}
