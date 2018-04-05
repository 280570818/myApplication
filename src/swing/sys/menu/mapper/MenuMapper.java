package swing.sys.menu.mapper;

import java.util.List;

import swing.sys.menu.model.Menu;

public interface MenuMapper {

	Integer insertMenu(Menu menu);
	
	Integer deleteMenuById(Integer id);
	
	Integer deleteMenuByIds(Integer[] ids);
	
	Integer updateMenuById(Menu menu);
	
	Menu QueryMenuById(Integer id);
	
	List<Menu> queryAllMenu();

	List<Menu> QueryMenuByIds(Integer[] ids);
	
	
}
