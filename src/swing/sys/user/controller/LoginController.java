package swing.sys.user.controller;

import java.io.IOException;
import java.lang.reflect.Field;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import swing.sys.SessionManager;
import swing.sys.common.ReturnObj;
import swing.sys.common.util.BaseUtil;
import swing.sys.user.model.User;
import swing.sys.user.service.UserService;


@Controller
@Scope(value="prototype")
@RequestMapping("/login")
public class LoginController {
	
	public static final String LOGIN_FLAG = "loginStatus";
	public static final String REGIST_FLAG = "registStatus";
	@Autowired
	private UserService userService;
	
	@RequestMapping("/login")
	public String login (HttpServletRequest request, User user 
			) throws ServletException, IOException{
		
		User u = userService.login(user);
		if(u != null){
			request.getSession().setAttribute(SessionManager.SESSION_USER, u);
			return userInfoIsOK(u)?"home":"infoRegist";
		}else{
			request.setAttribute(LoginController.LOGIN_FLAG, "对不起！账户/密码错误！");
			return "login";
		}
	}
	
	/**
	 * 判断用户信息是否完整
	 */
	public static boolean userInfoIsOK(User u) {
		Field[] fields = u.getClass().getDeclaredFields();
		for (Field field : fields) {
			field.setAccessible(true);
			try {
				Object object = field.get(u);
				if(BaseUtil.isNullOrEmpty(object))
					return false;
			} catch (IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	@RequestMapping("/regist")
	public String regist (HttpServletRequest request, User user){
		System.out.println(user);
		userService.save(user);
		request.setAttribute(REGIST_FLAG, "注册成功，请登录");
		return "login";
	}
	
	@RequestMapping("/forget")
	@ResponseBody
	public ReturnObj forget (HttpServletRequest request, String email){
		String forget = userService.forget(email);
		if(BaseUtil.isNullOrEmpty(forget)){
			return BaseUtil.getReturnObj(true, "邮件发送成功，请前往邮件查看", null, 0);
		}else{
			return BaseUtil.getReturnObj(false, forget, null, 0);
		}
	}
	
	@RequestMapping("/infoRegist")
	public String infoRegist (HttpServletRequest request, User user){
		System.out.println(user);
		userService.updateUserById(user);
		return "home";
	}
	
	@RequestMapping("/usernameisexists")
	@ResponseBody
	public String usernameisexists (@RequestParam String userName){
		return userService.userNameIsExists(userName);
	}
	
	@RequestMapping("/loginUI")
	public String loginUI(HttpServletRequest request){
		
		return "login";
	}
	
	@RequestMapping("/registUI")
	public String registUI(HttpServletRequest request){
		
		return "regist";
	}
}
