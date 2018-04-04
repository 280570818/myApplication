package swing.sys.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import swing.sys.common.ContentParams;
import swing.sys.common.util.BaseUtil;
import swing.sys.common.util.MailSender;
import swing.sys.user.mapper.UserMapper;
import swing.sys.user.model.User;


@Service
public class UserService {
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private MailSender mailSender;
	
	public void save(User s) {
		userMapper.save(s);
	}

	/**
	 * 执行登录操作
	 * 根据用户名在数据库查询是否存在该用户
	 * 如果存在，就判断密码是否一致
	 * 如果用户不存在，或，密码不一致，返回null
	 * 全部一致就返回该用户用于在session中保存
	 */
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
		String title = ContentParams.getParam("forgetPasswordTitle");
		String content = ContentParams.getParam("forgetPasswordNotice");
		content = content.replace("username", user.getName()).replace("link", "http://localhost:8888/login/loginUI.html");
		mailSender.sendEmail(content, user.getEmail(), title);
		//发送邮件成功
		return null;
	}

}
