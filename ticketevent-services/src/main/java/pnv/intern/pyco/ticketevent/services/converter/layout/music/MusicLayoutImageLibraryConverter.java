package pnv.intern.pyco.ticketevent.services.converter.layout.music;

import pnv.intern.pyco.ticketevent.repository.entity.layout.music.MusicLayoutEntity;
import pnv.intern.pyco.ticketevent.repository.entity.layout.music.MusicLayoutImageLibraryEntity;
import pnv.intern.pyco.ticketevent.services.model.layout.music.MusicLayoutImageLibraryModel;
import pnv.intern.pyco.ticketevent.services.model.layout.music.MusicLayoutModel;

public class MusicLayoutImageLibraryConverter {
	public static boolean IS_CONVERT;

	public MusicLayoutImageLibraryConverter() {
	}

	public static MusicLayoutImageLibraryModel convertMusicLayoutImageLibraryEntityToDTO(MusicLayoutImageLibraryEntity musicLayoutImageLibraryEntity) {
		IS_CONVERT = true;
		MusicLayoutImageLibraryModel musicLayoutImageLibraryModel = new MusicLayoutImageLibraryModel();
		musicLayoutImageLibraryModel.setId(musicLayoutImageLibraryEntity.getId());
		musicLayoutImageLibraryModel.setImage(musicLayoutImageLibraryEntity.getImage());
		
		MusicLayoutEntity musicLayoutEntity = musicLayoutImageLibraryEntity.getMusicLayout();
		if (!MusicLayoutConverter.IS_CONVERT && musicLayoutEntity != null) {
			musicLayoutImageLibraryModel.setMusicLayout(MusicLayoutConverter.convertMusicLayoutEntityToDTO(musicLayoutEntity));
		}
		
		IS_CONVERT = false;
		return musicLayoutImageLibraryModel;
	}

	public static MusicLayoutImageLibraryEntity convertDTOToMusicLayoutImageLibraryEntity(MusicLayoutImageLibraryModel musicLayoutImageLibraryModel) {
		IS_CONVERT = true;
		MusicLayoutImageLibraryEntity musicLayoutImageLibraryEntity = new MusicLayoutImageLibraryEntity();
		musicLayoutImageLibraryEntity.setId(musicLayoutImageLibraryModel.getId());
		musicLayoutImageLibraryEntity.setImage(musicLayoutImageLibraryModel.getImage());
		
		MusicLayoutModel musicLayoutModel = musicLayoutImageLibraryModel.getMusicLayout();
		if (!MusicLayoutConverter.IS_CONVERT && musicLayoutModel != null) {
			musicLayoutImageLibraryEntity.setMusicLayout(MusicLayoutConverter.convertDTOToMusicLayoutEntity(musicLayoutModel));
		}
		
		IS_CONVERT = false;
		return musicLayoutImageLibraryEntity;
	}
}
