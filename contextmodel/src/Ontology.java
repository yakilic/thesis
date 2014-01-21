package src;

import java.util.HashSet;
import java.util.Set;

public class Ontology {
	private String id;
	
	// TODO: Shall we replaced with persistance manager
	//private HashMap<String, Aspect> aspects;
	private Set<Entity> entities = new HashSet<Entity>();
		
	
	public Ontology(String id)
	{
		// TODO: Store ontologies in persistance manager
		setId(id);
		
		// TODO: Storage shall be persistent later on
		// aspects = new HashMap<String,Aspect>();
		entities = new HashSet<Entity>();
	}
	
	
//	TODO: How am I going to implement this function?
//	I can not create an Aspect since it is abstract?
//	Maybe make aspect creation outside and make a method Ontology.addAspect(Aspect a)
	
//	public Aspect createAspect(String id)
//	{
//		
//		Aspect a = new Aspect(id);
//		aspects.put(id, a);
//		return a;
//	}
	
	public void addEntity(Entity e)
	{
		if (entities.contains(e)) {
			throw new AssertionError("Entity already present in ontology");		} 
		
		entities.add(e);
	}
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
