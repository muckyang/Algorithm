package ssafy.com.java.constructor;


public class Car_2 {
	String carName;
	String carColor;
	String maker;
	int speed;
	
	public Car_2(){	
		//this. 이 생략된 것이다. 
		this("SM5" , "흰색", "삼성");
	}
	
	public Car_2(String carName){
		this(carName , "흰색", "삼성");
	}	
	public Car_2(String carName,String carColor){	
		this(carName , carColor, "삼성");
	}
	
	public Car_2(String carName, String carColor, String maker){
		
		this.carName = carName;
		this.carColor = carColor;
		this.maker = maker;

	}
	
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
