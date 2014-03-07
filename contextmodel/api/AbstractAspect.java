package api;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public abstract class AbstractAspect extends AbstractOntologyObject implements Comparable<AbstractAspect> {
	private static final long serialVersionUID = -6057604798159608597L;

	private Set<AbstractRepresentation> representations;
	private Set<AbstractInformationSource> informationSources;

	private Serializable value;
	
	private AbstractRepresentation defaultRepresentation;

	public AbstractAspect(String id) {
		this.id = id;

		informationSources = new HashSet<AbstractInformationSource>();
		representations = new HashSet<AbstractRepresentation>();
	}

	public abstract boolean isEqual(AbstractAspect A);

	// Returns a negative integer, zero, or a positive integer as this Aspect is
	// less than, equal to, or greater than the specified Aspect.
	// Should be implemented by the ontology builder comparable interface
	// public abstract int compareTo(Aspect A);
	public abstract Serializable getDistance(AbstractAspect a);

	// TODO: How will this be used?
	public abstract Serializable validateData(AbstractData d);

	// List of representations for users to be able to search
	public void addRepresentation(AbstractRepresentation r) {
		representations.add(r);
	}

	// This function will return the value in defaultRepresentation
	public abstract Serializable getValueInDefaultRepresentation();

	// This function will return the value in the given representation
	public abstract Serializable getValue(String representation);

	public void removeRepresentation(AbstractRepresentation r) {
		if (representations.contains(r))
			representations.remove(r);
		else
			System.err.println("Representation:" + r.getId()
					+ " was not found in Aspect:" + this.getId());
	}

	public void addInformationSource(AbstractInformationSource is) {
		informationSources.add(is);
	}

	public void removeInformationSource(AbstractInformationSource is) {
		if (informationSources.contains(is))
			informationSources.remove(is);
		else
			System.err.println("InformationSource:" + is.getId()
					+ " was not found in Aspect:" + this.getId());
	}

	public AbstractRepresentation getDefaultRepresentation() {
		return defaultRepresentation;
	}

	public void setDefaultRepresentation(AbstractRepresentation r) {
		if (representations.contains(r))
			this.defaultRepresentation = r;
	}
}