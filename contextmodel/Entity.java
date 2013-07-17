import java.util.HashMap;
import java.util.Iterator;

public class Entity {
	private HashMap<String, Aspect> aspectMap;
	private String id;
	private Hashmap<Entity, Predicate> entityMap;

	public Entity(String id) {
		super();
		this.id = id;
		aspectMap = new HashMap<String, Aspect>();
	}

	public void addAspect(Aspect A) {
		aspectMap.put(A.getId(), A);
	}

	public Aspect getAspect(String aspectName) {
		return aspectMap.get(aspectName);
	}
	
	public void removeAspect(Aspect A) {
		aspectMap.remove(A.getId());
	}
	
	public void printAllAspects() {
		int i = 0;
		Iterator<Aspect> it = aspectMap.values().iterator();
		System.out.println("Entity \"" + this.getId() + "\" has following aspects to it:");
		while (it.hasNext()) {
		    System.out.println("" + ++i + ") " + it.next().getId());
		}
		System.out.println();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
