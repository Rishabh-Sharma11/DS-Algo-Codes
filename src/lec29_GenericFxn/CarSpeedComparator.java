package lec29_GenericFxn;

import java.util.Comparator;

public class CarSpeedComparator implements Comparator<Car2> {

	@Override
	public int compare(Car2 t, Car2 o) {
		return t.speed - o.speed;
	}

}
