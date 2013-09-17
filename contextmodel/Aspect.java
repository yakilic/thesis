import java.util.HashSet;
import java.util.Set;

public class Aspect {
	private String id;
	private StandardRepresentation stdRep;

	private Set<Representation> representations;
	private Set<InformationSource> informationSources;


	public Aspect(String id) {
		this.id = id;
		informationSources = new HashSet<InformationSource>();
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
	
	// TODO: WHAT SHOULD IT RETURN?
	public void getDistance(Aspect A) {
		//return
	}

	// TODO: make this function abstract
	public boolean validateData(SensorData sd) {
		return true;		
	}

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