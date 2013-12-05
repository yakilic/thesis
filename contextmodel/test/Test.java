package test;

public class Test {
	public static void main(String[] args) {
		
		Temperature t1 = null, t2 = null, t3 = null, t4 = null;
		
		t1 = new Temperature("CpuTemp");
		
		t2 = new Temperature("CpuTemp");
		
	//	assert t2 != null : "T2 is expected to be null here, since constructor throws exception";		
		
		t3 = new Temperature(null);
		
		t4 = new Temperature(new String());
		
	}
}
