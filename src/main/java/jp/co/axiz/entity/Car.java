package jp.co.axiz.entity;

public class Car {
	private String carName;
	private String bodyColor;
	private int maxSpeed = 0;
	private int speed = 0;
	
	public Car() {
		
	}
	
	public Car(String carName, String bodyColor, int maxSpeed) {
		this.carName = carName;
		this.bodyColor = bodyColor;
		this.maxSpeed = maxSpeed;
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
		this.speed = speed;
	}

	public Car(String carName, String bodyColor, int maxSpeed, int speed) {
		this.carName = carName;
		this.bodyColor = bodyColor;
		this.maxSpeed = maxSpeed;
		this.speed = speed;
	}
}
