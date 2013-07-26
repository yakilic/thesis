import java.util.HashMap;
import java.util.HashSet;
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
		entityMap = new HashSet<PredicateEntityRelation>();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Entity other = (Entity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
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
		int count = 0;
		System.out.println("Entity \"" + this.getId() + "\" has following the entity relations:");
		for(PredicateEntityRelation pe : entityMap)
			System.out.println(++count + ") E:" + this.getId() + " - P:" + pe.p.getPredicateString() + " - E:" + pe.e.getId());
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public void attachEntity(Predicate p, Entity e) {
		PredicateEntityRelation pe = new PredicateEntityRelation(p, e);
		
		entityMap.add(pe);

		
	}

	public void detachEntity(Predicate p, Entity e) {
		for(PredicateEntityRelation pe : entityMap) {
			if (pe.equals(new PredicateEntityRelation(p, e)))
				entityMap.remove(pe);
			else
				System.out.println("Entity:" + e.id + " was not found related to Entity:" + this.id + " with Predicate:" + p.getPredicateString());
		}
	}
}
