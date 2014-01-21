package src;
import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public abstract class Aspect implements Serializable  {
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

	// Making this function abstract...
	//	public boolean compareTo(Aspect A) {
	//		if (A.defaultRepresentation.getValue().equals(this.defaultRepresentation.getValue()))
	//			return true;
	//		else
	//			return false;
	//	}
	
	public abstract boolean isEqual(Aspect A);
	
	public abstract Serializable getDistance(Aspect a);

	public abstract Serializable validateData(Data d);

	public void addRepresentation(Representation r) {
		representations.add(r);
	}

	public void setStandardRepresentation(Representation r) {
		if (representations.contains(r))
			defaultRepresentation = r.mapToStandard(); 
	}

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