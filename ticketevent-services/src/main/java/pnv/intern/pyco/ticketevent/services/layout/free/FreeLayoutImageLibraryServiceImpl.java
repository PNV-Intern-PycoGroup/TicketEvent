package pnv.intern.pyco.ticketevent.services.layout.free;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pnv.intern.pyco.ticketevent.repository.entity.layout.free.FreeLayoutImageLibraryEntity;
import pnv.intern.pyco.ticketevent.repository.layout.free.FreeLayoutImageLibraryRepository;
import pnv.intern.pyco.ticketevent.services.converter.layout.free.FreeLayoutImageLibraryConverter;
import pnv.intern.pyco.ticketevent.services.model.layout.free.FreeLayoutImageLibraryModel;

@Service
public class FreeLayoutImageLibraryServiceImpl implements FreeLayoutImageLibraryService {

	@Autowired
	private FreeLayoutImageLibraryRepository freeLayoutImageLibraryRepository;
	
	@Override
	public FreeLayoutImageLibraryModel getFreeLayoutImageLibraryById(Long id) {
		FreeLayoutImageLibraryModel freeLayoutImageLibraryModel = null;
		if (id != null) {
			FreeLayoutImageLibraryEntity freeLayoutImageLibraryEntity = freeLayoutImageLibraryRepository.findOne(id);
			if (freeLayoutImageLibraryEntity != null) {
				freeLayoutImageLibraryModel = FreeLayoutImageLibraryConverter.convertFreeLayoutImageLibraryEntityToDTO(freeLayoutImageLibraryEntity);
			}
		}
		return freeLayoutImageLibraryModel;
	}

	@Override
	public FreeLayoutImageLibraryModel save(FreeLayoutImageLibraryModel freeLayoutImageLibraryModel) {
		if (freeLayoutImageLibraryModel != null) {
			FreeLayoutImageLibraryEntity freeLayoutImageLibraryEntity = freeLayoutImageLibraryRepository.save(FreeLayoutImageLibraryConverter.convertDTOToFreeLayoutImageLibraryEntity(freeLayoutImageLibraryModel));
			if (freeLayoutImageLibraryEntity != null) {
				freeLayoutImageLibraryModel = FreeLayoutImageLibraryConverter.convertFreeLayoutImageLibraryEntityToDTO(freeLayoutImageLibraryEntity);
			}
		}
		return freeLayoutImageLibraryModel;
	}

	@Override
	public void deleteByUrl(String url) {
		FreeLayoutImageLibraryEntity freeLayoutImageLibraryEntity = freeLayoutImageLibraryRepository.getFreeImageLibraryByUrl(url);
		if (freeLayoutImageLibraryEntity != null) {
			freeLayoutImageLibraryRepository.delete(freeLayoutImageLibraryEntity);
		}
	}

}
