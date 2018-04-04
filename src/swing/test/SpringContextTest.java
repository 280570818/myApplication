package swing.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import swing.sys.menu.mapper.MenuMapper;
import swing.sys.menu.model.Menu;

/**
 * spring容器测试
 * @author wang-xf
 */
public class SpringContextTest {
	ClassPathXmlApplicationContext context;
	@Test
	public void test() {
		
		MenuMapper menuMapper = context.getBean("menuMapper", MenuMapper.class);
		
		Menu menu = new Menu();
		menu.setId(18);
		menu.setParentId(1);
		menu.setPath("0110");
		menu.setName("测试");
		menu.setType("2");
		menu.setDescription("测试6");
		menu.setUrl("/dwqdwq/fwefew");
		Integer insertMenu = null;
		try {
//			insertMenu = menuMapper.updateMenuById(menu);
//			insertMenu = menuMapper.testUpdate(menu);
			insertMenu = menuMapper.deleteMenuByIds(new Integer[]{12,13});
//			insertMenu = menuMapper.deleteMenuById(11);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println(insertMenu);
		}
		
	}

	@Before
	public void before(){
		context = new ClassPathXmlApplicationContext("spring/spring-application.xml");
	}
}
