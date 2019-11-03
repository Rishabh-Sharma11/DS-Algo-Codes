package lec29_GenericFxn;

public class Car2 {
	String color;
	int speed;
	int price;
	
	public Car2(int speed,int price,String color) {
		this.speed=speed;
		this.price=price;
		this.color=color;
	}
	@Override
	public String toString() {
		return "S: "+this.speed+" P: "+this.price+" C: "+this.color;
	}
}
