package test;

import src.AspectAlreadyCreatedException;

public class Main {
	public static void main(String[] args) {
		Temperature t1 = null, t2 = null, t3 = null, t4 = null;
		
		
		try {
			t1 = new Temperature("CpuTemp");
		} catch (AspectAlreadyCreatedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			t2 = new Temperature("CpuTemp");
		} catch (AspectAlreadyCreatedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assert t2 != null : "T2 is expected to be null here, since constructor throws exception";		
		
		try {
			t3 = new Temperature(null);
		} catch (AspectAlreadyCreatedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			t4 = new Temperature(new String());
		} catch (AspectAlreadyCreatedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
}
