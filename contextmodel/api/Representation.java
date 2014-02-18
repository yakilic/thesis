package api;

import java.io.Serializable;

public abstract class Representation implements Serializable {
	private static final long serialVersionUID = -8801814070525794580L;

	private String id;

	public String getId() {
		return id;
	}
}