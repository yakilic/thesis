package test;

import java.lang.reflect.InvocationTargetException;

import src.Temperature;
import api.AbstractAspect;
import api.AbstractEntity;
import api.Ontology;

public class Test {
	public static void test1() {
		Temperature t1 = null, t2 = null, t3 = null, t4 = null;
		t1 = new Temperature("CpuTemp");
		t2 = new Temperature("CpuTemp");
		// assert t2 != null :
		// "T2 is expected to be null here, since constructor throws exception";
		t3 = new Temperature(null);
		t4 = new Temperature(new String());
	}

	public static void test2() {
		Ontology o = new Ontology("myOnto");
/*
		try {
			o.createOntologyObject("src.Temperature", AbstractEntity.class, "Temp1");
		} catch (Exception e) {
			e.printStackTrace();
		}
		*/
		
		try {
			o.createOntologyObject("src.Temperature", AbstractAspect.class, "Temp1");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	//System.out.println(o.getEntity("Temp1").getId());
		
	//System.out.println(o.getEntity("Temp1").getId());
		
	}

	public static void main(String[] args) {
		// test1();
		test2();
	}
}