package src;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public abstract class Aspect {
	private String id;
	private StandardRepresentation stdRep;

	private Set<Representation> representations;
	private Set<InformationSource> informationSources;
	
	private static HashMap<String, Aspect> aspects = new HashMap<String,Aspect>();

	public Aspect(String id) throws AspectAlreadyCreatedException {
		if (aspects.containsKey(id)) {
			throw new AspectAlreadyCreatedException();
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

	public boolean compareTo(Aspect A) {
		if (A.stdRep.getValue().equals(this.stdRep.getValue()))
			return true;
		else
			return false;
	}

	public abstract Object getDistance(Aspect A);

	public abstract boolean validateData(SensorData sd);

	public void addRepresentation(Representation r) {
		representations.add(r);
	}

	public void setStandardRepresentation(Representation r) {
		if (representations.contains(r))
			stdRep = r.mapToStandard(); 
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
}