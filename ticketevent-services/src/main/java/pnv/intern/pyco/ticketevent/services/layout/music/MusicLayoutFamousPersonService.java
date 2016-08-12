package pnv.intern.pyco.ticketevent.services.layout.music;

import pnv.intern.pyco.ticketevent.services.model.layout.music.MusicLayoutFamousPersonModel;

public interface MusicLayoutFamousPersonService {
	public MusicLayoutFamousPersonModel getMusicLayoutFamousPersonById(Long id);
	public MusicLayoutFamousPersonModel save(MusicLayoutFamousPersonModel musicLayoutFamousPersonModel);
	public MusicLayoutFamousPersonModel update(MusicLayoutFamousPersonModel musicLayoutFamousPersonModel);
	public void deleteByImageUrl(String url);
}
