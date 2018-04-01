package swing.test;

import org.junit.Test;

import swing.sys.common.util.EmailSender;

public class Code {
	@Test
	public void test() {
		EmailSender.getInstance("280570818@qq.com", "123456","", null).run();
	}
	@Test
	public void test2() {
	}

}
