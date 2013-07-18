public class PredicateEntityRelation {
	Predicate p;
	Entity e;
	
	public PredicateEntityRelation(Predicate p, Entity e) {
		this.p = p;
		this.e = e;
	}
	
	public Boolean equals(PredicateEntityRelation pe) {
		if (pe.e.equals(this.e) && pe.p.equals(this.p))
			return true;
		else
			return false;
	}
	
}
