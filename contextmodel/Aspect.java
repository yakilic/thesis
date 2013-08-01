import java.util.HashSet;
import java.util.Set;

public class Aspect {
	private String id;
	private Representation standardRepresentation;
	private Set<InformationSource> informationSources;

	public Aspect(String id) {
		this.id = id;
		informationSources = new HashSet<InformationSource>();
	}

	public String getId() {
		return id;
	}

	// TODO: make this function abstract
	public Boolean validateData(SensorData sd) {
		return false;
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