package org.pianopractice.utils;

import java.util.Random;

public class RandomInt {

	private Random random = new Random();
	private int previousInt;

	private int min;
	private int max;

	public RandomInt(int min, int max) {
		super();
		this.min = min;
		this.max = max;
	}

	public int getNextInt() {
		if( min == max) return min;
		int index;
		do {
			index = min + random.nextInt(max-min+1);
		} while (index == previousInt);
		previousInt = index;
		return index;
	}
}
