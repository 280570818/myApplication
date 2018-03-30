package swing.sys.listener;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import swing.sys.common.ContentParams;
import swing.sys.common.util.CloseUtil;

/**
 * 资源初始化监听器
 * @author wang_xf
 */
public class ResourceListener extends ContentParams implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		System.out.println("listener destroy");
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		String resourcePath = event.getServletContext().getInitParameter("resourcePath");
		InputStream is = event.getServletContext().getClassLoader().getResourceAsStream(resourcePath);
		try {
			properties = new Properties();
			properties.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			CloseUtil.release(is);
		}
	}

}
