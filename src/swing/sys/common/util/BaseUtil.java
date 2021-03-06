package swing.sys.common.util;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Map;
import java.util.regex.Pattern;

import swing.sys.common.ReturnObj;
import swing.sys.user.model.User;

/**
 * 全局基础工具
 * @author wang_xf
 */
public class BaseUtil {
	
	/**
	 * 异步返回通用类
	 */
	public static ReturnObj getReturnObj(boolean success, String msg, Object data, int flag){
		ReturnObj returnObj = new ReturnObj();
		returnObj.setData(data);
		returnObj.setFlag(flag);
		returnObj.setMessage(msg);
		returnObj.setSuccess(success);
		return returnObj; 
	}

	/**
	 * 正则匹配
	 */
	public static boolean verifyReg(String str, String pattern) {
		return Pattern.compile(pattern).matcher(str).matches();
	}
	
	/**
	 * 某对象是否为空
	 */
	public static boolean isNullOrEmpty(Object obj){
		if(obj == null || "null".equals(obj))
			return true;
		if(obj.toString().trim().length()==0)
			return true;
		if(obj instanceof Collection && ((Collection<?>)obj).size()==0)
			return true;
		if(obj instanceof Map && ((Map<?, ?>)obj).size()==0)
			return true;
		return false;
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
		return true;
	}
}
