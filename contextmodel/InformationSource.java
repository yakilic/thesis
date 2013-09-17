public abstract class InformationSource implements ToStandard {
	private SensorData sensorData;
	private String id;

	public SensorData getSensorData() {
		return sensorData;
	}

	public void setSensorData(SensorData sensorData) {
		this.sensorData = sensorData;
	}

	public String getId() {
		return id;
	}
}
