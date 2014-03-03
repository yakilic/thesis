package api;

import java.io.Serializable;

public abstract class AbstractInformationSource implements Serializable {
	private static final long serialVersionUID = 5746784687502503500L;

	private AbstractData data;
	private String id;

	public AbstractData getRawData() {
		return data;
	}

	public void setRawData(AbstractData data) {
		this.data = data;
	}

	public String getId() {
		return id;
	}
}
