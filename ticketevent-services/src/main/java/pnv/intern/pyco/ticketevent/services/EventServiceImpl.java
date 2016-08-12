package pnv.intern.pyco.ticketevent.services;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import pnv.intern.pyco.ticketevent.repository.EventRepository;
import pnv.intern.pyco.ticketevent.repository.entity.AccountEntity;
import pnv.intern.pyco.ticketevent.repository.entity.EventEntity;
import pnv.intern.pyco.ticketevent.services.converter.EventConverter;
import pnv.intern.pyco.ticketevent.services.model.AccountModel;
import pnv.intern.pyco.ticketevent.services.model.EventModel;

@Service
public class EventServiceImpl implements EventService {
	private static final int LASTEST_EVENT_SIZE = 8;
	@Autowired
	private EventRepository eventRespository;
	@Autowired
	private AccountService accountService;

	@Override
	public EventModel getEventById(Long id) {
		EventEntity eventEntity = eventRespository.findOne(id);
		EventModel eventModel = null;

		if (eventEntity != null) {
			eventModel = EventConverter.convertEventEntityToEventModel(eventEntity);
		}
		return eventModel;
	}

	@Override
	public EventModel saveEvent(EventModel event) {
		EventModel eventModel = null;
		if (event != null) {
			EventEntity eventEntity = eventRespository.save(EventConverter.convertEventModelToEventEntity(event));
			if (eventEntity != null) {
				eventModel = EventConverter.convertEventEntityToEventModel(eventEntity);
			}
		}
		return eventModel;
	}

	@Override
	public EventModel updateEvent(EventModel event) {
		EventModel eventModel = null;
		if (event != null) {
			EventEntity eventEntity = eventRespository
					.saveAndFlush(EventConverter.convertEventModelToEventEntity(event));
			if (eventEntity != null) {
				eventModel = EventConverter.convertEventEntityToEventModel(eventEntity);
			}
		}
		return eventModel;
	}

	@Override
	public void deleteEvent(EventModel event) {
		EventEntity eventEntity = EventConverter.convertEventModelToEventEntity(event);
		if (eventEntity != null) {
			eventRespository.delete(eventEntity);
		}

	}

	@Override
	public boolean isExitEvent(Long eventId, Long accountId) {
		return eventRespository.checkExistEventByAccount(eventId, accountId) != null;
	}

	@Override
	public List<EventModel> getAllEvent() {
		List<EventModel> eventModels = null;
		List<EventEntity> eventEntities = eventRespository.getAllEvent();
		if (eventEntities != null) {
			eventModels = new ArrayList<>();
			for (EventEntity eventEntity : eventEntities) {
				eventModels.add(EventConverter.convertEventEntityToEventModel(eventEntity));
			}
		}
		return eventModels;
	}

	@Override
	public List<EventModel> getLastestEvent() {
		List<EventModel> eventModels = null;
		PageRequest request = new PageRequest(0, LASTEST_EVENT_SIZE, Sort.Direction.DESC, "createDate");
		Page<EventEntity> ePage = eventRespository.getLastestEvent(request);
		List<EventEntity> eventEntities = ePage.getContent();
		if (eventEntities != null) {
			eventModels = new ArrayList<>();
			for (EventEntity eventEntity : eventEntities) {
				eventModels.add(EventConverter.convertEventEntityToEventModel(eventEntity));
			}
		}
		return eventModels;
	}

	@Override
	public void deleteEventNotAccept(EventModel eventModel) {
		if (eventModel != null) {
			eventRespository.deleteEventNotAcceptById(eventModel.getId());
		}
	}

	@Override
	public void acceptEvent(EventModel eventModel) {
		EventEntity eventEntity = EventConverter.convertEventModelToEventEntity(eventModel);
		if (eventEntity != null) {
			eventEntity.setIsAccept(1);
			eventRespository.saveAndFlush(eventEntity);
		}
	}

