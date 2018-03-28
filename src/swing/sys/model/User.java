package swing.sys.model;

import java.io.Serializable;

public class User implements Serializable {
	private Long id;
	private Integer age;
	private Long cid;
	private String name;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Long getCid() {
		return cid;
	}
	public void setCid(Long cid) {
		this.cid = cid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", age=" + age + ", cid=" + cid
				+ ", name=" + name + "]";
	}
}
