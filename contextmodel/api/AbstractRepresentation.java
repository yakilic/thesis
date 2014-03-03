package api;

import java.io.Serializable;

public abstract class AbstractRepresentation implements Serializable {
	private static final long serialVersionUID = -8801814070525794580L;

	private String id;

	public String getId() {
		return id;
	}
}