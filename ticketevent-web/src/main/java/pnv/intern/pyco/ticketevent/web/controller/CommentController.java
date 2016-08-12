package pnv.intern.pyco.ticketevent.web.controller;

import java.io.IOException;
import java.util.Calendar;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pnv.intern.pyco.ticketevent.services.AccountService;
import pnv.intern.pyco.ticketevent.services.CommentService;
import pnv.intern.pyco.ticketevent.services.EventService;
import pnv.intern.pyco.ticketevent.services.model.AccountModel;
import pnv.intern.pyco.ticketevent.services.model.CommentModel;
import pnv.intern.pyco.ticketevent.services.model.EventModel;
import pnv.intern.pyco.ticketevent.services.model.UserInformationModel;
import pnv.intern.pyco.ticketevent.web.clientdatacontext.AddCommentContext;

@Controller
public class CommentController {

	@Autowired
	private AccountService accountService;

	@Autowired
	private CommentService commentService;
	
	@Autowired
	private EventService eventService;
	
	@ResponseBody
	@RequestMapping(value = "/add-comment", method = RequestMethod.POST, produces={"application/json; charset=UTF-8"})
	public String createComment(@RequestBody CommentModel comment){
		AccountModel accountLogin = accountService.getAccountModelByAuthencated();
		if (accountLogin == null) {
			return "loginError";
		}
		if (isNullDataSendComment(comment)) {
			return "sendDataError";
		}
		EventModel commentEvent = eventService.getEventById(comment.getEvent().getId());
		if (commentEvent == null) {
			return "sendDataError";
		}
		comment.setEvent(commentEvent);
		comment.setAccount(accountLogin);
		comment.setCommentDate(Calendar.getInstance().getTime());
		CommentModel commentGetFromData = commentService.save(comment);
		commentGetFromData.setAccount(accountLogin);
		String result = convertCommentToJson(commentGetFromData);
		return result;
	}
	
	private String convertCommentToJson(CommentModel comment) {
		AddCommentContext objectResult = new AddCommentContext();
		AccountModel account = comment.getAccount();
		UserInformationModel userInfo = account.getUserInfor();
		if (userInfo != null && userInfo.getAvatar() != null) {
			objectResult.setAvatar(userInfo.getAvatar());
		}
		if (userInfo != null && userInfo.getName() != null) {
			objectResult.setNameUserInfo(userInfo.getName());
		}
		objectResult.setUserName(account.getUserName());
		objectResult.setUserId(account.getId());
		objectResult.setCommentDate(comment.getCommentDate());
		objectResult.setContent(comment.getContent());
		
		ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String result = "convertJsonError";
		try {
			result = objectWriter.writeValueAsString(objectResult);
		} catch (IOException e) {
		}
		return result;
	}
	
	private boolean isNullDataSendComment(CommentModel comment) {
		boolean result = comment == null || comment.getEvent() == null
				|| comment.getEvent().getId() == null || comment.getContent() == null;
		return result;
	}
}
