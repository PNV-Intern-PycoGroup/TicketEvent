package pnv.intern.pyco.ticketevent.services.converter;

import pnv.intern.pyco.ticketevent.repository.entity.MailConfigEntity;
import pnv.intern.pyco.ticketevent.services.model.MailConfigModel;

public class MailConfigConverter {
	public static MailConfigModel convertFromEntityToDTO(MailConfigEntity mailConfigEntity) {
		MailConfigModel mailConfigModel = null;
		if(mailConfigEntity !=null){
			mailConfigModel = new MailConfigModel();
			mailConfigModel.setId(mailConfigEntity.getId());
			mailConfigModel.setMailHost(mailConfigEntity.getMailHost());
			mailConfigModel.setUserName(mailConfigEntity.getUserName());
			mailConfigModel.setEmailPass(mailConfigEntity.getEmailPass());
			mailConfigModel.setMailPort(mailConfigEntity.getMailPort());
		}
		return mailConfigModel;
	}
	
	public static MailConfigEntity convertToEntity(MailConfigModel mailConfigModel) {
		MailConfigEntity mailConfigEntity = null;
		if(mailConfigModel !=null){
			mailConfigEntity = new MailConfigEntity();
			mailConfigEntity.setId(mailConfigModel.getId());
			mailConfigEntity.setMailHost(mailConfigModel.getMailHost());
			mailConfigEntity.setUserName(mailConfigModel.getUserName());
			mailConfigEntity.setEmailPass(mailConfigModel.getEmailPass());
			mailConfigEntity.setMailPort(mailConfigModel.getMailPort());
		}
		return mailConfigEntity;
	}
}
