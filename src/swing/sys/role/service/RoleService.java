package swing.sys.role.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import swing.sys.role.mapper.RoleMapper;
import swing.sys.role.model.Role;

@Service
public class RoleService {

	@Autowired
	private RoleMapper roleMapper;
	
	public boolean insertRole(Role Role){
		return roleMapper.insertRole(Role)==1;
	}
	
	public boolean updateRole(Role Role){
		return roleMapper.updateRoleById(Role)==1;
	}
	
	public boolean deleteRoleById(Integer id){
		return roleMapper.deleteRoleById(id)==1;
	}
	
	public Role queryRoleById(Integer id){
		return roleMapper.QueryRoleById(id);
	}
	
	public List<Role> queryAllRole(){
		return roleMapper.queryAllRole();
	}
	
	
}
