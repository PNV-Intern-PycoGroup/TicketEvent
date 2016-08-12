package pnv.intern.pyco.ticketevent.services.converter.layout.music;

import pnv.intern.pyco.ticketevent.repository.entity.layout.music.MusicLayoutEntity;
import pnv.intern.pyco.ticketevent.repository.entity.layout.music.MusicLayoutFamousPersonEntity;
import pnv.intern.pyco.ticketevent.services.model.layout.music.MusicLayoutFamousPersonModel;
import pnv.intern.pyco.ticketevent.services.model.layout.music.MusicLayoutModel;

public class MusicLayoutFamousPersonConverter {
	public static boolean IS_CONVERT;

	public MusicLayoutFamousPersonConverter() {
	}

	public static MusicLayoutFamousPersonModel convertMusicLayoutFamousPersonEntityToDTO(MusicLayoutFamousPersonEntity musicLayoutFamousPersonEntity) {
		IS_CONVERT = true;
		
		MusicLayoutFamousPersonModel musicLayoutFamousPersonModel = new MusicLayoutFamousPersonModel();
		musicLayoutFamousPersonModel.setId(musicLayoutFamousPersonEntity.getId());
		musicLayoutFamousPersonModel.setImage(musicLayoutFamousPersonEntity.getImage());
		musicLayoutFamousPersonModel.setName(musicLayoutFamousPersonEntity.getName());
		musicLayoutFamousPersonModel.setDateOfBirth(musicLayoutFamousPersonEntity.getDateOfBirth());
		musicLayoutFamousPersonModel.setIntroduction(musicLayoutFamousPersonEntity.getIntroduction());
		
		MusicLayoutEntity musicLayoutEntity = musicLayoutFamousPersonEntity.getMusicLayout();
		if (!MusicLayoutConverter.IS_CONVERT && musicLayoutEntity != null) {
			musicLayoutFamousPersonModel.setMusicLayout(MusicLayoutConverter.convertMusicLayoutEntityToDTO(musicLayoutEntity));
		}
		
		IS_CONVERT = false;
		return musicLayoutFamousPersonModel;
	}

	public static MusicLayoutFamousPersonEntity convertDTOToMusicLayoutFamousPersonEntity(MusicLayoutFamousPersonModel musicLayoutFamousPersonModel) {
		IS_CONVERT = true;
		
		MusicLayoutFamousPersonEntity musicLayoutFamousPersonEntity = new MusicLayoutFamousPersonEntity();
		musicLayoutFamousPersonEntity.setId(musicLayoutFamousPersonModel.getId());
		musicLayoutFamousPersonEntity.setImage(musicLayoutFamousPersonModel.getImage());
		musicLayoutFamousPersonEntity.setName(musicLayoutFamousPersonModel.getName());
		musicLayoutFamousPersonEntity.setDateOfBirth(musicLayoutFamousPersonModel.getDateOfBirth());
		musicLayoutFamousPersonEntity.setIntroduction(musicLayoutFamousPersonModel.getIntroduction());
		
		MusicLayoutModel musicLayoutModel = musicLayoutFamousPersonModel.getMusicLayout();
		if (!MusicLayoutConverter.IS_CONVERT && musicLayoutModel != null) {
			musicLayoutFamousPersonEntity.setMusicLayout(MusicLayoutConverter.convertDTOToMusicLayoutEntity(musicLayoutModel));
		}
		
		IS_CONVERT = false;
		return musicLayoutFamousPersonEntity;
	}
}
