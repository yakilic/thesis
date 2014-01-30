package api;

import java.util.HashSet;
import java.util.Set;

public class Ontology {
	private String id;

	// TODO: Shall we replaced with persistence manager
	private Set<Entity> entities = new HashSet<Entity>();
	private Set<Aspect> aspects = new HashSet<Aspect>();	

	//private ClassLoader systemClassLoader;

	public Ontology(String id)
	{
		// TODO: Store ontologies in persistence manager
		setId(id);

	//	systemClassLoader = ClassLoader.getSystemClassLoader();

		// TODO: Storage shall be persistent later on
		entities = new HashSet<Entity>();
		aspects = new HashSet<Aspect>();
	}
	
	private void store(OntologyObject oo) {
		
	}

	private void storeEntity(Entity e) {
		if (entities.contains(e)) {
			throw new AssertionError("Entity already present in ontology");		} 

		entities.add(e);
	}

	private void storeAspect(Aspect a) {
		if (aspects.contains(a)) {
			throw new AssertionError("Aspect already present in ontology");		} 

		aspects.add(a);
	}
	
	private <T> T instantiate(final String className, final Class<T> type) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
	    return type.cast(Class.forName(className).newInstance());
	}

	private <T> void createAndStoreOntologyMember(String className, Class<T> T) throws InstantiationException, IllegalAccessException, ClassNotFoundException
	{
		T t = instantiate(className, T);
		store((OntologyObject) t);
	}
	

	public void createEntity(String entityClassName) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		createAndStoreOntologyMember(entityClassName, Entity.class);
	}		
	
	public void createAspect(String aspectClassName) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		createAndStoreOntologyMember(aspectClassName, Aspect.class);
	}		
	
	/*
	public void createEntity(String entityClassName) {
		//Entity e = (Entity)
		//    EntityLoader.newInstance(entityClassName);

		try {
			Entity entityInstance = (Entity) systemClassLoader.loadClass(entityClassName).newInstance();

			storeEntity(entityInstance); // TODO: Change with persistence manager

		} catch (ClassNotFoundException e) {
			System.err.println("Entity class " + entityClassName + " not found");
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	*/
/*
	public void createAspect(String aspectClassName) {
		//Entity e = (Entity)
		//    EntityLoader.newInstance(entityClassName);

		try {
			Aspect entityInstance = (Aspect) systemClassLoader.loadClass(aspectClassName).newInstance();

			storeAspect(entityInstance); // TODO: Change with persistence manager

		} catch (ClassNotFoundException e) {
			System.err.println("Aspect class " + aspectClassName + " not found");
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	*/

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
