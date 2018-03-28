package swing.ywl.info.model;

public class Description {

	private Integer id;
	private String columnName;
	private String columnDesc;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getColumnName() {
		return columnName;
	}
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
	public String getColumnDesc() {
		return columnDesc;
	}
	public void setColumnDesc(String columnDesc) {
		this.columnDesc = columnDesc;
	}
	@Override
	public String toString() {
		return "Description [id=" + id + ", columnName=" + columnName + ", columnDesc=" + columnDesc + "]";
	}
	
}
