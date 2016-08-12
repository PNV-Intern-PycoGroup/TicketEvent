package pnv.intern.pyco.ticketevent.services.layout.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pnv.intern.pyco.ticketevent.repository.entity.layout.course.CourseLayoutSpeakerEntity;
import pnv.intern.pyco.ticketevent.repository.layout.course.CourseLayoutSpeakerRepository;
import pnv.intern.pyco.ticketevent.services.converter.layout.course.CourseLayoutSpeakerConverter;
import pnv.intern.pyco.ticketevent.services.model.layout.course.CourseLayoutSpeakerModel;

@Service
public class CourseLayoutSpeakerServiceImpl implements CourseLayoutSpeakerService {

	@Autowired
	private CourseLayoutSpeakerRepository courseLayoutSpeakerRepository;
	
	@Override
	public CourseLayoutSpeakerModel getCourseLayoutSpeakerById(Long id) {
		CourseLayoutSpeakerModel result = null;
		if (id != null) {
			CourseLayoutSpeakerEntity courseLayoutSpeakerEntity = courseLayoutSpeakerRepository.findOne(id);
			if (courseLayoutSpeakerEntity != null) {
				result = CourseLayoutSpeakerConverter.convertCourseLayoutSpeakerEntityToDTO(courseLayoutSpeakerEntity);
			}
		}
		return result;
	}

	@Override
	public CourseLayoutSpeakerModel save(CourseLayoutSpeakerModel courseLayoutSpeakerModel) {
		CourseLayoutSpeakerModel result = null;
		if (courseLayoutSpeakerModel != null) {
			CourseLayoutSpeakerEntity courseLayoutSpeakerEntity = courseLayoutSpeakerRepository.save(CourseLayoutSpeakerConverter.convertDTOToCourseLayoutSpeakerEntity(courseLayoutSpeakerModel));
			if (courseLayoutSpeakerEntity != null) {
				result = CourseLayoutSpeakerConverter.convertCourseLayoutSpeakerEntityToDTO(courseLayoutSpeakerEntity);
			}
		}
		return result;
	}

	@Override
	public CourseLayoutSpeakerModel update(CourseLayoutSpeakerModel courseLayoutSpeakerModel) {
		CourseLayoutSpeakerModel result = null;
		if (courseLayoutSpeakerModel != null) {
			CourseLayoutSpeakerEntity courseLayoutSpeakerEntity = courseLayoutSpeakerRepository.saveAndFlush(CourseLayoutSpeakerConverter.convertDTOToCourseLayoutSpeakerEntity(courseLayoutSpeakerModel));
			if (courseLayoutSpeakerEntity != null) {
				result = CourseLayoutSpeakerConverter.convertCourseLayoutSpeakerEntityToDTO(courseLayoutSpeakerEntity);
			}
		}
		return result;
	}

	@Override
	public void deleteByImageUrl(String url) {
		CourseLayoutSpeakerEntity result = null;
		if (url != null) {
			result = courseLayoutSpeakerRepository.getCourseSpeakerByImageUrl(url);
			if (result != null) {
				courseLayoutSpeakerRepository.delete(result);
			}
		}
	}

}
