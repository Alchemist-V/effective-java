package com.vraj.playground.ejava.chapter1.part2;

import java.util.Objects;

/**
 * Now say we need a concrete subclass of {@link Pizza}, which needs a size
 * parameter.
 * 
 * @author vrajori
 *
 */
public class SizeBasedPizza extends Pizza {

	public enum Size {
		SMALL, MEDIUM, LARGE
	}

	private final Size size;

	public static class Builder extends Pizza.Builder<Builder> {

		private final Size size;

		Builder(Size size) {
			this.size = Objects.requireNonNull(size);
		}

		@Override
		SizeBasedPizza build() {
			return new SizeBasedPizza(this);
		}

		@Override
		protected Builder self() {
			return this;
		}

	}

	SizeBasedPizza(Builder builder) {
		super(builder);
		this.size = builder.size;
	}
}








