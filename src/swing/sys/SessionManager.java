package swing.sys;

import java.lang.reflect.Field;

import javax.servlet.http.HttpSession;

import swing.sys.common.ContentParams;
import swing.sys.common.util.BaseUtil;
import swing.sys.user.model.User;

/**
 * session管理
 * @author wang_xf
 */
public class SessionManager {

	public static final String SESSION_USER = "session_user_t"+ContentParams.getParam("sessionindex");

	/**
	 * 向session中添加一个user
	 */
	public static void setUser(HttpSession session, User u) {
		session.setAttribute(SESSION_USER, u);
	}
	/**
	 * 得到session中保存的user
	 */
	public static User getUser(HttpSession session){
		return (User) session.getAttribute(SESSION_USER);
	}
	/**
	 * 修改session中保存的user
	 */
	public static void updateUser(HttpSession session, User u){
		User user = getUser(session);
		Field[] fields = user.getClass().getDeclaredFields();
		for (Field field : fields) {
			field.setAccessible(true);
			try {
				Object obj = field.get(u);
				if(!BaseUtil.isNullOrEmpty(obj)){
					field.set(user, obj);
				}
			} catch (IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * 销毁session
	 */
	public static void invalidate(HttpSession session){
		session.invalidate();
	}
}
