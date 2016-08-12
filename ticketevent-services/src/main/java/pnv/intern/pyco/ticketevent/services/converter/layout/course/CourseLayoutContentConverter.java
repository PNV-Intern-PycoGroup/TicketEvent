package pnv.intern.pyco.ticketevent.services.converter.layout.course;

import pnv.intern.pyco.ticketevent.repository.entity.layout.course.CourseLayoutContentEntity;
import pnv.intern.pyco.ticketevent.repository.entity.layout.course.CourseLayoutEntity;
import pnv.intern.pyco.ticketevent.services.model.layout.course.CourseLayoutContentModel;
import pnv.intern.pyco.ticketevent.services.model.layout.course.CourseLayoutModel;

public class CourseLayoutContentConverter {
	public static boolean IS_CONVERT;

	public CourseLayoutContentConverter() {
	}

	public static CourseLayoutContentModel convertCourseLayoutContentEntityToDTO(CourseLayoutContentEntity courseLayoutContentEntity) {
		IS_CONVERT = true;
		
		CourseLayoutContentModel courseLayoutContentModel = new CourseLayoutContentModel();
		courseLayoutContentModel.setId(courseLayoutContentEntity.getId());
		courseLayoutContentModel.setTitle(courseLayoutContentEntity.getTitle());
		courseLayoutContentModel.setContent(courseLayoutContentEntity.getContent());
		
		CourseLayoutEntity courseLayoutEntity = courseLayoutContentEntity.getCourseLayout();
		if (!CourseLayoutConverter.IS_CONVERT && courseLayoutEntity != null) {
			courseLayoutContentModel.setCourseLayout(CourseLayoutConverter.convertCourseLayoutEntityToDTO(courseLayoutEntity));
		}
		
		IS_CONVERT = false;
		return courseLayoutContentModel;
	}

	public static CourseLayoutContentEntity convertDTOToCourseLayoutContentEntity(CourseLayoutContentModel courseLayoutContentModel) {
		IS_CONVERT = true;
		
		CourseLayoutContentEntity courseLayoutContentEntity = new CourseLayoutContentEntity();
		courseLayoutContentEntity.setId(courseLayoutContentModel.getId());
		courseLayoutContentEntity.setTitle(courseLayoutContentModel.getTitle());
		courseLayoutContentEntity.setContent(courseLayoutContentModel.getContent());
		
		CourseLayoutModel courseLayoutModel = courseLayoutContentModel.getCourseLayout();
		if (!CourseLayoutConverter.IS_CONVERT && courseLayoutModel != null) {
			courseLayoutContentEntity.setCourseLayout(CourseLayoutConverter.convertDTOToCourseLayoutEntity(courseLayoutModel));
		}
		
		IS_CONVERT = false;
		return courseLayoutContentEntity;
	}
}