	public List<EventModel> getTotalEventOfYear(int year) {
		List<EventModel> eventModels = null;
		List<EventEntity> eventEntities = eventRespository.getTotalEventOfYear(year);
		if (eventEntities != null) {
			eventModels = new ArrayList<>();
			for (EventEntity eventEntity : eventEntities) {
				eventModels.add(EventConverter.convertEventEntityToEventModel(eventEntity));
			}
		}
		return eventModels;
	}

	@Override
	public Object[] getTotal(int year) {
		return eventRespository.getTotal(year);
	}

	@Override
	public Object[] getYears() {
		return eventRespository.getYearActive();
	}

	@Override
	public Object[] getTotalByDateOfEvent(int eventId) {
		return eventRespository.getTotalByDateOfEvent(eventId);
	}

	@Override
	public Integer counterEventByYear(int year) {
		int counter = getTotalEventOfYear(year).size();
		return counter;
	}

	@Override
	public List<EventModel> getEventsByUser() {
		List<EventModel> liEventModels = null;
		AccountModel accountModel = accountService.getAccountModelByAuthencated();
		if (accountModel != null) {
			AccountEntity accountEntity = accountService.getAccountEntityByID(accountModel.getId());
			List<EventEntity> eventEntities = accountEntity.getListEvent();
			if (eventEntities != null) {
				liEventModels = new ArrayList<>();
				for (EventEntity eventEntity : eventEntities) {
					liEventModels.add(EventConverter.convertEventEntityToEventModel(eventEntity));
				}
			}
		}
		return liEventModels;
	}

	@Override
	public List<EventModel> getEventPassedByUser() {
		List<EventModel> lEventModels = null;
		AccountModel accountModel = accountService.getAccountModelByAuthencated();
		if (accountModel != null) {
			List<EventEntity> eventEntities = eventRespository.getEventPassedByUser(accountModel.getId());
			if (eventEntities != null) {
				lEventModels = new ArrayList<>();
				for (EventEntity eventEntity : eventEntities) {
					lEventModels.add(EventConverter.convertEventEntityToEventModel(eventEntity));
				}
			}
		}
		return lEventModels;
	}

	@Override
	public List<EventModel> getEventNotAcceptByUser() {
		List<EventModel> lEventModels = null;
		AccountModel accountModel = accountService.getAccountModelByAuthencated();
		if (accountModel != null) {
			List<EventEntity> eventEntities = eventRespository.getEventNotAcceptByUser(accountModel.getId());
			if (eventEntities != null) {
				lEventModels = new ArrayList<>();
				for (EventEntity eventEntity : eventEntities) {
					lEventModels.add(EventConverter.convertEventEntityToEventModel(eventEntity));
				}
			}
		}
		return lEventModels;
	}

	@Override
	public EventModel getEventByPath(String path) {
		EventModel eventModel = null;
		if (path != null) {
			EventEntity eventEntity = eventRespository.getEventByPath(path);
			if (eventEntity != null) {
				eventModel = EventConverter.convertEventEntityToEventModel(eventEntity);
			}
		}
		return eventModel;
	}

	@Override
	public List<EventModel> getEventSlide(int eventNumbers) {
		List<EventModel> result = null;
		List<EventEntity> temp = eventRespository.getListEventSlide(eventNumbers);
		if (temp != null) {
			result = new ArrayList<EventModel>();
			for (EventEntity eventEntity : temp) {
				result.add(EventConverter.convertEventEntityToEventModel(eventEntity));
			}
		}
		return result;
	}

	@Override
	public List<EventModel> getAllEventIsAccept() {
		List<EventModel> eventModels = null;
		List<EventEntity> eventEntities = eventRespository.getListEventisAccept();
		if (eventEntities != null) {
			eventModels = new ArrayList<>();
			for (EventEntity eventEntity : eventEntities) {
				if (eventEntity.getEndDate().after(Calendar.getInstance().getTime())) {
					eventModels.add(EventConverter.convertEventEntityToEventModel(eventEntity));
				}
			}
		}
		return eventModels;
	}
}
