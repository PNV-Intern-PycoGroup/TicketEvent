package pnv.intern.pyco.ticketevent.services.layout.free;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pnv.intern.pyco.ticketevent.repository.entity.layout.free.FreeLayoutEntity;
import pnv.intern.pyco.ticketevent.repository.layout.free.FreeLayoutRepository;
import pnv.intern.pyco.ticketevent.services.converter.layout.free.FreeLayoutConverter;
import pnv.intern.pyco.ticketevent.services.model.layout.free.FreeLayoutModel;

@Service
public class FreeLayoutServiceImpl implements FreeLayoutService {

	@Autowired
	private FreeLayoutRepository freeLayoutRepository;
	
	@Override
	public FreeLayoutModel getFreeLayoutById(Long id) {
		FreeLayoutModel freeLayoutModel = null;
		FreeLayoutEntity freeLayoutEntity = freeLayoutRepository.findOne(id);
		if (freeLayoutEntity != null) {
			freeLayoutModel = FreeLayoutConverter.convertFreeLayoutEntityToDTO(freeLayoutEntity);
		}
		return freeLayoutModel;
	}

	@Override
	public FreeLayoutModel save(FreeLayoutModel freeLayoutModel) {
		FreeLayoutModel result = null;
		if (freeLayoutModel != null) {
			FreeLayoutEntity freeLayoutEntity = freeLayoutRepository.save(FreeLayoutConverter.convertDTOToFreeLayoutEntity(freeLayoutModel));
			if (freeLayoutEntity != null) {
				result = FreeLayoutConverter.convertFreeLayoutEntityToDTO(freeLayoutEntity);
			}
		}
		return result;
	}

	@Override
	public FreeLayoutModel findFreeLayoutByEventId(Long eventId) {
		FreeLayoutModel result = null;
		if (eventId != null) {
			FreeLayoutEntity freeLayoutEntity = freeLayoutRepository.findFreeLayoutByEventId(eventId);
			if (freeLayoutEntity != null) {
				result = FreeLayoutConverter.convertFreeLayoutEntityToDTO(freeLayoutEntity);
			}
		}
		return result;
	}

	@Override
	public boolean isExistFreeLayoutByEventId(Long eventId, Long freeLayoutId) {
		FreeLayoutEntity result = null;
		if (eventId != null && freeLayoutId != null) {
			result = freeLayoutRepository.findFreeLayoutByEventIdAndFreeLayoutId(eventId, freeLayoutId);
		}
		return result != null;
	}

	@Override
	public FreeLayoutModel update(FreeLayoutModel freeLayoutModel) {
		FreeLayoutModel result = null;
		if (freeLayoutModel != null) {
			FreeLayoutEntity freeLayoutEntity = freeLayoutRepository.saveAndFlush(FreeLayoutConverter.convertDTOToFreeLayoutEntity(freeLayoutModel));
			if (freeLayoutEntity != null) {
				result = FreeLayoutConverter.convertFreeLayoutEntityToDTO(freeLayoutEntity);
			}
		}
		return result;
	}

}
