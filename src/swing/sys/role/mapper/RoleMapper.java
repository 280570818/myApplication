package swing.sys.role.mapper;

import java.util.List;

import swing.sys.role.model.Role;

public interface RoleMapper {

	Integer insertRole(Role role);
	
	Integer deleteRoleById(Integer id);
	
	Integer updateRoleById(Role role);
	
	Role QueryRoleById(Integer id);
	
	List<Role> queryAllRole();
	
}
