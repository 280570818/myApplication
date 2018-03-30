package swing.sys.common;

import java.util.Properties;

/**
 * 全局参数
 * @author wang_xf
 */
public class ContentParams {

	protected static Properties properties;
	
	/**
	 * 根据key得到对应的全局参数
	 */
	public static String getParam(String key){
		return properties.getProperty(key);
	}
}
