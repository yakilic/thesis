package test;

import src.Aspect;
import src.SensorData;

public class Temperature extends Aspect {
	
	public Temperature(String id) {
		super(id);
	}
	

	@Override
	public Object getDistance(Aspect A) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean validateData(SensorData sd) {
		// TODO Auto-generated method stub
		return false;
	}

}
