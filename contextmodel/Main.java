public class Main {
	public static void main(String[] args) {
		Aspect A1 = new Aspect("myAspect");
		Aspect A2 = new Aspect("mySecondAspect");
		Entity E1 = new Entity("myEntity");
		Entity E2 = new Entity("mySecondEntity");

		E1.addAspect(A1);
		E1.addAspect(A2);
		
		E1.printAllAspects();
		
		Aspect retAspect = E1.getAspect("myAspect");
		
		System.out.println("return aspect is " + retAspect.getId());
		
		E1.removeAspect(A1);
		
		E1.attachEntity(new Predicate("myPredicate"), E2);
		
		
		
		

	}

}
