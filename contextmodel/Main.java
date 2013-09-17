public class Main {
	public static void main(String[] args) {
		Aspect A1 = new Aspect("myAspect");
		Aspect A2 = new Aspect("mySecondAspect");
		Aspect A3 = new Aspect("myThirdAspect");
		Entity E1 = new Entity("myEntity");
		Entity E2 = new Entity("mySecondEntity");
		Entity E3 = new Entity("myThirdEntity");
		Predicate P1 = new Predicate("myPredicate");
		Predicate P2 = new Predicate("mySecondPredicate");
		Predicate P3 = new Predicate("myPredicate");
		

		E1.addAspect(A1);
		E1.addAspect(A2);
		E1.addAspect(A1);
		E1.addAspect(A3);

		E1.printAllAspects();

		Aspect retAspect = E1.getAspect("myAspect");

		System.out.println("return aspect is " + retAspect.getId());

		E1.removeAspect(A1);

		E1.printAllAspects();

		E1.attachEntity(P1, E2);

		// adding duplicate E1-P1-E2
		E1.attachEntity(P1, E2);

		E1.attachEntity(P2, E2);
		E1.attachEntity(P2, E2);

		E2.attachEntity(P1, E1);
		E2.attachEntity(P2, E2);
		// E2.detachEntity(P1, E2);
		E2.detachEntity(P2, E3);

		E1.printAllEntityRelations();
		E2.printAllEntityRelations();
	}
}
