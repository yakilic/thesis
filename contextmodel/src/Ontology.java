package src;

import java.util.HashMap;

public class Ontology {
	private String id;
	private HashMap<String, Aspect> aspects;
	private HashMap<String, Entity> entities;
		
	public Ontology(String id)
	{
		setId(id);
		
		// TODO: Storage shall be persistent later on
		aspects = new HashMap<String,Aspect>();
		entities = new HashMap<String, Entity>();
	}
	
	public Aspect createAspect(String id)
	{
		Aspect a = new Aspect(id);
		aspects.put(id, a);
		return a;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	
	
}
