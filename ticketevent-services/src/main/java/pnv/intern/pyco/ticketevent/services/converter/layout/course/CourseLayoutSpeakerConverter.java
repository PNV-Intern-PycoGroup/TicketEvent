package pnv.intern.pyco.ticketevent.services.converter.layout.course;

import pnv.intern.pyco.ticketevent.repository.entity.layout.course.CourseLayoutEntity;
import pnv.intern.pyco.ticketevent.repository.entity.layout.course.CourseLayoutSpeakerEntity;
import pnv.intern.pyco.ticketevent.services.converter.layout.course.CourseLayoutConverter;
import pnv.intern.pyco.ticketevent.services.model.layout.course.CourseLayoutSpeakerModel;
import pnv.intern.pyco.ticketevent.services.model.layout.course.CourseLayoutModel;

public class CourseLayoutSpeakerConverter {
	public static boolean IS_CONVERT;

	public CourseLayoutSpeakerConverter() {
	}

	public static CourseLayoutSpeakerModel convertCourseLayoutSpeakerEntityToDTO(CourseLayoutSpeakerEntity courseLayoutSpeakerEntity) {
		IS_CONVERT = true;
		
		CourseLayoutSpeakerModel courseLayoutSpeakerModel = new CourseLayoutSpeakerModel();
		courseLayoutSpeakerModel.setId(courseLayoutSpeakerEntity.getId());
		courseLayoutSpeakerModel.setImage(courseLayoutSpeakerEntity.getImage());
		courseLayoutSpeakerModel.setName(courseLayoutSpeakerEntity.getName());
		courseLayoutSpeakerModel.setField(courseLayoutSpeakerEntity.getField());
		courseLayoutSpeakerModel.setHistory(courseLayoutSpeakerEntity.getHistory());
		
		CourseLayoutEntity courseLayoutEntity = courseLayoutSpeakerEntity.getCourseLayout();
		if (!CourseLayoutConverter.IS_CONVERT && courseLayoutEntity != null) {
			courseLayoutSpeakerModel.setCourseLayout(CourseLayoutConverter.convertCourseLayoutEntityToDTO(courseLayoutEntity));
		}
		
		IS_CONVERT = false;
		return courseLayoutSpeakerModel;
	}

	public static CourseLayoutSpeakerEntity convertDTOToCourseLayoutSpeakerEntity(CourseLayoutSpeakerModel courseLayoutSpeakerModel) {
		IS_CONVERT = true;
		
		CourseLayoutSpeakerEntity courseLayoutSpeakerEntity = new CourseLayoutSpeakerEntity();
		courseLayoutSpeakerEntity.setId(courseLayoutSpeakerModel.getId());
		courseLayoutSpeakerEntity.setImage(courseLayoutSpeakerModel.getImage());
		courseLayoutSpeakerEntity.setName(courseLayoutSpeakerModel.getName());
		courseLayoutSpeakerEntity.setField(courseLayoutSpeakerModel.getField());
		courseLayoutSpeakerEntity.setHistory(courseLayoutSpeakerModel.getHistory());
		
		CourseLayoutModel courseLayoutModel = courseLayoutSpeakerModel.getCourseLayout();
		if (!CourseLayoutConverter.IS_CONVERT && courseLayoutModel != null) {
			courseLayoutSpeakerEntity.setCourseLayout(CourseLayoutConverter.convertDTOToCourseLayoutEntity(courseLayoutModel));
		}
		
		IS_CONVERT = false;
		return courseLayoutSpeakerEntity;
	}
}
