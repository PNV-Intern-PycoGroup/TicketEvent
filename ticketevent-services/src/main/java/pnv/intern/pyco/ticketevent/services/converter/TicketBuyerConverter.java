package pnv.intern.pyco.ticketevent.services.converter;

import java.util.ArrayList;
import java.util.List;

import pnv.intern.pyco.ticketevent.repository.entity.AccountEntity;
import pnv.intern.pyco.ticketevent.repository.entity.TicketBuyerEntity;
import pnv.intern.pyco.ticketevent.repository.entity.TicketOrderEntity;
import pnv.intern.pyco.ticketevent.services.model.AccountModel;
import pnv.intern.pyco.ticketevent.services.model.TicketBuyerModel;
import pnv.intern.pyco.ticketevent.services.model.TicketOrderModel;

public class TicketBuyerConverter {
	public static boolean IS_CONVERT;
	public static TicketBuyerModel convertFromEntityToDTO(TicketBuyerEntity ticketBuyerEntity){
		IS_CONVERT = true;
		TicketBuyerModel ticketBuyerModel = null;
		if(ticketBuyerEntity != null){
			AccountEntity accountEntity = ticketBuyerEntity.getAccount();
			
			ticketBuyerModel = new TicketBuyerModel();
			ticketBuyerModel.setId(ticketBuyerEntity.getId());
			ticketBuyerModel.setName(ticketBuyerEntity.getName());
			ticketBuyerModel.setAddress(ticketBuyerEntity.getAddress());
			ticketBuyerModel.setGender(ticketBuyerEntity.getGender());
			ticketBuyerModel.setPhone(ticketBuyerEntity.getPhone());
			ticketBuyerModel.setDateOfBirth(ticketBuyerEntity.getDateOfBirth());
			
			if(!AccountConverter.IS_CONVERT && accountEntity != null){
			ticketBuyerModel.setAccount(AccountConverter.convertAccountEntityToAccountModel(accountEntity));
			}
			
			List<TicketOrderEntity> listTicketOrderEntity = ticketBuyerEntity.getListTicketOrder();
			if (!TicketOrderConverter.IS_CONVERT && listTicketOrderEntity != null) {
				List<TicketOrderModel> listTicketOrderModel = new ArrayList<TicketOrderModel>();
				for (TicketOrderEntity ticketOrderEntity : listTicketOrderEntity) {
					listTicketOrderModel.add(TicketOrderConverter.convertTicketOrderEntityToDTO(ticketOrderEntity));
				}
				
				ticketBuyerModel.setListTicketOrder(listTicketOrderModel);
			}
		}
		IS_CONVERT = false;
		return ticketBuyerModel;
	}
	
	public static TicketBuyerEntity convertFromDTOToEntity(TicketBuyerModel ticketBuyerModel){
		IS_CONVERT = true;
		TicketBuyerEntity ticketBuyerEntity = null;
		if(ticketBuyerModel != null){
			AccountModel accountModel = ticketBuyerModel.getAccount();
			
			ticketBuyerEntity = new TicketBuyerEntity();
			ticketBuyerEntity.setId(ticketBuyerModel.getId());
			ticketBuyerEntity.setName(ticketBuyerModel.getName());
			ticketBuyerEntity.setAddress(ticketBuyerModel.getAddress());
			ticketBuyerEntity.setGender(ticketBuyerModel.getGender());
			ticketBuyerEntity.setPhone(ticketBuyerModel.getPhone());
			ticketBuyerEntity.setDateOfBirth(ticketBuyerModel.getDateOfBirth());
			
			if(!AccountConverter.IS_CONVERT && accountModel != null){
			ticketBuyerEntity.setAccount(AccountConverter.convertDTOToAccountEntity(accountModel));
			}
			
			List<TicketOrderModel> listTicketOrderModel = ticketBuyerModel.getListTicketOrder();
			if (!TicketOrderConverter.IS_CONVERT && listTicketOrderModel != null) {
				List<TicketOrderEntity> listTicketOrderEntity = new ArrayList<TicketOrderEntity>();
				for (TicketOrderModel ticketOrderModel : listTicketOrderModel) {
					listTicketOrderEntity.add(TicketOrderConverter.convertDTOToTicketOrderEntity(ticketOrderModel));
				}
				
				ticketBuyerEntity.setListTicketOrder(listTicketOrderEntity);
			}
		}
		IS_CONVERT = false;
		return ticketBuyerEntity;
	}
}
