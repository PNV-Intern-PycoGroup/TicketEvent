package pnv.intern.pyco.ticketevent.services.layout.free;

import pnv.intern.pyco.ticketevent.services.model.layout.free.FreeLayoutModel;

public interface FreeLayoutService {
	public FreeLayoutModel getFreeLayoutById(Long id);
	public FreeLayoutModel save(FreeLayoutModel freeLayoutModel);
	public FreeLayoutModel update(FreeLayoutModel freeLayoutModel);
	public FreeLayoutModel findFreeLayoutByEventId(Long eventId);
	public boolean isExistFreeLayoutByEventId(Long eventId, Long freeLayoutId);
}
