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

	/*
	 * can't get this to work, should do brute force-(separate function for all
	 * types) i guess.. or maybe it will not work... since i need generic
	 * constructor calls for each class type like for entity.class =
	 * temperature, i should call new temperature(id) how??
	 */
	/*
	 * i should also make sure that i instantiate the subclass, not the base
	 * class, i.e temperature instead of entity. if i comment out first two
	 * lines i try to instantiate entity and exception is thrown
	 * sun.reflect.InstantiationExceptionConstructorAccessorImpl
	 * .newInstance(Unknown Source)
	 */
	/* how can i get the sub class type here ? */
	/*
	 * few lines of code... but took me a lot of time, and still can't get my
	 * head around it. Shows that LOC calculation is worth nothing...
	 */
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
		return type.cast(ctor.newInstance(id));  
		/* and of course.. can not cast temperature to entity, this will fail-> classCastException
		 * java.lang.ClassCastException: Cannot cast src.Temperature to api.Entity
		 * I "know" that "T" is a subclass of "type" yet how do i express this to java? 
		 */
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
