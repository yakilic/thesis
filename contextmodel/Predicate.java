public class Predicate {
	private String predicateString;
	
	public Predicate(String predicateString) {
		this.predicateString = new String(predicateString);
	}

	public String getPredicateString() {
		return predicateString;
	}
	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((predicateString == null) ? 0 : predicateString.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Predicate other = (Predicate) obj;
		if (predicateString == null) {
			if (other.predicateString != null)
				return false;
		} else if (!predicateString.equals(other.predicateString))
			return false;
		return true;
	}

	public void setPredicateString(String predicateString) {
		this.predicateString = predicateString;
	}
}
