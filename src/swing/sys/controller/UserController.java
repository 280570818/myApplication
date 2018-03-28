package swing.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import swing.sys.model.User;
import swing.sys.service.UserService;

@Controller
@Scope(value="prototype")
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/save.html")
	public String save (User student){
		userService.save(student);
		return "success";
	}
	
	@RequestMapping(value="/registUI.html")
	public String registUI (){
		return "regist";
	}
}
