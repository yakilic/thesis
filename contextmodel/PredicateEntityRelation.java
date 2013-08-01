public class PredicateEntityRelation {
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
