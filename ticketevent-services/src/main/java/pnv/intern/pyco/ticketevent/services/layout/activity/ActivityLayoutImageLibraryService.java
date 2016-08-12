package pnv.intern.pyco.ticketevent.services.layout.activity;

import pnv.intern.pyco.ticketevent.services.model.layout.activity.ActivityLayoutImageLibraryModel;

public interface ActivityLayoutImageLibraryService {
	public ActivityLayoutImageLibraryModel getActivityLayoutImageLibraryById(Long id);
	public ActivityLayoutImageLibraryModel save(ActivityLayoutImageLibraryModel activityLayoutImageLibraryModel);
	public void deleteByUrl(String url);
}
