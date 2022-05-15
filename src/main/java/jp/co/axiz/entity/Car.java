package jp.co.axiz.entity;

public class Car {
	private String carName;
	private String bodyColor;
	private int maxSpeed = 0;
	private int speed = 0;
	
	public Car() {
		
	}
	
	public Car(String carName, String bodyColor, int maxSpeed) throws Exception {
		this.carName = carName;
		this.bodyColor = bodyColor;
		if(maxSpeed < 0) {
			throw new Exception("最高速度に、この値(" + maxSpeed +")をセットすることはできません。");
		}
		this.maxSpeed = maxSpeed;
	}
	
	public Car(String carName, String bodyColor, int maxSpeed, int speed) throws Exception {
		this.carName = carName;
		this.bodyColor = bodyColor;
		if(maxSpeed < 0) {
			throw new Exception("最高速度に、この値(" + maxSpeed +")をセットすることはできません。");
		}
		this.maxSpeed = maxSpeed;
		if(speed < 0 || maxSpeed < speed ) {
			throw new Exception("最高速度に、この値(" + speed +")をセットすることはできません。");
		}
		this.speed = speed;
	}
	
	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public String getBodyColor() {
		return bodyColor;
	}

	public void setBodyColor(String bodyColor) {
		this.bodyColor = bodyColor;
	}

	public int getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
//		if(speed < 0 || maxSpeed < speed) {
//			throw new Exception("現在速度に、この値(" + speed +")をセットすることはできません。");
//		}
		this.speed = speed;
	}
}
