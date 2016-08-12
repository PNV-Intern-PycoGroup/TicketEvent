package pnv.intern.pyco.ticketevent.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pnv.intern.pyco.ticketevent.repository.TicketBuyerRepository;
import pnv.intern.pyco.ticketevent.repository.entity.TicketBuyerEntity;
import pnv.intern.pyco.ticketevent.services.converter.TicketBuyerConverter;
import pnv.intern.pyco.ticketevent.services.model.EventModel;
import pnv.intern.pyco.ticketevent.services.model.TicketBuyerModel;
import pnv.intern.pyco.ticketevent.services.model.TicketModel;
import pnv.intern.pyco.ticketevent.services.model.TicketOrderModel;

@Service
public class TicketBuyerServiceImpl implements TicketBuyerService{

	@Autowired
	private TicketBuyerRepository ticketBuyerRepository;
	
	@Override
	public List<TicketOrderModel> getTicketListByEvent(EventModel eventModel) {
		List<TicketOrderModel> ticketOrderModels = null;
		if(eventModel != null){
			List<TicketModel> ticketModels = eventModel.getListTicket();
			if(ticketModels != null){
				ticketOrderModels = new ArrayList<>();
				for(TicketModel ticketModel : ticketModels){
					List<TicketOrderModel> orderModels = ticketModel.getListTicketOrder();
					for(TicketOrderModel model : orderModels){
						model.setTicket(ticketModel);
					}
					ticketOrderModels.addAll(orderModels);
				}
			}
		}
		return ticketOrderModels;
	}

	@Override
	public TicketBuyerModel save(TicketBuyerModel ticketBuyer) {
		TicketBuyerModel result = null;
		if (ticketBuyer != null) {
			TicketBuyerEntity ticketBuyerEntity = ticketBuyerRepository.save(TicketBuyerConverter.convertFromDTOToEntity(ticketBuyer));
			if (ticketBuyerEntity != null) {
				result = TicketBuyerConverter.convertFromEntityToDTO(ticketBuyerEntity);
			}
		}
		return result;
	}

	@Override
	public List<TicketBuyerModel> getTicketListByAccountId(Long accountId) {
		List<TicketBuyerModel> ticketBuyerModels = null;
		if(accountId != null){
			ticketBuyerModels = new ArrayList<TicketBuyerModel>();
			List<TicketBuyerEntity> ticketBuyerEntities = ticketBuyerRepository.getListTicketBuyerByAccount(accountId);
			for (TicketBuyerEntity ticketBuyerEntity : ticketBuyerEntities) {
				ticketBuyerModels.add(TicketBuyerConverter.convertFromEntityToDTO(ticketBuyerEntity));
			}
		}
		return ticketBuyerModels;
	}

	@Override
	public TicketBuyerModel getTicketListById(Long id) {
		TicketBuyerModel result = null;
		if (id != null) {
			TicketBuyerEntity ticketBuyerEntity = ticketBuyerRepository.getOne(id);
			if (ticketBuyerEntity != null) {
				result = TicketBuyerConverter.convertFromEntityToDTO(ticketBuyerEntity);
			}
		}
		return result;
	}

}
