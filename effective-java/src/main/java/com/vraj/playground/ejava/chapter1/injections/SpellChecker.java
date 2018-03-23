package com.vraj.playground.ejava.chapter1.injections;

import java.util.function.Supplier;

public class SpellChecker {

	private final Dictionary dictionary;

	public SpellChecker(Dictionary dictionary) {
		this.dictionary = dictionary;
	}

	public SpellChecker(Supplier<? extends Dictionary> supplier) {
		this.dictionary = supplier.get();
	}

	public boolean isValid(String word) {
		try {
			this.dictionary.lookup(word);
			return true;
		} catch (Exception ex) {
			return false;
		}

	}

	public static void main(String[] args) {
		Dictionary d = new EnglishDictionary();

		SpellChecker sc = new SpellChecker(d);
		sc.isValid("Vikas");
	}

}
