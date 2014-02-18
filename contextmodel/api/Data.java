package api;

import java.io.Serializable;

public abstract class Data implements Serializable {
	private static final long serialVersionUID = -6839411554998093949L;

	private String id;

	public String getId() {
		return id;
	}
}
