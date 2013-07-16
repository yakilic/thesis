import java.util.HashMap;

public class Entity {
	private HashMap<String, Aspect> hm;

	public Entity() {
		super();
		hm = new HashMap<String, Aspect>();
	}

	public void addAspect(Aspect A) {
		hm.put(A.getId(), A);

	}

	public Aspect getAspect(String aspectName) {
		return hm.get(aspectName);
	}
}
