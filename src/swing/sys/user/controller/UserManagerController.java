package swing.sys.user.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import swing.sys.user.service.UserService;

/**
 * 用户管理模块
 * @author wang_xf
 */
@Controller
@Scope(value="prototype")
@RequestMapping("/user")
public class UserManagerController {
	
	@Autowired
	private UserService userService;
	
	/**
	 * 用户管理首页
	 */
	@RequestMapping("/index.html")
	public String index (HttpServletRequest request, Model model){
		
		return "user/index";
	}
	
}
