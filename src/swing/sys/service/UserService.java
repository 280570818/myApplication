package swing.sys.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import swing.sys.mapper.UserMapper;
import swing.sys.model.User;

@Service
public class UserService {
	@Autowired
	private UserMapper userMapper;
	
	public void save(User s) {
		userMapper.save(s);
	}

}
