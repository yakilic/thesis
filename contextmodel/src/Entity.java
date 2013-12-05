package src;
import java.util.HashSet;
import java.util.Set;

public class Entity {
	private class PredicateEntityRelation {
		Predicate p;
		Entity e;

		public PredicateEntityRelation(Predicate p, Entity e) {
			this.p = p;
			this.e = e;
		}

		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((e == null) ? 0 : e.hashCode());
			result = prime * result + ((p == null) ? 0 : p.hashCode());
			return result;
		}

		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			PredicateEntityRelation other = (PredicateEntityRelation) obj;
			if (e == null) {
				if (other.e != null)
					return false;
			} else if (!e.equals(other.e))
				return false;
			if (p == null) {
				if (other.p != null)
					return false;
			} else if (!p.equals(other.p))
				return false;
			return true;
		}
	}

	private Set<Aspect> aspects;
	private String id;
	private Set<PredicateEntityRelation> entityMap;

	public Entity(String id) {
		this.id = id;
		aspects = new HashSet<Aspect>();
		entityMap = new HashSet<PredicateEntityRelation>();
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

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
		aspects.add(A);
	}

	public Aspect getAspect(String aspectName) {
		for (Aspect a : aspects) {
			if (a.getId().equals(aspectName))
				return a;
		}

		System.err.println("Aspect:" + aspectName + " was not found in Entity:"
				+ this.getId());
		return null;
	}

	public void removeAspect(Aspect A) {
		if (aspects.contains(A))
			aspects.remove(A);
		else
			System.err.println("Aspect:" + A.getId()
					+ " was not found in Entity:" + this.getId());
	}

	public void printAllAspects() {
		int count = 0;

		System.out.println("Entity:" + this.getId()
				+ " has the following aspects:");
		for (Aspect a : aspects)
			System.out.println(++count + ") " + a.getId());

		System.out.println();
	}

	public void printAllEntityRelations() {
		int count = 0;
		System.out.println("Entity \"" + this.getId()
				+ "\" has following the entity relations:");
		for (PredicateEntityRelation pe : entityMap)
			System.out.println(++count + ") Entity:" + this.getId()
					+ " - Predicate:" + pe.p.getPredicateString()
					+ " - Entity:" + pe.e.getId());

		System.out.println();
	}

	public String getId() {
		return id;
	}

	public void attachEntity(Predicate p, Entity e) {
		PredicateEntityRelation pe = new PredicateEntityRelation(p, e);
		entityMap.add(pe);
	}

	public void detachEntity(Predicate p, Entity e) {
		for (PredicateEntityRelation pe : entityMap) {
			if (pe.equals(new PredicateEntityRelation(p, e)))
				entityMap.remove(pe);
			else
				System.err.println("Entity:" + e.id
						+ " was not found related to Entity:" + this.id
						+ " with Predicate:" + p.getPredicateString());
		}
	}
}
