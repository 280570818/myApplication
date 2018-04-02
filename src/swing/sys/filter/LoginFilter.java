package swing.sys.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import swing.sys.SessionManager;
import swing.sys.common.util.BaseUtil;
import swing.sys.user.controller.LoginController;
import swing.sys.user.model.User;

/**
 * 登录过滤
 * @author wang_xf
 */
public class LoginFilter implements Filter {

	private String[] ignorPath = null;
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		User user = (User) req.getSession().getAttribute(SessionManager.SESSION_USER);
		if(BaseUtil.isNullOrEmpty(user)){
			for (int i = 0; i < ignorPath.length; i++) {
				if(req.getRequestURI().endsWith(ignorPath[i])){
					chain.doFilter(request, response);
					return;
				}
			}
			if(!req.getRequestURI().endsWith("/")){
				req.setAttribute(LoginController.LOGIN_FLAG, "会话过期！请重新登录！");
			}
			//请求路径为/而且没有登陆的，就去登陆页面
			request.getRequestDispatcher("/login/loginUI.html").forward(req, response);
		}else{
			chain.doFilter(request, response);
		}
	}

	public LoginFilter() {
	}
	public void destroy() {
	}
	public void init(FilterConfig fConfig) throws ServletException {
		ignorPath = fConfig.getInitParameter("ignorPath").split(",");
	}
}
