package swing.sys.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import swing.sys.user.model.User;
import swing.sys.user.service.UserService;


@Controller
@Scope(value="prototype")
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/save.html")
	public String save (User user){
		userService.save(user);
		return "success";
	}
	
	@RequestMapping(value="/registUI.html")
	public String registUI (){
		return "regist";
	}
}
