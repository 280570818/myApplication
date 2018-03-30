package swing.sys.common.util;

import java.io.Closeable;
import java.io.IOException;

/**
 * 资源释放工具-释放IO等
 * @author wang_xf
 */
public class CloseUtil {

	public static void release(Closeable... objs){
		for (Closeable obj : objs) {
			if(obj != null){
				try {
					obj.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void release(AutoCloseable... objs){
		for (AutoCloseable obj : objs) {
			if(obj != null){
				try {
					obj.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
