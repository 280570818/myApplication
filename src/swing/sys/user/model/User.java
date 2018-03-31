package swing.sys.user.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class User implements Serializable {
	private Long id;
	private Long cid;
	private String userName;
	private String password;
	private String email;
	private String sex;
	private String name;
	private String idCardNo;
	private String phoneNo;
	private String schoolName;
	private String className;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birthday;
	private String qqAccount;
	private String weiChatAccount;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getCid() {
		return cid;
	}
	public void setCid(Long cid) {
		this.cid = cid;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIdCardNo() {
		return idCardNo;
	}
	public void setIdCardNo(String idCardNo) {
		this.idCardNo = idCardNo;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getQqAccount() {
		return qqAccount;
	}
	public void setQqAccount(String qqAccount) {
		this.qqAccount = qqAccount;
	}
	public String getWeiChatAccount() {
		return weiChatAccount;
	}
	public void setWeiChatAccount(String weiChatAccount) {
		this.weiChatAccount = weiChatAccount;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", cid=" + cid + ", userName=" + userName + ", password=" + password + ", email="
				+ email + ", sex=" + sex + ", name=" + name + ", idCardNo=" + idCardNo + ", phoneNo=" + phoneNo
				+ ", schoolName=" + schoolName + ", className=" + className + ", birthday=" + birthday + ", qqAccount="
				+ qqAccount + ", weiChatAccount=" + weiChatAccount + "]";
	}
	
}
