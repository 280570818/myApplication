package swing.sys.user.mapper;

import swing.sys.user.model.User;

public interface UserMapper {

	public Integer save(User s);

	public User getUserByUserName(String userName);
	
	public User getUserByEmail(String email);
	
	public Integer updateUserById(User u);
	
	public Integer userNameIsExists(String userName);
}
