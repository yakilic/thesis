public class Main {
	public static void main(String[] args) {
		Aspect A1 = new Aspect("myAspect");
		Entity E = new Entity();

		E.addAspect(A1);
		
		Aspect retAspect = E.getAspect("myAspect");
		
		System.out.println("return aspect is " + retAspect.getId());

	}

}
