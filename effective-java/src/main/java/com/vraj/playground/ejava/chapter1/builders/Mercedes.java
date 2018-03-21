package com.vraj.playground.ejava.chapter1.builders;

import java.util.Objects;

public class Mercedes extends Car {

	public enum Color {
		RED, WHITE, BLACK
	};

	private final Color color;

	public static class Builder extends Car.Builder<Builder> {

		private final Color color;

		Builder(Color color) {
			this.color = Objects.requireNonNull(color);
		}

		@Override
		Mercedes build() {
			return new Mercedes(this);
		}

		@Override
		protected Builder self() {
			return this;
		}
	}

	Mercedes(Builder builder) {
		super(builder);
		this.color = builder.color;
	}

	public static void main(String[] args) {
		Car merc = new Mercedes.Builder(Color.RED).addAccessory(CarAccessories.MUSIC_PLAYER).build();
	}
}
