package lec29_GenericFxn;

import java.util.Comparator;

public class IntegerComparator implements Comparator<Integer>{
	//compare of Integer class compares marks wise, so we need to create it ourselves
	@Override
	public int compare(Integer o1, Integer o2) {
		return o2-o1;		//comparing rank wise
	}

}
