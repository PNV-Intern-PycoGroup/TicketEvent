package pnv.intern.pyco.ticketevent.services.layout.free;

import pnv.intern.pyco.ticketevent.services.model.layout.free.FreeLayoutImageLibraryModel;

public interface FreeLayoutImageLibraryService {
	public FreeLayoutImageLibraryModel getFreeLayoutImageLibraryById(Long id);
	public FreeLayoutImageLibraryModel save(FreeLayoutImageLibraryModel freeLayoutImageLibraryModel);
	public void deleteByUrl(String url);
}
