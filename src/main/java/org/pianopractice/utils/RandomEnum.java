package org.pianopractice.utils;


public class RandomEnum<E extends Enum<?>> {

	private final RandomInt random;
	private final E[] values;

	public RandomEnum(Class<E> token) {
		values = token.getEnumConstants();
		random = new RandomInt(0, values.length-1);
	}

	public E random() {
		return values[random.getNextInt()];
	}
}