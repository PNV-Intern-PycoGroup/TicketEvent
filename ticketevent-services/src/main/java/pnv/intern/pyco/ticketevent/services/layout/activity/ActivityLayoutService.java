package pnv.intern.pyco.ticketevent.services.layout.activity;

import pnv.intern.pyco.ticketevent.services.model.layout.activity.ActivityLayoutModel;

public interface ActivityLayoutService {

	public ActivityLayoutModel getActivityLayoutById(Long id);
	public ActivityLayoutModel save(ActivityLayoutModel activityLayoutModel);
	public ActivityLayoutModel findActivityLayoutByEventId(Long eventId);
	public ActivityLayoutModel update(ActivityLayoutModel activityLayoutModel);
	public boolean isExistActivityLayoutByEventId(Long eventId, Long activityLayoutId);
}
