package api;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Ontology {
	private String id;

	// TODO: Shall we replaced with persistence manager
	private HashMap<String, Entity> entities = new HashMap<String, Entity>();
	private HashMap<String, Aspect> aspects = new HashMap<String, Aspect>();

	// private ClassLoader systemClassLoader;

	public Ontology(String id) {
		// TODO: Store ontologies in persistence manager
		setId(id);

		// systemClassLoader = ClassLoader.getSystemClassLoader();

		// TODO: Storage shall be persistent later on
		//entities = new HashMap<Entity>();
		//aspects = new HashMap<Aspect>();
	}
	
	public Entity getEntity(String id) {
			return entities.get(id);
	}

	private void store(OntologyObject oo) {

	}

	private void storeEntity(Entity e) {
		if (entities.containsKey(e.getId())) {
			throw new AssertionError("Entity already present in ontology");
		}

		entities.put(e.getId(), e);
	}

	private void storeAspect(Aspect a) {
		if (aspects.containsKey(a.getId())) {
			throw new AssertionError("Aspect already present in ontology");
		}

		aspects.put(a.getId(), a);
	}

	private void createAndStoreOntologyMember(final String className,
			final String id) throws ClassNotFoundException,
			NoSuchMethodException, SecurityException, InstantiationException,
			IllegalAccessException, IllegalArgumentException,
			InvocationTargetException {
		//	T t = instantiate(className, T, id);
	//	store((OntologyObject) t);
		
		Class<?> c = Class.forName(className);
		
//		System.out.println(c.getCanonicalName()); 
		

		Constructor<?> ctor = c.getConstructor(String.class);
		
		Object o = ctor.newInstance(id);
		if (o instanceof Entity)
			storeEntity((Entity) o );
	}

	public void createEntity(String entityClassName, final String id)
			throws InstantiationException, IllegalAccessException,
			ClassNotFoundException, NoSuchMethodException, SecurityException,
			IllegalArgumentException, InvocationTargetException {
		createAndStoreOntologyMember(entityClassName, Entity.class, id);

		// Class<? extends Entity> c = Class.forName(entityClassName); //Entity
		// e = new Entity(id);
		// Constructor ctor =
	}

	public void createAspect(String aspectClassName, final String id)
			throws InstantiationException, IllegalAccessException,
			ClassNotFoundException, NoSuchMethodException, SecurityException,
			IllegalArgumentException, InvocationTargetException {
		createAndStoreOntologyMember(aspectClassName, Aspect.class, id);
	}

	/*
	 * public void createEntity(String entityClassName) { //Entity e = (Entity)
	 * // EntityLoader.newInstance(entityClassName);
	 * 
	 * try { Entity entityInstance = (Entity)
	 * systemClassLoader.loadClass(entityClassName).newInstance();
	 * 
	 * storeEntity(entityInstance); // TODO: Change with persistence manager
	 * 
	 * } catch (ClassNotFoundException e) { System.err.println("Entity class " +
	 * entityClassName + " not found"); e.printStackTrace(); } catch
	 * (InstantiationException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } catch (IllegalAccessException e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); } }
	 */
	/*
	 * public void createAspect(String aspectClassName) { //Entity e = (Entity)
	 * // EntityLoader.newInstance(entityClassName);
	 * 
	 * try { Aspect entityInstance = (Aspect)
	 * systemClassLoader.loadClass(aspectClassName).newInstance();
	 * 
	 * storeAspect(entityInstance); // TODO: Change with persistence manager
	 * 
	 * } catch (ClassNotFoundException e) { System.err.println("Aspect class " +
	 * aspectClassName + " not found"); e.printStackTrace(); } catch
	 * (InstantiationException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } catch (IllegalAccessException e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); } }
	 */

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
