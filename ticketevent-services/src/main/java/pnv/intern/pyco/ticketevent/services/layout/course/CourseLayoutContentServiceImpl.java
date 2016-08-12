package pnv.intern.pyco.ticketevent.services.layout.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pnv.intern.pyco.ticketevent.repository.entity.layout.course.CourseLayoutContentEntity;
import pnv.intern.pyco.ticketevent.repository.layout.course.CourseLayoutContentRepository;
import pnv.intern.pyco.ticketevent.services.converter.layout.course.CourseLayoutContentConverter;
import pnv.intern.pyco.ticketevent.services.model.layout.course.CourseLayoutContentModel;

@Service
public class CourseLayoutContentServiceImpl implements CourseLayoutContentService {

	@Autowired
	private CourseLayoutContentRepository courseLayoutContentRepository;

	@Override
	public CourseLayoutContentModel getCourseLayoutContentById(Long id) {
		CourseLayoutContentModel courseLayoutContentModel = null;
		if (id != null) {
			CourseLayoutContentEntity courseLayoutContentEntity = courseLayoutContentRepository.findOne(id);
			if (courseLayoutContentEntity != null) {
				courseLayoutContentModel = CourseLayoutContentConverter.convertCourseLayoutContentEntityToDTO(courseLayoutContentEntity);
			}
		}
		return courseLayoutContentModel;
	}

	@Override
	public CourseLayoutContentModel save(CourseLayoutContentModel courseLayoutContentModel) {
		CourseLayoutContentModel result = null;
		if (courseLayoutContentModel != null) {
			CourseLayoutContentEntity courseLayoutContentEntity = courseLayoutContentRepository.save(CourseLayoutContentConverter.convertDTOToCourseLayoutContentEntity(courseLayoutContentModel));
			if (courseLayoutContentEntity != null) {
				result = CourseLayoutContentConverter.convertCourseLayoutContentEntityToDTO(courseLayoutContentEntity);
			}
		}
		return result;
	}

	@Override
	public CourseLayoutContentModel update(CourseLayoutContentModel courseLayoutContentModel) {
		CourseLayoutContentModel result = null;
		if (courseLayoutContentModel != null) {
			CourseLayoutContentEntity courseLayoutContentEntity = courseLayoutContentRepository.saveAndFlush(CourseLayoutContentConverter.convertDTOToCourseLayoutContentEntity(courseLayoutContentModel));
			if (courseLayoutContentEntity != null) {
				result = CourseLayoutContentConverter.convertCourseLayoutContentEntityToDTO(courseLayoutContentEntity);
			}
		}
		return result;
	}

	@Override
	public void deleteById(Long id) {
		if (id != null) {
			courseLayoutContentRepository.delete(id);
		}
	}
	
}
