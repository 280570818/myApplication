package swing.sys.menu.model;

import java.util.ArrayList;
import java.util.List;

/**
 * 菜单
 * @author wang_xf
 */
public class Menu {

	private Integer id;
	private Integer parentId;
	private String path;
	/**菜单描述*/
	private String name;
	/**菜单类型：1-父菜单；2-资源菜单*/
	private String type;
	/**菜单路径*/
	private String url;
	/**菜单描述*/
	private String description;
	/**菜单图标*/
	private String icon;
	private List<Menu> children;
	
	public List<Menu> getChildren() {
		if(children == null)
			children = new ArrayList<Menu>();
		return children;
	}
	public void setChildren(List<Menu> children) {
		this.children = children;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
