package pnv.intern.pyco.ticketevent.services.layout.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pnv.intern.pyco.ticketevent.repository.entity.layout.course.CourseLayoutEntity;
import pnv.intern.pyco.ticketevent.repository.layout.course.CourseLayoutRepository;
import pnv.intern.pyco.ticketevent.services.converter.layout.course.CourseLayoutConverter;
import pnv.intern.pyco.ticketevent.services.model.layout.course.CourseLayoutModel;

@Service
public class CourseLayoutServiceImpl implements CourseLayoutService {

	@Autowired
	private CourseLayoutRepository courseLayoutRepository;
	
	@Override
	public CourseLayoutModel getCourseLayoutById(Long id) {
		CourseLayoutModel courseLayoutModel = null;
		CourseLayoutEntity courseLayoutEntity = courseLayoutRepository.findOne(id);
		if (courseLayoutEntity != null) {
			courseLayoutModel = CourseLayoutConverter.convertCourseLayoutEntityToDTO(courseLayoutEntity);
		}
		return courseLayoutModel;
	}

	@Override
	public CourseLayoutModel save(CourseLayoutModel courseLayoutModel) {
		CourseLayoutModel result = null;
		if (courseLayoutModel != null) {
			CourseLayoutEntity courseLayoutEntity = courseLayoutRepository.save(CourseLayoutConverter.convertDTOToCourseLayoutEntity(courseLayoutModel));
			if (courseLayoutEntity != null) {
				result = CourseLayoutConverter.convertCourseLayoutEntityToDTO(courseLayoutEntity);
			}
		}
		return result;
	}

	@Override
	public CourseLayoutModel findCourseLayoutByEventId(Long eventId) {
		CourseLayoutModel result = null;
		if (eventId != null) {
			CourseLayoutEntity courseLayoutEntity = courseLayoutRepository.findCourseLayoutByEventId(eventId);
			if (courseLayoutEntity != null) {
				result = CourseLayoutConverter.convertCourseLayoutEntityToDTO(courseLayoutEntity);
			}
		}
		return result;
	}

	@Override
	public CourseLayoutModel update(CourseLayoutModel courseLayoutModel) {
		CourseLayoutModel result = null;
		if (courseLayoutModel != null) {
			CourseLayoutEntity courseLayoutEntity = courseLayoutRepository.saveAndFlush(CourseLayoutConverter.convertDTOToCourseLayoutEntity(courseLayoutModel));
			if (courseLayoutEntity != null) {
				result = CourseLayoutConverter.convertCourseLayoutEntityToDTO(courseLayoutEntity);
			}
		}
		return result;
	}

	@Override
	public boolean isExistCourseLayoutByEventId(Long eventId, Long courseLayoutId) {
		CourseLayoutEntity result = null;
		if (eventId != null && courseLayoutId != null) {
			result = courseLayoutRepository.findCourseLayoutByEventIdAndCourseLayoutId(eventId, courseLayoutId);
		}
		return result != null;
	}

}
