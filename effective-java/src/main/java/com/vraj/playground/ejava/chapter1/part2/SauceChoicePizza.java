package com.vraj.playground.ejava.chapter1.part2;

import java.util.Objects;

public class SauceChoicePizza extends Pizza {

	public enum SauceOption {
		IN, OUT
	};

	private final SauceOption sauceOption;

	public static class Builder extends Pizza.Builder<Builder> {

		private final SauceOption sauceOption;

		Builder(SauceOption sauceOption) {
			this.sauceOption = Objects.requireNonNull(sauceOption);
		}

		@Override
		SauceChoicePizza build() {
			return new SauceChoicePizza(this);
		}

		@Override
		protected Builder self() {
			return this;
		}

	}

	SauceChoicePizza(Builder builder) {
		super(builder);
		this.sauceOption = builder.sauceOption;
	}
}
