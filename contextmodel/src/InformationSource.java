package src;

import java.io.Serializable;

public abstract class InformationSource implements ToStandard, Serializable {
	private static final long serialVersionUID = 5746784687502503500L;
	
	private Data data;
	private String id;

	public Data getRawData() {
		return data;
	}

	public void setRawData(Data data) {
		this.data = data;
	}

	public String getId() {
		return id;
	}
}
