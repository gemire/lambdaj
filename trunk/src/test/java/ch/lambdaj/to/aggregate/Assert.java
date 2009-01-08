/**
 * // Modified or written by Ex Machina SAGL for inclusion with lambdaj.
 * // Copyright (c) 2008 Mario Fusco, Luca Marrocco.
 * // Licensed under the Apache License, Version 2.0 (the "License")
 */
package ch.lambdaj.to.aggregate;

import static org.junit.Assert.*;

import org.hamcrest.*;

import ch.lambdaj.function.aggregate.*;

/** @author Luca Marrocco */
public class Assert {
	public static final <T extends Number> void assertThatSum(Number op1, T op2, Matcher<T> matcher) {
		Sum summer = new Sum();
		T result = (T) summer.aggregate(op1, op2);
		assertThat(result, matcher);
	}

	public static final <T extends Comparable> void assertThatMin(T op1, T op2, Matcher<T> matcher) {
		Min<T> minFinder = new Min<T>();
		T result = (T) minFinder.choose(op1, op2);
		assertThat(result, matcher);
	}

	public static final <T extends Comparable> void assertThatMax(T op1, T op2, Matcher<T> matcher) {
		Max<T> maxFinder = new Max<T>();
		T result = (T) maxFinder.choose(op1, op2);
		assertThat(result, matcher);
	}

	public static final <T, V> void assertThatConcat(T op1, V op2, Matcher<String> matcher) {
		Concat concatenator = new Concat();
		String result = (String) concatenator.aggregate(op1, op2);
		assertThat(result, matcher);
	}
}