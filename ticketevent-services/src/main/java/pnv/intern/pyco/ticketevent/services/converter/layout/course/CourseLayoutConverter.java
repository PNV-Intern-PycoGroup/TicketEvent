package pnv.intern.pyco.ticketevent.services.converter.layout.course;

import java.util.ArrayList;
import java.util.List;

import pnv.intern.pyco.ticketevent.repository.entity.layout.course.CourseLayoutContentEntity;
import pnv.intern.pyco.ticketevent.repository.entity.layout.course.CourseLayoutEntity;
import pnv.intern.pyco.ticketevent.repository.entity.layout.course.CourseLayoutSpeakerEntity;
import pnv.intern.pyco.ticketevent.services.model.layout.course.CourseLayoutContentModel;
import pnv.intern.pyco.ticketevent.services.model.layout.course.CourseLayoutModel;
import pnv.intern.pyco.ticketevent.services.model.layout.course.CourseLayoutSpeakerModel;

public class CourseLayoutConverter {
	public static boolean IS_CONVERT;

	public CourseLayoutConverter() {
	}

	public static CourseLayoutModel convertCourseLayoutEntityToDTO(CourseLayoutEntity courseLayoutEntity) {
		IS_CONVERT = true;
		
		CourseLayoutModel courseLayoutModel = new CourseLayoutModel();
		courseLayoutModel.setId(courseLayoutEntity.getId());
		courseLayoutModel.setEventId(courseLayoutEntity.getEventId());
		courseLayoutModel.setBannerImage(courseLayoutEntity.getBannerImage());
		courseLayoutModel.setPlaceImage(courseLayoutEntity.getPlaceImage());
		
		List<CourseLayoutContentEntity> listCourseLayoutContentEntity = courseLayoutEntity.getListCourseLayoutContent();
		if (!CourseLayoutContentConverter.IS_CONVERT && listCourseLayoutContentEntity != null) {
			List<CourseLayoutContentModel> listCourseLayoutContentModel = new ArrayList<CourseLayoutContentModel>();
			for (CourseLayoutContentEntity courseLayoutContentEntity : listCourseLayoutContentEntity) {
				listCourseLayoutContentModel.add(CourseLayoutContentConverter.convertCourseLayoutContentEntityToDTO(courseLayoutContentEntity));
			}
			courseLayoutModel.setListCourseLayoutContent(listCourseLayoutContentModel);
		}
		
		List<CourseLayoutSpeakerEntity> listCourseLayoutSpeakerEntity = courseLayoutEntity.getListCourseLayoutSpeaker();
		if (!CourseLayoutSpeakerConverter.IS_CONVERT && listCourseLayoutSpeakerEntity != null) {
			List<CourseLayoutSpeakerModel> listCourseLayoutSpeakerModel = new ArrayList<CourseLayoutSpeakerModel>();
			for (CourseLayoutSpeakerEntity courseLayoutSpeakerEntity : listCourseLayoutSpeakerEntity) {
				listCourseLayoutSpeakerModel.add(CourseLayoutSpeakerConverter.convertCourseLayoutSpeakerEntityToDTO(courseLayoutSpeakerEntity));
			}
			courseLayoutModel.setListCourseLayoutSpeaker(listCourseLayoutSpeakerModel);
		}
		
		IS_CONVERT = false;
		return courseLayoutModel;
	}

	public static CourseLayoutEntity convertDTOToCourseLayoutEntity(CourseLayoutModel courseLayoutModel) {
		IS_CONVERT = true;
		
		CourseLayoutEntity courseLayoutEntity = new CourseLayoutEntity();
		courseLayoutEntity.setId(courseLayoutModel.getId());
		courseLayoutEntity.setEventId(courseLayoutModel.getEventId());
		courseLayoutEntity.setBannerImage(courseLayoutModel.getBannerImage());
		courseLayoutEntity.setPlaceImage(courseLayoutModel.getPlaceImage());
		
		List<CourseLayoutContentModel> listCourseLayoutContentModel = courseLayoutModel.getListCourseLayoutContent();
		if (!CourseLayoutContentConverter.IS_CONVERT && listCourseLayoutContentModel != null) {
			List<CourseLayoutContentEntity> listCourseLayoutContentEntity = new ArrayList<CourseLayoutContentEntity>();
			for (CourseLayoutContentModel courseLayoutContentModel : listCourseLayoutContentModel) {
				listCourseLayoutContentEntity.add(CourseLayoutContentConverter.convertDTOToCourseLayoutContentEntity(courseLayoutContentModel));
			}
			courseLayoutEntity.setListCourseLayoutContent(listCourseLayoutContentEntity);
		}
		
		List<CourseLayoutSpeakerModel> listCourseLayoutSpeakerModel = courseLayoutModel.getListCourseLayoutSpeaker();
		if (!CourseLayoutSpeakerConverter.IS_CONVERT && listCourseLayoutSpeakerModel != null) {
			List<CourseLayoutSpeakerEntity> listCourseLayoutSpeakerEntity = new ArrayList<CourseLayoutSpeakerEntity>();
			for (CourseLayoutSpeakerModel courseLayoutSpeakerModel : listCourseLayoutSpeakerModel) {
				listCourseLayoutSpeakerEntity.add(CourseLayoutSpeakerConverter.convertDTOToCourseLayoutSpeakerEntity(courseLayoutSpeakerModel));
			}
			courseLayoutEntity.setListCourseLayoutSpeaker(listCourseLayoutSpeakerEntity);
		}
		
		IS_CONVERT = false;
		return courseLayoutEntity;
	}
}
