package ssafy.com.java;

public class Car {
	static String carName;
	String carColor;
	String maker;
	int speed;
	
	//public Car(){	
	
	//}
	
	void speedUp() {
		speed += 10;
	}

	void speedDown() {
		
		speed -= 10;
		if(speed < 0)
			stop();
	}

	void stop() {
		speed = 0;
	}
	
	public static void main(String[] args) {
		
	}

}

