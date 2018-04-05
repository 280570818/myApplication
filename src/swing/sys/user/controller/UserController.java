package swing.sys.user.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import swing.sys.SessionManager;
import swing.sys.menu.model.Menu;
import swing.sys.user.model.User;
import swing.sys.user.service.UserService;


@Controller
@Scope(value="prototype")
@RequestMapping("/home")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	/**
	 * homePage主页
	 */
	@RequestMapping(value="/index.html")
	public String index (HttpServletRequest request, Model model){
		User user = SessionManager.getUser(request.getSession());
		List<Menu> menus = userService.getMenusByUser(user);
		model.addAttribute("menus", menus);
		return "home";
	}
	
	/**
	 * 退出登录
	 */
	@RequestMapping("/escape")
	public String escape (HttpServletRequest request){
		SessionManager.invalidate(request.getSession());
		request.setAttribute(LoginController.LOGIN_FLAG, "您已成功退出！");
		return "redirect:/login/loginUI.html";
	}
}
