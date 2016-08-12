package pnv.intern.pyco.ticketevent.services.converter.layout.activity;

import java.util.HashSet;
import java.util.Set;

import pnv.intern.pyco.ticketevent.repository.entity.layout.activity.ActivityLayoutEntity;
import pnv.intern.pyco.ticketevent.repository.entity.layout.activity.ActivityLayoutImageLibraryEntity;
import pnv.intern.pyco.ticketevent.services.model.layout.activity.ActivityLayoutImageLibraryModel;
import pnv.intern.pyco.ticketevent.services.model.layout.activity.ActivityLayoutModel;

public class ActivityLayoutConverter {
	public static boolean IS_CONVERT;

	public ActivityLayoutConverter() {
	}

	public static ActivityLayoutModel convertActivityLayoutEntityToDTO(ActivityLayoutEntity activityLayoutEntity) {
		IS_CONVERT = true;
		
		ActivityLayoutModel activityLayoutModel = new ActivityLayoutModel();
		activityLayoutModel.setId(activityLayoutEntity.getId());
		activityLayoutModel.setEventId(activityLayoutEntity.getEventId());
		activityLayoutModel.setBackgroundImage(activityLayoutEntity.getBackgroundImage());
		activityLayoutModel.setEventLogo(activityLayoutEntity.getEventLogo());
		activityLayoutModel.setSologan(activityLayoutEntity.getSologan());
		
		Set<ActivityLayoutImageLibraryEntity> listActivityLayoutImageLibraryEntity =  activityLayoutEntity.getListActivityLayoutImageLibrary();
		if (!ActivityLayoutImageLibraryConverter.IS_CONVERT && listActivityLayoutImageLibraryEntity != null) {
			Set<ActivityLayoutImageLibraryModel> listActivityLayoutImageLibraryModel = new HashSet<ActivityLayoutImageLibraryModel>();
			for (ActivityLayoutImageLibraryEntity activityLayoutImageLibraryEntity : listActivityLayoutImageLibraryEntity) {
				listActivityLayoutImageLibraryModel.add(ActivityLayoutImageLibraryConverter.convertActivityLayoutImageLibraryEntityToDTO(activityLayoutImageLibraryEntity));
			}
			activityLayoutModel.setListActivityLayoutImageLibrary(listActivityLayoutImageLibraryModel);
		}
		
		IS_CONVERT = false;
		return activityLayoutModel;
	}

	public static ActivityLayoutEntity convertDTOToActivityLayoutEntity(ActivityLayoutModel activityLayoutModel) {
		IS_CONVERT = true;
		
		ActivityLayoutEntity activityLayoutEntity = new ActivityLayoutEntity();
		activityLayoutEntity.setId(activityLayoutModel.getId());
		activityLayoutEntity.setEventId(activityLayoutModel.getEventId());
		activityLayoutEntity.setBackgroundImage(activityLayoutModel.getBackgroundImage());
		activityLayoutEntity.setEventLogo(activityLayoutModel.getEventLogo());
		activityLayoutEntity.setSologan(activityLayoutModel.getSologan());
		
		Set<ActivityLayoutImageLibraryModel> listActivityLayoutImageLibraryModel =  activityLayoutModel.getListActivityLayoutImageLibrary();
		if (!ActivityLayoutImageLibraryConverter.IS_CONVERT && listActivityLayoutImageLibraryModel != null) {
			Set<ActivityLayoutImageLibraryEntity> listActivityLayoutImageLibraryEntity = new HashSet<ActivityLayoutImageLibraryEntity>();
			for (ActivityLayoutImageLibraryModel activityLayoutImageLibraryModel : listActivityLayoutImageLibraryModel) {
				listActivityLayoutImageLibraryEntity.add(ActivityLayoutImageLibraryConverter.convertDTOToActivityLayoutImageLibraryEntity(activityLayoutImageLibraryModel));
			}
			activityLayoutEntity.setListActivityLayoutImageLibrary(listActivityLayoutImageLibraryEntity);
		}
		
		IS_CONVERT = false;
		return activityLayoutEntity;
	}
}
