package com.vraj.playground.ejava.chapter1.singletons;

import java.io.Serializable;

/**
 * There can only be one and only instance of {@link Rajnikant}
 * 
 * @author vrajori
 *
 */
public class Rajnikant implements Serializable {

	// singleton: method 1
	public final static Rajnikant RAJNI_INSTANCE = new Rajnikant();

	/**
	 * Private CTOR ensure, client class cant invoke it
	 */
	private Rajnikant() {

	}

	// singleton: method 2
	public static Rajnikant getInstance() {
		return RAJNI_INSTANCE;
	}

	/**
	 * XXX note client can still create separate instance of this call
	 * reflectively. To prevent this we need to throw exception upon subsequent
	 * object creation attempts.
	 * 
	 */
	// private Rajnikant() {
	// if (RAJNI_INSTANCE !=null) {
	// throw exception
	// }
	// }

	// Now if we want RAJNI instance thats serializable we need think through
	// it, as serializing and again deserializing can create new instance.

	private Object readResolve() {
		// Maintain one and only instance of thalaiva and let GC tackle with
		// impersonators. :D
		return RAJNI_INSTANCE;
	}
}
