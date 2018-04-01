package swing.sys.common.util;

import java.util.Collection;
import java.util.Map;
import java.util.regex.Pattern;

import swing.sys.common.ReturnObj;

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
}
