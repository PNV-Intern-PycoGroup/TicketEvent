package pnv.intern.pyco.ticketevent.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pnv.intern.pyco.ticketevent.repository.TicketRepository;
import pnv.intern.pyco.ticketevent.repository.entity.TicketEntity;
import pnv.intern.pyco.ticketevent.services.converter.TicketConverter;
import pnv.intern.pyco.ticketevent.services.model.TicketModel;

@Service
public class TicketServiceImpl implements TicketService {

	@Autowired
	private TicketRepository ticketRepository;
	
	@Override
	public TicketModel getTicketById(Long id) {
		TicketModel result = null;
		if (id != null) {
			TicketEntity ticketEntity = ticketRepository.findOne(id);
			if (ticketEntity != null) {
				result = TicketConverter.convertTicketEntityToTicketModel(ticketEntity);
			}
		}
		return result;
	}

	@Override
	public TicketModel save(TicketModel ticketModel) {
		TicketModel result = null;
		if (ticketModel != null) {
			TicketEntity ticketEntity = ticketRepository.save(TicketConverter.convertTicketModelToTicketEntity(ticketModel));
			if (ticketEntity != null) {
				result = TicketConverter.convertTicketEntityToTicketModel(ticketEntity);
			}
		}
		return result;
	}

	@Override
	public TicketModel update(TicketModel ticketModel) {
		TicketModel result = null;
		if (ticketModel != null) {
			TicketEntity ticketEntity = ticketRepository.saveAndFlush(TicketConverter.convertTicketModelToTicketEntity(ticketModel));
			if (ticketEntity != null) {
				result = TicketConverter.convertTicketEntityToTicketModel(ticketEntity);
			}
		}
		return result;
	}

	@Override
	public List<TicketModel> getAll() {
		List<TicketModel> result = null;
		List<TicketEntity> listTicketEntity = ticketRepository.findAll();
		if (listTicketEntity != null) {
			result = new ArrayList<TicketModel>();
			for (TicketEntity ticketEntity : listTicketEntity) {
				if (ticketEntity != null) {
					result.add(TicketConverter.convertTicketEntityToTicketModel(ticketEntity));
				}
			}
		}
		return result;
	}

	@Override
	public void delete(TicketModel ticketModel) {
		if (ticketModel != null) {
			TicketEntity ticketEntity = TicketConverter.convertTicketModelToTicketEntity(ticketModel);
			ticketRepository.delete(ticketEntity);
		}
	}

	@Override
	public void deleteTicketsByEventId(long eventId) {
		ticketRepository.deleteTickets(eventId);
	}


}
