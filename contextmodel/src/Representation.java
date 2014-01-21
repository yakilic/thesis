package src;

import java.io.Serializable;

// TODO: This class should implement ToStandard if it is to be used as DefaultRepresentation for an Aspect
public abstract class Representation implements ToDefault, Serializable {
	private static final long serialVersionUID = -8801814070525794580L;
	
	private String id;

	public String getId() {
		return id;
	}


	
	public abstract Serializable getValue();
}