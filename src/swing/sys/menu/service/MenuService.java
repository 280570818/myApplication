package swing.sys.menu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import swing.sys.menu.mapper.MenuMapper;
import swing.sys.menu.model.Menu;

@Service
public class MenuService {

	@Autowired
	private MenuMapper menuMapper;
	
	public boolean insertMenu(Menu menu){
		return menuMapper.insertMenu(menu)==1;
	}
	
	public boolean updateMenu(Menu menu){
		return menuMapper.updateMenuById(menu)==1;
	}
	
	public boolean deleteMenuById(Integer id){
		return menuMapper.deleteMenuById(id)==1;
	}
	
	public Menu queryMenuById(Integer id){
		return menuMapper.QueryMenuById(id);
	}
	
}
