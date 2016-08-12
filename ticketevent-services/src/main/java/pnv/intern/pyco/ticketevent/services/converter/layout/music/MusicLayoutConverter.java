package pnv.intern.pyco.ticketevent.services.converter.layout.music;

import java.util.HashSet;
import java.util.Set;

import pnv.intern.pyco.ticketevent.repository.entity.layout.music.MusicLayoutEntity;
import pnv.intern.pyco.ticketevent.repository.entity.layout.music.MusicLayoutFamousPersonEntity;
import pnv.intern.pyco.ticketevent.repository.entity.layout.music.MusicLayoutImageLibraryEntity;
import pnv.intern.pyco.ticketevent.services.model.layout.music.MusicLayoutFamousPersonModel;
import pnv.intern.pyco.ticketevent.services.model.layout.music.MusicLayoutImageLibraryModel;
import pnv.intern.pyco.ticketevent.services.model.layout.music.MusicLayoutModel;

public class MusicLayoutConverter {
	public static boolean IS_CONVERT;

	public MusicLayoutConverter() {
	}

	public static MusicLayoutModel convertMusicLayoutEntityToDTO(MusicLayoutEntity musicLayoutEntity) {
		IS_CONVERT = true;
		
		MusicLayoutModel musicLayoutModel = new MusicLayoutModel();
		musicLayoutModel.setId(musicLayoutEntity.getId());
		musicLayoutModel.setEventId(musicLayoutEntity.getEventId());
		musicLayoutModel.setBannerImage(musicLayoutEntity.getBannerImage());
		musicLayoutModel.setPlaceImage(musicLayoutEntity.getPlaceImage());
		musicLayoutModel.setLinkHighlight(musicLayoutEntity.getLinkHighlight());
		
		Set<MusicLayoutImageLibraryEntity> listMusicLayoutImageLibraryEntity = musicLayoutEntity.getListMusicLayoutImageLibrary();
		if (!MusicLayoutImageLibraryConverter.IS_CONVERT && listMusicLayoutImageLibraryEntity != null) {
			Set<MusicLayoutImageLibraryModel> listMusicLayoutImageLibraryModel = new HashSet<MusicLayoutImageLibraryModel>();
			for (MusicLayoutImageLibraryEntity musicLayoutImageLibraryEntity : listMusicLayoutImageLibraryEntity) {
				listMusicLayoutImageLibraryModel.add(MusicLayoutImageLibraryConverter.convertMusicLayoutImageLibraryEntityToDTO(musicLayoutImageLibraryEntity));
			}
			musicLayoutModel.setListMusicLayoutImageLibrary(listMusicLayoutImageLibraryModel);
		}
		
		Set<MusicLayoutFamousPersonEntity> listMusicLayoutFamousPersonEntity = musicLayoutEntity.getListMusicLayouFamousPerson();
		if (!MusicLayoutFamousPersonConverter.IS_CONVERT && listMusicLayoutFamousPersonEntity != null) {
			Set<MusicLayoutFamousPersonModel> listMusicLayoutFamousPersonModel = new HashSet<MusicLayoutFamousPersonModel>();
			for (MusicLayoutFamousPersonEntity musicLayoutFamousPersonEntity : listMusicLayoutFamousPersonEntity) {
				listMusicLayoutFamousPersonModel.add(MusicLayoutFamousPersonConverter.convertMusicLayoutFamousPersonEntityToDTO(musicLayoutFamousPersonEntity));
			}
			musicLayoutModel.setListMusicLayouFamousPerson(listMusicLayoutFamousPersonModel);
		}
		
		IS_CONVERT = false;
		return musicLayoutModel;
	}

	public static MusicLayoutEntity convertDTOToMusicLayoutEntity(MusicLayoutModel musicLayoutModel) {
		IS_CONVERT = true;
		
		MusicLayoutEntity musicLayoutEntity = new MusicLayoutEntity();
		musicLayoutEntity.setId(musicLayoutModel.getId());
		musicLayoutEntity.setEventId(musicLayoutModel.getEventId());
		musicLayoutEntity.setBannerImage(musicLayoutModel.getBannerImage());
		musicLayoutEntity.setPlaceImage(musicLayoutModel.getPlaceImage());
		musicLayoutEntity.setLinkHighlight(musicLayoutModel.getLinkHighlight());
		
		Set<MusicLayoutImageLibraryModel> listMusicLayoutImageLibraryModel = musicLayoutModel.getListMusicLayoutImageLibrary();
		if (!MusicLayoutImageLibraryConverter.IS_CONVERT && listMusicLayoutImageLibraryModel != null) {
			Set<MusicLayoutImageLibraryEntity> listMusicLayoutImageLibraryEntity = new HashSet<MusicLayoutImageLibraryEntity>();
			for (MusicLayoutImageLibraryModel musicLayoutImageLibraryModel : listMusicLayoutImageLibraryModel) {
				listMusicLayoutImageLibraryEntity.add(MusicLayoutImageLibraryConverter.convertDTOToMusicLayoutImageLibraryEntity(musicLayoutImageLibraryModel));
			}
			musicLayoutEntity.setListMusicLayoutImageLibrary(listMusicLayoutImageLibraryEntity);
		}
		
		Set<MusicLayoutFamousPersonModel> listMusicLayoutFamousPersonModel = musicLayoutModel.getListMusicLayouFamousPerson();
		if (!MusicLayoutFamousPersonConverter.IS_CONVERT && listMusicLayoutFamousPersonModel != null) {
			Set<MusicLayoutFamousPersonEntity> listMusicLayoutFamousPersonEntity = new HashSet<MusicLayoutFamousPersonEntity>();
			for (MusicLayoutFamousPersonModel musicLayoutFamousPersonModel : listMusicLayoutFamousPersonModel) {
				listMusicLayoutFamousPersonEntity.add(MusicLayoutFamousPersonConverter.convertDTOToMusicLayoutFamousPersonEntity(musicLayoutFamousPersonModel));
			}
			musicLayoutEntity.setListMusicLayouFamousPerson(listMusicLayoutFamousPersonEntity);
		}
		
		IS_CONVERT = false;
		return musicLayoutEntity;
	}
}
