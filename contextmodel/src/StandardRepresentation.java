package src;

import java.io.Serializable;

public abstract class StandardRepresentation implements FromStandard, Serializable {
	private static final long serialVersionUID = -4968853409537184919L;
	
	private String id;

	public String getId() {
		return id;
	}	

	public abstract Serializable getValue();
}
