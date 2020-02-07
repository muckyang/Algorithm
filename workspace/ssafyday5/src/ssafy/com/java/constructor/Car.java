package ssafy.com.java.constructor;

/**
 * 이 클래스는 자동차를 객체화 시킨 클래스입니다.<br>
 * 
 * 
 * @author Kim Young Nam

 * */
public class Car {
	/** 자동차의 이름, 색상, 제조사, 속도  */
	private String carName;
	private String carColor;
	public String maker;
	int speed;
	/**
	 * Car클래스의 Default 생성자 입니다.
	 * */
	public Car(){	
		//this. 이 생략된 것이다. 
		carName = "SM5";
		carColor = "흰색";
		maker = "삼성";
		speed = 0;
		//print();
	}
	
	public Car(String carName){	
		this.carName = carName;
		carColor = "흰색";
		maker = "삼성";
		speed = 0;
		//print();
	}	
	public Car(String carName,String carColor){	
		this.carName = carName;
		this.carColor = carColor;
		maker = "삼성";
		speed = 0;
	}
	
	
	
	public Car(String carName, String carColor, String maker) {
		this.carName = carName;
		this.carColor = carColor;
		this.maker = maker;
	}

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public String getCarColor() {
		return carColor;
	}

	public void setCarColor(String carColor) {
		this.carColor = carColor;
	}

	public String getMaker() {
		return maker;
	}

	public void setMaker(String maker) {
		this.maker = maker;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	void speedUp() {
		speed += 10;
		print();
	}
	/**
	 * 자동차의 속도를 증가시키는 메소드.<br>
	 * 증가 시킬 값을 speed의 인자로 넘겨준다 . <br>
	 * @param speed 증가시킬속도
	 * @return 증가시킨 후 자동차의 속도.
	 */
	public int speedUp(int speed) {
		this.speed += speed;
		System.out.println("car1의 속도를 "+  speed + " 가속 !");
		//print();
		return this.speed;
		
	}

	public void speedDown() {
		
		speed -= 10;
		if(speed < 0)
			stop();
		
		//print();
	}

	public int speedDown(int speed) {
		this.speed -= speed;
		if(this.speed < 0) {
			stop();
			//print();
			return this.speed;
		}
		System.out.println("car1의 속도를 "+  speed + " 감속 !");
		//print();
		return this.speed;
		
	}

	
	void print() {
		System.out.println("차이름 : " +  this.carName + "\t차색상 : " + this.carColor + 
				"\t제조사 : " +  this.maker + "\t차속도 : " + this.speed);
	}
	
	public String carInfo() {
		String info = "차이름  : " + this.carName + "\t차색상 : " + this.carColor +
				"\t 제조사 : " + this.maker + "\t 속도 : "+ speed ; 
		return info;
	}
	public void stop() {
		speed = 0;
		System.out.println("차가 멈췄습니다.");
	}


}
