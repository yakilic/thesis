package api;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Ontology {
	private String id;

	// TODO: Shall be replaced with persistence manager
	private HashMap<String, AbstractEntity> entities = new HashMap<String, AbstractEntity>();
	private HashMap<String, AbstractAspect> aspects = new HashMap<String, AbstractAspect>();

	public Ontology(String id) {
		this.id = id;
	}

	public AbstractEntity getEntity(String id) {
		if (entities.containsKey(id)) {
			return entities.get(id);
		} else {
			throw new RuntimeException("Entity " + id + " not found");
		}
	}

	private void store(OntologyObject oo) {
		// TODO, stub
	}

	private void storeEntity(AbstractEntity e) {
		if (entities.containsKey(e.getId())) {
			throw new AssertionError("Entity already present in ontology");
		}

		entities.put(e.getId(), e);
	}

	private void storeAspect(AbstractAspect a) {
		if (aspects.containsKey(a.getId())) {
			throw new AssertionError("Aspect already present in ontology");
		}

		aspects.put(a.getId(), a);
	}

	private <T> T instantiateOntologyObject(final String className,
			final Class<T> type, final String id) throws Exception {
		Class<?> c = Class.forName(className);

		Constructor<?> ctor = c.getConstructor(String.class);

		Object o = ctor.newInstance(id);

		if (!type.isAssignableFrom(o.getClass())) {
			System.err.println("ERROR:Incompatible types. " + o.getClass()
					+ " is not of type " + type);
		}

		return type.cast(ctor.newInstance(id));
	}

	public OntologyObject createOntologyObject(String className,
			final Class<? extends OntologyObject> type, final String id)
			throws Exception {
		OntologyObject oo = instantiateOntologyObject(className, type, id);
		return oo;
	}
}
