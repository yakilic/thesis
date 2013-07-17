public class Main {
	public static void main(String[] args) {
		Aspect A1 = new Aspect("myAspect");
		Aspect A2 = new Aspect("mySecondAspect");
		Entity E = new Entity("myEntity");

		E.addAspect(A1);
		E.addAspect(A2);
		
		E.printAllAspects();
		
		Aspect retAspect = E.getAspect("myAspect");
		
		System.out.println("return aspect is " + retAspect.getId());
		
		E.removeAspect(A1);
		
		

	}

}
