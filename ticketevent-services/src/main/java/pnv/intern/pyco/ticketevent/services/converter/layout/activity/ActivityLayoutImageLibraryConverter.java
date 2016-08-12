package pnv.intern.pyco.ticketevent.services.converter.layout.activity;

import pnv.intern.pyco.ticketevent.repository.entity.layout.activity.ActivityLayoutEntity;
import pnv.intern.pyco.ticketevent.repository.entity.layout.activity.ActivityLayoutImageLibraryEntity;
import pnv.intern.pyco.ticketevent.services.model.layout.activity.ActivityLayoutImageLibraryModel;
import pnv.intern.pyco.ticketevent.services.model.layout.activity.ActivityLayoutModel;

public class ActivityLayoutImageLibraryConverter {
	public static boolean IS_CONVERT;

	public ActivityLayoutImageLibraryConverter() {
	}

	public static ActivityLayoutImageLibraryModel convertActivityLayoutImageLibraryEntityToDTO(ActivityLayoutImageLibraryEntity activityLayoutImageLibraryEntity) {
		IS_CONVERT = true;
		
		ActivityLayoutImageLibraryModel activityLayoutImageLibraryModel = new ActivityLayoutImageLibraryModel();
		activityLayoutImageLibraryModel.setId(activityLayoutImageLibraryEntity.getId());
		activityLayoutImageLibraryModel.setImage(activityLayoutImageLibraryEntity.getImage());
		
		ActivityLayoutEntity activityLayoutEntity = activityLayoutImageLibraryEntity.getActivityLayout();
		if (!ActivityLayoutConverter.IS_CONVERT && activityLayoutEntity != null) {
			activityLayoutImageLibraryModel.setActivityLayout(ActivityLayoutConverter.convertActivityLayoutEntityToDTO(activityLayoutEntity));
		}
		
		IS_CONVERT = false;
		return activityLayoutImageLibraryModel;
	}

	public static ActivityLayoutImageLibraryEntity convertDTOToActivityLayoutImageLibraryEntity(ActivityLayoutImageLibraryModel activityLayoutImageLibraryModel) {
		IS_CONVERT = true;
		
		ActivityLayoutImageLibraryEntity activityLayoutImageLibraryEntity = new ActivityLayoutImageLibraryEntity();
		activityLayoutImageLibraryEntity.setId(activityLayoutImageLibraryModel.getId());
		activityLayoutImageLibraryEntity.setImage(activityLayoutImageLibraryModel.getImage());
		
		ActivityLayoutModel activityLayoutModel = activityLayoutImageLibraryModel.getActivityLayout();
		if (!ActivityLayoutConverter.IS_CONVERT && activityLayoutModel != null) {
			activityLayoutImageLibraryEntity.setActivityLayout(ActivityLayoutConverter.convertDTOToActivityLayoutEntity(activityLayoutModel));
		}
		
		IS_CONVERT = false;
		return activityLayoutImageLibraryEntity;
	}
}
