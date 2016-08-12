package pnv.intern.pyco.ticketevent.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pnv.intern.pyco.ticketevent.services.AccountService;
import pnv.intern.pyco.ticketevent.services.CommentService;
import pnv.intern.pyco.ticketevent.services.model.AccountModel;
import pnv.intern.pyco.ticketevent.services.model.CommentModel;

@Controller
public class AdminCommentController {
	@Autowired
	private CommentService commentService;
	@Autowired
	private AccountService accountService;
	private AccountModel account;
	
	@RequestMapping(value = "admin/comments", method= RequestMethod.GET)
	public String commentAdmin(ModelMap model){
		account = accountService.getAccountModelByAuthencated();
		if(account != null){
		    List<CommentModel> commentModels = commentService.getAllComment();
		    model.put("listAllComment", commentModels);
			model.put("account", account);
		}
		return "admin/comment_management";
	}
	
	@RequestMapping(value = "admin/deleteComments", method = RequestMethod.POST)
	public @ResponseBody String deleteComments(@RequestBody Long[] listCommentID){
		
		for(Long id : listCommentID){
			commentService.deleteCommentByID(id);
		}
		return null;
	}
	
	@RequestMapping(value = "admin/deleteComment", method = RequestMethod.POST)
	public @ResponseBody String deleteComments(@RequestBody Long commentId){
		CommentModel commentModel = commentService.getCommentById(commentId);
		if(commentModel != null){
			commentService.deleteComment(commentModel);
		}
		return null;
	}
}
