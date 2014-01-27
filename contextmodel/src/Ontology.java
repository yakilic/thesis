package src;

import java.util.HashSet;
import java.util.Set;

public class Ontology {
	private String id;

	// TODO: Shall we replaced with persistence manager
	private Set<Entity> entities = new HashSet<Entity>();
	private Set<Aspect> aspects = new HashSet<Aspect>();	

	private ClassLoader systemClassLoader;


	public Ontology(String id)
	{
		// TODO: Store ontologies in persistence manager
		setId(id);

		systemClassLoader = ClassLoader.getSystemClassLoader();

		// TODO: Storage shall be persistent later on
		entities = new HashSet<Entity>();
		aspects = new HashSet<Aspect>();
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
