package src;

import java.io.Serializable;

import api.AbstractAspect;
import api.AbstractData;

public class Temperature extends AbstractAspect {
	private static final long serialVersionUID = -3317362404221068456L;

	public Temperature(String id) {
		super(id);
	}

	@Override
	public Serializable getDistance(AbstractAspect a, String representation) {
		return new Double(1);
		//return (this.getValue() - a.getValue());
	}

	@Override
	public Serializable validateData(AbstractData sd) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEqual(AbstractAspect A) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Serializable getValue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Serializable getValue(String representationClassName) {
		// TODO Auto-generated method stub
		return 8;
	}

	@Override
	public int compareTo(AbstractAspect arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

}
