package test;

import java.io.Serializable;

import src.Aspect;
import src.Data;

public class Temperature extends Aspect {
	private static final long serialVersionUID = -3317362404221068456L;

	public Temperature(String id) {
		super(id);
	}
	

	@Override
	public Serializable getDistance(Aspect a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Serializable validateData(Data sd) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean isEqual(Aspect A) {
		// TODO Auto-generated method stub
		return false;
	}

}
