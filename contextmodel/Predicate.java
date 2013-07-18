public class Predicate {
	private String predicateString;
	
	public Predicate(String predicateString) {
		this.predicateString = new String(predicateString);
	}

	public String getPredicateString() {
		return predicateString;
	}
	
	public boolean equals(Predicate p) {
		if (p.equals(this.predicateString))
			return true;
		else 
			return false;
	}

	public void setPredicateString(String predicateString) {
		this.predicateString = predicateString;
	}
}
