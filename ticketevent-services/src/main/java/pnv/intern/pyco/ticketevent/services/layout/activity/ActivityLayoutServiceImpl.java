package pnv.intern.pyco.ticketevent.services.layout.activity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pnv.intern.pyco.ticketevent.repository.entity.layout.activity.ActivityLayoutEntity;
import pnv.intern.pyco.ticketevent.repository.layout.activity.ActivityLayoutRepository;
import pnv.intern.pyco.ticketevent.services.converter.layout.activity.ActivityLayoutConverter;
import pnv.intern.pyco.ticketevent.services.model.layout.activity.ActivityLayoutModel;

@Service
public class ActivityLayoutServiceImpl implements ActivityLayoutService {

	@Autowired
	private ActivityLayoutRepository activityLayoutRepository;
	
	@Override
	public ActivityLayoutModel getActivityLayoutById(Long id) {
		ActivityLayoutModel activityLayoutModel = null;
		ActivityLayoutEntity activityLayoutEntity = activityLayoutRepository.findOne(id);
		if (activityLayoutEntity != null) {
			activityLayoutModel = ActivityLayoutConverter.convertActivityLayoutEntityToDTO(activityLayoutEntity);
		}
		return activityLayoutModel;
	}

	@Override
	public ActivityLayoutModel save(ActivityLayoutModel activityLayoutModel) {
		ActivityLayoutModel result = null;
		if (activityLayoutModel != null) {
			ActivityLayoutEntity activityLayoutEntity = activityLayoutRepository.save(ActivityLayoutConverter.convertDTOToActivityLayoutEntity(activityLayoutModel));
			if (activityLayoutEntity != null) {
				result = ActivityLayoutConverter.convertActivityLayoutEntityToDTO(activityLayoutEntity);
			}
		}
		
		return result;
	}

	@Override
	public ActivityLayoutModel findActivityLayoutByEventId(Long eventId) {
		ActivityLayoutModel result = null;
		if (eventId != null) {
			ActivityLayoutEntity activityLayoutEntity = activityLayoutRepository.findActivityLayoutByEventId(eventId);
			if (activityLayoutEntity != null) {
				result = ActivityLayoutConverter.convertActivityLayoutEntityToDTO(activityLayoutEntity);
			}
		}
		
		return result;
	}

	@Override
	public ActivityLayoutModel update(ActivityLayoutModel activityLayoutModel) {
		ActivityLayoutModel result = null;
		if (activityLayoutModel != null) {
			ActivityLayoutEntity activityLayoutEntity = activityLayoutRepository.saveAndFlush(ActivityLayoutConverter.convertDTOToActivityLayoutEntity(activityLayoutModel));
			if (activityLayoutEntity != null) {
				result = ActivityLayoutConverter.convertActivityLayoutEntityToDTO(activityLayoutEntity);
			}
		}
		return result;
	}

	@Override
	public boolean isExistActivityLayoutByEventId(Long eventId, Long activityLayoutId) {
		ActivityLayoutEntity result = null;
		if (eventId != null && activityLayoutId != null) {
			result = activityLayoutRepository.findActivityLayoutByEventIdAndActivityLayoutId(eventId, activityLayoutId);
		}
		return result != null;
	}

}
