package api;
import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public abstract class Aspect implements Serializable, Comparable<Aspect>, OntologyObject  {
	private static final long serialVersionUID = -6057604798159608597L;
	
	private String id;

	private Set<Representation> representations;
	private Set<InformationSource> informationSources;

	private Representation defaultRepresentation;

	private static HashMap<String, Aspect> aspects = new HashMap<String,Aspect>(); // TODO: This will be changed when persistance manager is in place

	public Aspect(String id) {
		if (aspects.containsKey(id)) {
			throw new AssertionError("Aspect already present");
		} 

		this.id = id;

		if (id == null) {
			throw new AssertionError("AspectId is null");
		}

		informationSources = new HashSet<InformationSource>();
		representations = new HashSet<Representation>();

		aspects.put(this.id, this);
	}

	public String getId() {
		return id;
	}
	
	public abstract boolean isEqual(Aspect A);
	
	//  Returns a negative integer, zero, or a positive integer as this Aspect is less than, equal to, or greater than the specified Aspect.
	// Should be implemented by the ontology builder comparable interface
	//public abstract int compareTo(Aspect A);
	
	public abstract Serializable getDistance(Aspect a);

	// TODO: How will this be used?
	public abstract Serializable validateData(Data d);

	// List of representations for users to be able to search
	public void addRepresentation(Representation r) {
		representations.add(r);
	}

	public void setStandardRepresentation(Representation r) {
		if (representations.contains(r))
			defaultRepresentation = r; 
		
		// TODO: From ontology call a function getValue
	}
	
	// This function will return the value in defaultRepresentation
	public abstract Serializable getValue();
	
	// This function will return the value in the given representation
	public abstract Serializable getValue(String representationClassName);
	
	// TODO: pass the class name or type instead of object
	// TODO: pass as a string class name and do DYNAMIC CLASS LOADING of the class by name
	// careful when calling metods which are not available, only call from interface
	// JAVA REFLECTION
	public void removeRepresentation(Representation r) {
		if (representations.contains(r))
			representations.remove(r);
		else
			System.err.println("Representation:" + r.getId()
					+ " was not found in Aspect:" + this.getId());
	}

	public void addInformationSource(InformationSource is) {
		informationSources.add(is);
	}

	public void removeInformationSource(InformationSource is) {
		if (informationSources.contains(is))
			informationSources.remove(is);
		else
			System.err.println("InformationSource:" + is.getId()
					+ " was not found in Aspect:" + this.getId());
	}

	public Representation getDefaultRepresentation() {
		return defaultRepresentation;
	}

	public void setDefaultRepresentation(Representation defaultRepresentation) {
		this.defaultRepresentation = defaultRepresentation;
	}
}