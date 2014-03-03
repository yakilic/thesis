package api;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public abstract class AbstractAspect implements Serializable, Comparable<AbstractAspect>,
		OntologyObject {
	private static final long serialVersionUID = -6057604798159608597L;

	private String id;

	private Set<AbstractRepresentation> representations;
	private Set<AbstractInformationSource> informationSources;

	private AbstractRepresentation defaultRepresentation;

	// TODO:	Swap with persistance manager
	private static HashMap<String, AbstractAspect> aspects = new HashMap<String, AbstractAspect>(); 
	

	public AbstractAspect(String id) {
		if (aspects.containsKey(id)) {
			throw new AssertionError("Aspect already present");
		}

		this.id = id;

		informationSources = new HashSet<AbstractInformationSource>();
		representations = new HashSet<AbstractRepresentation>();

		aspects.put(this.id, this);
	}

	public String getId() {
		return id;
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

	public void setStandardRepresentation(AbstractRepresentation r) {
		if (representations.contains(r))
			defaultRepresentation = r;

		// TODO: From ontology call a function getValue
	}

	// This function will return the value in defaultRepresentation
	public abstract Serializable getValue();

	// This function will return the value in the given representation
	public abstract Serializable getValue(String representationClassName);

	// TODO: pass the class name or type instead of object
	// TODO: pass as a string class name and do DYNAMIC CLASS LOADING of the
	// class by name
	// careful when calling metods which are not available, only call from
	// interface
	// JAVA REFLECTION
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

	public void setDefaultRepresentation(AbstractRepresentation defaultRepresentation) {
		this.defaultRepresentation = defaultRepresentation;
	}
}