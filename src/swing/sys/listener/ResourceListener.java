package swing.sys.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * 资源初始化监听器
 * @author wang_xf
 */
public class ResourceListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		System.out.println("listener destroy");
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		System.out.println("listener init");
	}

}
