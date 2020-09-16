package prac.Learn_Predicate;

import java.util.function.Predicate;

public class Main1 {
	public static void main(String[] args) {
		Predicate<String> predicateString = s -> {
			return s.equals("hello");
		};
		System.out.println("Compare: " + predicateString.test("hello"));
		System.out.println("Compare1: " + predicateString.test("hello_Kai"));
		/*
		 * Use: and(); or(); isEquals(); negate()
		 */
		Predicate<String> predicate = s -> {
			return s.equals("hello Kai");
		};

		// and()
		Predicate<String> predicateAnd = predicate.and(s -> s.length() >= 11);
		System.out.println("\nand() : " + predicateAnd.test("hello Kai, Quyet"));

		// or()
		Predicate<String> predicateOr = predicate.or(s -> s.length() == 11);
		System.out.println("or() : " + predicateOr.test("hello Kai,Quyet"));

		// negate()
		Predicate<String> predicateNegate = predicate.negate();
		System.out.println("negate() : " + predicateNegate.test("Hello Kai,Quyet"));
	}
}
