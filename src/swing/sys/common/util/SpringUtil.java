package swing.sys.common.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class SpringUtil implements ApplicationContextAware {
	
	private static ApplicationContext APPLICATIONCONTEXT;
	
	@Override
	public void setApplicationContext(ApplicationContext arg0) throws BeansException {
		if(APPLICATIONCONTEXT == null){
			APPLICATIONCONTEXT = arg0;
		}
	}
	
	public static Object getBean(String beanId){
		return APPLICATIONCONTEXT.getBean(beanId);
	}
}
