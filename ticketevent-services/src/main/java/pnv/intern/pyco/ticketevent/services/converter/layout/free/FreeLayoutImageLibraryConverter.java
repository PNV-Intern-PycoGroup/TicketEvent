package pnv.intern.pyco.ticketevent.services.converter.layout.free;

import pnv.intern.pyco.ticketevent.repository.entity.layout.free.FreeLayoutEntity;
import pnv.intern.pyco.ticketevent.repository.entity.layout.free.FreeLayoutImageLibraryEntity;
import pnv.intern.pyco.ticketevent.services.model.layout.free.FreeLayoutImageLibraryModel;
import pnv.intern.pyco.ticketevent.services.model.layout.free.FreeLayoutModel;

public class FreeLayoutImageLibraryConverter {
	public static boolean IS_CONVERT;

	public FreeLayoutImageLibraryConverter() {
	}

	public static FreeLayoutImageLibraryModel convertFreeLayoutImageLibraryEntityToDTO(FreeLayoutImageLibraryEntity freeLayoutImageLibraryEntity) {
		IS_CONVERT = true;
		
		FreeLayoutImageLibraryModel freeLayoutImageLibraryModel = new FreeLayoutImageLibraryModel();
		freeLayoutImageLibraryModel.setId(freeLayoutImageLibraryEntity.getId());
		freeLayoutImageLibraryModel.setImage(freeLayoutImageLibraryEntity.getImage());
		
		FreeLayoutEntity freeLayoutEntity = freeLayoutImageLibraryEntity.getFreeLayout();
		if (!FreeLayoutConverter.IS_CONVERT && freeLayoutEntity != null) {
			freeLayoutImageLibraryModel.setFreeLayout(FreeLayoutConverter.convertFreeLayoutEntityToDTO(freeLayoutEntity));
		}
		
		IS_CONVERT = false;
		return freeLayoutImageLibraryModel;
	}
	
	public static FreeLayoutImageLibraryEntity convertDTOToFreeLayoutImageLibraryEntity(FreeLayoutImageLibraryModel freeLayoutImageLibraryModel) {
		IS_CONVERT = true;
		
		FreeLayoutImageLibraryEntity freeLayoutImageLibraryEntity = new FreeLayoutImageLibraryEntity();
		freeLayoutImageLibraryEntity.setId(freeLayoutImageLibraryModel.getId());
		freeLayoutImageLibraryEntity.setImage(freeLayoutImageLibraryModel.getImage());
		
		FreeLayoutModel freeLayoutModel = freeLayoutImageLibraryModel.getFreeLayout();
		if (!FreeLayoutConverter.IS_CONVERT && freeLayoutModel != null) {
			freeLayoutImageLibraryEntity.setFreeLayout(FreeLayoutConverter.convertDTOToFreeLayoutEntity(freeLayoutModel));
		}
		
		IS_CONVERT = false;
		return freeLayoutImageLibraryEntity;
	}
}
