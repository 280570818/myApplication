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
import swing.sys.user.model.User;

/**
 * 登录过滤
 * @author wang_xf
 */
public class LoginFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		User user = (User) req.getSession().getAttribute(SessionManager.SESSION_USER);
		if(BaseUtil.isNullOrEmpty(user)){
			
		}else{
			chain.doFilter(request, response);
		}
	}

	public LoginFilter() {
	}
	public void destroy() {
	}
	public void init(FilterConfig fConfig) throws ServletException {
	}
}
