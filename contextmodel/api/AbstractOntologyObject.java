package api;

import java.io.Serializable;

public abstract class AbstractOntologyObject implements Serializable {
	private static final long serialVersionUID = 7255240236084887628L;
	
	protected String id = "";
	
	public String getId() {
		return id;
	};
}
