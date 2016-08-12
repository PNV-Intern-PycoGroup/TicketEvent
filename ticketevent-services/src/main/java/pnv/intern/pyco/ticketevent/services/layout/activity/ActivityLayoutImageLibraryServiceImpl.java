package pnv.intern.pyco.ticketevent.services.layout.activity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pnv.intern.pyco.ticketevent.repository.entity.layout.activity.ActivityLayoutImageLibraryEntity;
import pnv.intern.pyco.ticketevent.repository.layout.activity.ActivityLayoutImageLibraryRepository;
import pnv.intern.pyco.ticketevent.services.converter.layout.activity.ActivityLayoutImageLibraryConverter;
import pnv.intern.pyco.ticketevent.services.model.layout.activity.ActivityLayoutImageLibraryModel;

@Service
public class ActivityLayoutImageLibraryServiceImpl implements ActivityLayoutImageLibraryService {

	@Autowired
	private ActivityLayoutImageLibraryRepository activityLayoutImageLibraryRepository;
	
	@Override
	public ActivityLayoutImageLibraryModel getActivityLayoutImageLibraryById(Long id) {
		ActivityLayoutImageLibraryModel activityLayoutImageLibraryModel = null;
		if (id != null) {
			ActivityLayoutImageLibraryEntity activityLayoutImageLibraryEntity = activityLayoutImageLibraryRepository.findOne(id);
			if (activityLayoutImageLibraryEntity != null) {
				activityLayoutImageLibraryModel = ActivityLayoutImageLibraryConverter.convertActivityLayoutImageLibraryEntityToDTO(activityLayoutImageLibraryEntity);
			}
		}
		return activityLayoutImageLibraryModel;
	}

	@Override
	public ActivityLayoutImageLibraryModel save(ActivityLayoutImageLibraryModel activityLayoutImageLibraryModel) {
		ActivityLayoutImageLibraryModel result = null;
		if (activityLayoutImageLibraryModel != null) {
			ActivityLayoutImageLibraryEntity activityLayoutImageLibraryEntity = activityLayoutImageLibraryRepository.save(ActivityLayoutImageLibraryConverter.convertDTOToActivityLayoutImageLibraryEntity(activityLayoutImageLibraryModel));
			if (activityLayoutImageLibraryEntity != null) {
				activityLayoutImageLibraryModel = ActivityLayoutImageLibraryConverter.convertActivityLayoutImageLibraryEntityToDTO(activityLayoutImageLibraryEntity);
			}
		}
		return result;
	}

	@Override
	public void deleteByUrl(String url) {
		ActivityLayoutImageLibraryEntity activityLayoutImageLibraryEntity = activityLayoutImageLibraryRepository.getActivityImageLibraryByUrl(url);
		activityLayoutImageLibraryRepository.delete(activityLayoutImageLibraryEntity);
	}

}
