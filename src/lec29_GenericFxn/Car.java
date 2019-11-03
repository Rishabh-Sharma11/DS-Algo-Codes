package lec29_GenericFxn;

public class Car implements Comparable<Car>{
	String color;
	int speed;
	int price;
	
	public Car(int speed,int price,String color) {
		this.speed=speed;
		this.price=price;
		this.color=color;
	}
	@Override
	public String toString() {
		return "S: "+this.speed+" P: "+this.price+" C: "+this.color;
	}
	@Override
	public int compareTo(Car other) {
		return this.speed-other.speed;
//		return other.price-this.price;	//actually sorting is ascending only but comparison is based on priority, that's why we get decreasing order
//		return this.color.compareTo(other.color);
	}
	
}
