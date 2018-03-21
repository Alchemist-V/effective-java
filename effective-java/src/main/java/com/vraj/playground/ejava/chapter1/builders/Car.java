package com.vraj.playground.ejava.chapter1.builders;

import java.util.EnumSet;
import java.util.Set;

public abstract class Car {

	public enum CarAccessories {
		MUSIC_PLAYER, CLOCK, NAVIGATION_SYSTEM, CENTRAL_LOCKING
	};

	private final Set<CarAccessories> accessories;

	public abstract static class Builder<T extends Builder<T>> {
		EnumSet<CarAccessories> accessories;

		public T addAccessory(CarAccessories accessory) {
			this.accessories.add(accessory);
			return self();
		}

		protected abstract T self();

		abstract Car build();
	}

	Car(Builder<?> builder) {
		this.accessories = builder.accessories.clone();
	}
}
