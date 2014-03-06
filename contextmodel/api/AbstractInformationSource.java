package api;

public abstract class AbstractInformationSource extends AbstractOntologyObject {
	private static final long serialVersionUID = 5746784687502503500L;

	private AbstractData data;
	
	public AbstractData getRawData() {
		return data;
	}

	public void setRawData(AbstractData data) {
		this.data = data;
	}
}
