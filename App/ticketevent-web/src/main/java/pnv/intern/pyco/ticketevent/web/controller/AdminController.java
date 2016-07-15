package pnv.intern.pyco.ticketevent.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pnv.intern.pyco.ticketevent.repository.entity.AccountEntity;
import pnv.intern.pyco.ticketevent.repository.entity.CommentEntity;
import pnv.intern.pyco.ticketevent.services.AccountService;
import pnv.intern.pyco.ticketevent.services.CommentService;
import pnv.intern.pyco.ticketevent.services.converter.AccountConverter;
import pnv.intern.pyco.ticketevent.services.model.AccountUserInfoModel;

@Controller
public class AdminController {
	@Autowired
	private AccountService accountService;
	@Autowired
	private CommentService commentService;
	
	@RequestMapping(value = "admin-page", method= RequestMethod.GET)
	public String displayAdminPage(ModelMap model){
		AccountEntity account = accountService.getAccountbyUserName(SecurityContextHolder.getContext().getAuthentication().getName());
		List<AccountUserInfoModel> listAllAccountUserInfo = accountService.getAllAccountUserInfo();
		if(account != null){
			AccountUserInfoModel acc = accountService.getAccInfor(account.getId());
			model.put("account", acc);
			model.put("listAllAccount", listAllAccountUserInfo);
		}
		return "admin/admin_home_page";
	}
	
	@RequestMapping(value = "user-management", method= RequestMethod.GET)
	public String UserByAdmin(ModelMap model){
		AccountEntity account = accountService.getAccountbyUserName(SecurityContextHolder.getContext().getAuthentication().getName());
		//List<AccountUserInfoModel> listAllAccountUserInfo = accountService.getAllAccountUserInfo();
		if(account != null){
			AccountUserInfoModel acc = accountService.getAccInfor(account.getId());
			Page<AccountEntity> page = accountService.getDeploymentLog(1);
		    AccountConverter converter = new AccountConverter();
		    int current = page.getNumber() + 1;
		    int begin = Math.max(1, current - 5);
		    int end = Math.min(begin + 10, page.getTotalPages());
		    List<AccountUserInfoModel> listAccount = converter.convertAllAccount(page.getContent());

		    model.put("listAllAccount", listAccount);
		    model.put("page", page);
		    model.put("beginIndex", begin);
		    model.put("endIndex", end);
		    model.put("currentIndex", current);
			model.put("account", acc);
		}
		return "admin/admin_user_manage";
	}
	
	@RequestMapping(value = "admin-comment-manage", method= RequestMethod.GET)
	public String commentAdmin(ModelMap model){
		AccountEntity account = accountService.getAccountbyUserName(SecurityContextHolder.getContext().getAuthentication().getName());
		if(account != null){
			AccountUserInfoModel acc = accountService.getAccInfor(account.getId());
			Page<CommentEntity> page = commentService.getAllCommentPaging(1);
		    int current = page.getNumber() + 1;
		    int begin = Math.max(1, current - 5);
		    int end = Math.min(begin + 10, page.getTotalPages());

		    model.put("page", page);
		    model.put("listAllComment", page.getContent());
		    model.put("beginIndex", begin);
		    model.put("endIndex", end);
		    model.put("currentIndex", current);
			model.put("account", acc);
		}
		return "admin/admin_comment_manage";
	}
	
	@RequestMapping(value = "/setAccountActive/{id}/{type}", method = RequestMethod.GET)
	public @ResponseBody String editAccount(@PathVariable("id") long id, @PathVariable("type") int type){
		accountService.setActive(id, type);
		return null;
	}
	
	
	@RequestMapping(value = "user-management/{pageNumber}", method = RequestMethod.GET)
	public String getRunbookPage(@PathVariable Integer pageNumber, Model model) {
	    Page<AccountEntity> page = accountService.getDeploymentLog(pageNumber);
	    AccountConverter converter = new AccountConverter();
	    int current = page.getNumber() + 1;
	    int begin = Math.max(1, current - 5);
	    int end = Math.min(begin + 10, page.getTotalPages());
	    List<AccountUserInfoModel> listAccount = converter.convertAllAccount(page.getContent());

	    model.addAttribute("listAllAccount", listAccount);
	    model.addAttribute("page", page);
	    model.addAttribute("beginIndex", begin);
	    model.addAttribute("endIndex", end);
	    model.addAttribute("currentIndex", current);

	    return "admin/admin_user_manage";
	}
}
