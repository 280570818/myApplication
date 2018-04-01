package swing.sys.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import swing.sys.common.util.BaseUtil;
import swing.sys.user.mapper.UserMapper;
import swing.sys.user.model.User;


@Service
public class UserService {
	@Autowired
	private UserMapper userMapper;
	
	public void save(User s) {
		userMapper.save(s);
	}

	public User login(User user) {
		User u = userMapper.getUserByUserName(user.getUserName());
		if(u == null || !u.getPassword().equals(user.getPassword())){
			return null;
		}else{
			return u;
		}
	}

	public String userNameIsExists(String userName) {
		return String.valueOf(userMapper.userNameIsExists(userName));
	}

	public void updateUserById(User user) {
		userMapper.updateUserById(user);
	}

	public String forget(String email) {
		User user = userMapper.getUserByEmail(email);
		if(BaseUtil.isNullOrEmpty(user)){
			return "该邮箱地址尚未注册帐号，请检查";
		}
		//发送邮件
		
		//发送邮件成功
		return null;
	}

}
