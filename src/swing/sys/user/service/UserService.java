package swing.sys.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import swing.sys.user.mapper.UserMapper;
import swing.sys.user.model.User;


@Service
public class UserService {
	@Autowired
	private UserMapper userMapper;
	
	public void save(User s) {
		userMapper.save(s);
	}

}
