package pnv.intern.pyco.ticketevent.services.converter.layout.free;

import java.util.HashSet;
import java.util.Set;

import pnv.intern.pyco.ticketevent.repository.entity.layout.free.FreeLayoutEntity;
import pnv.intern.pyco.ticketevent.repository.entity.layout.free.FreeLayoutImageLibraryEntity;
import pnv.intern.pyco.ticketevent.services.model.layout.free.FreeLayoutImageLibraryModel;
import pnv.intern.pyco.ticketevent.services.model.layout.free.FreeLayoutModel;

public class FreeLayoutConverter {
	public static boolean IS_CONVERT;

	public FreeLayoutConverter() {
		
	}

	public static FreeLayoutModel convertFreeLayoutEntityToDTO(FreeLayoutEntity freeLayoutEntity) {
		IS_CONVERT = true;
		
		FreeLayoutModel freeLayoutModel = new FreeLayoutModel();
		freeLayoutModel.setId(freeLayoutEntity.getId());
		freeLayoutModel.setEventId(freeLayoutEntity.getEventId());
		freeLayoutModel.setContent(freeLayoutEntity.getContent());

		Set<FreeLayoutImageLibraryEntity> listFreeLayoutImageLibraryEntity = freeLayoutEntity.getListFreeLayoutImageLibrary();
		if (!FreeLayoutImageLibraryConverter.IS_CONVERT && listFreeLayoutImageLibraryEntity != null) {
			Set<FreeLayoutImageLibraryModel> listFreeLayoutImageLibraryModel = new HashSet<FreeLayoutImageLibraryModel>();
			for (FreeLayoutImageLibraryEntity freeLayoutImageLibraryEntity : listFreeLayoutImageLibraryEntity) {
				listFreeLayoutImageLibraryModel.add(FreeLayoutImageLibraryConverter.convertFreeLayoutImageLibraryEntityToDTO(freeLayoutImageLibraryEntity));
			}
			freeLayoutModel.setListFreeLayoutImageLibrary(listFreeLayoutImageLibraryModel);
		}
		
		IS_CONVERT = false;
		return freeLayoutModel;
	}

	public static FreeLayoutEntity convertDTOToFreeLayoutEntity(FreeLayoutModel freeLayoutModel) {
		IS_CONVERT = true;
		
		FreeLayoutEntity freeLayoutEntity = new FreeLayoutEntity();
		freeLayoutEntity.setId(freeLayoutModel.getId());
		freeLayoutEntity.setEventId(freeLayoutModel.getEventId());
		freeLayoutEntity.setContent(freeLayoutModel.getContent());

		Set<FreeLayoutImageLibraryModel> listFreeLayoutImageLibraryModel = freeLayoutModel.getListFreeLayoutImageLibrary();
		if (!FreeLayoutImageLibraryConverter.IS_CONVERT && listFreeLayoutImageLibraryModel != null) {
			Set<FreeLayoutImageLibraryEntity> listFreeLayoutImageLibraryEntity = new HashSet<FreeLayoutImageLibraryEntity>();
			for (FreeLayoutImageLibraryModel freeLayoutImageLibraryModel : listFreeLayoutImageLibraryModel) {
				listFreeLayoutImageLibraryEntity.add(FreeLayoutImageLibraryConverter.convertDTOToFreeLayoutImageLibraryEntity(freeLayoutImageLibraryModel));
			}
			freeLayoutEntity.setListFreeLayoutImageLibrary(listFreeLayoutImageLibraryEntity);
		}
		
		IS_CONVERT = false;
		return freeLayoutEntity;
	}
}
