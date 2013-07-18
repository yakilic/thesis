import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Entity {
	private HashMap<String, Aspect> aspectMap;
	private String id;
	private Set<PredicateEntityRelation> entityMap;

	public Entity(String id) {
		super();
		this.id = id;
		aspectMap = new HashMap<String, Aspect>();
	}
	
	public boolean equals(Entity e) {
		if (e.id.equals(this.id))
			return true;
		else 
			return false;
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
		System.out.println("Entity \"" + this.getId() + "\" has the following aspects:");
		while (it.hasNext()) {
		    System.out.println("" + ++i + ") " + it.next().getId());
		}
		System.out.println();
	}
	
	public void printAllEntityRelations() {
		System.out.println("Entity \"" + this.getId() + "\" has following the entity relations:");
		for(PredicateEntityRelation pe : entityMap) {
	// TODO!		
		}
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public void attachEntity(Predicate p, Entity e) {
		entityMap.add(new PredicateEntityRelation(p, e));
	}

	public void detachEntity(Predicate p, Entity e) {
		for(PredicateEntityRelation pe : entityMap) {
			if (pe.equals(new PredicateEntityRelation(p, e)))
				entityMap.remove(pe);
			else
				System.out.print("Entity:" + e.id + " was not found related to Entity:" + this.id);
		}
	}
	
	

}
