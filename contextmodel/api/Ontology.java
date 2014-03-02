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
		if (entities.containsKey(id)) {
			return entities.get(id);
		} else {
			throw new RuntimeException("Entity " + id + " not found");
		}	
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

	/* how to get rid of the unchecked casts? */
	private <T> T instantiate(final String className, final Class<T> type,
			final String id) throws ClassNotFoundException,
			NoSuchMethodException, SecurityException, InstantiationException,
			IllegalAccessException, IllegalArgumentException,
			InvocationTargetException {
		//	get class type for entity subclass, i.e temperature for entity
		//	couldnt get this to work properly without the unchecked cast
		//Class<? extends T> c = (Class<? extends T>) Class.forName(className);
		// so i have added the following line, which does not solve the problem; just hides it for a brief time...
		Class<?> c = Class.forName(className);
		
		Constructor<?> ctor = c.getConstructor(String.class);
		
		Object o = ctor.newInstance(id);
		
		if (!type.isAssignableFrom(o.getClass())) {
			System.err.println("ERROR:Incompatible types. " + o.getClass() + " is not of type " + type);
		}
			
		return type.cast(ctor.newInstance(id));			
	}
	
	private <T> void createAndStoreOntologyMember(final String className,
			Class<T> T, final String id) throws InstantiationException,
			IllegalAccessException, ClassNotFoundException,
			NoSuchMethodException, SecurityException, IllegalArgumentException,
			InvocationTargetException {
		T t = instantiate(className, T, id);
		store((OntologyObject) t);
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
