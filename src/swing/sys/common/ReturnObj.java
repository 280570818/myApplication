package swing.sys.common;

public class ReturnObj {

	private Boolean success;
	private String message;
	private Object data;
	private Integer flag;
	public Boolean getSuccess() {
		return success;
	}
	public void setSuccess(Boolean success) {
		this.success = success;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public Integer getFlag() {
		return flag;
	}
	public void setFlag(Integer flag) {
		this.flag = flag;
	}
	@Override
	public String toString() {
		return "ReturnObj [success=" + success + ", message=" + message + ", data=" + data + ", flag=" + flag + "]";
	}
}
