public abstract class StandardRepresentation implements FromStandard {
	private String id;

	public String getId() {
		return id;
	}	
	
	// TODO: HOW SHALL I TO REPRESENT THE VALUE OF REPRESENTATION?
	// WHAT SHOULD IT RETURN
	public abstract Object getValue();
}
