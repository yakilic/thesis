public class PredicateEntityRelation {
	Predicate p;
	Entity e;
	
	public PredicateEntityRelation(Predicate p, Entity e) {
		this.p = p;
		this.e = e;
	}
	
	//Override
	public Boolean equals(PredicateEntityRelation pe) {
		if (pe == null)
				return false;
		
		if (pe.e.equals(this.e) && pe.p.equals(this.p))
			return true;
		else
			return false;
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
