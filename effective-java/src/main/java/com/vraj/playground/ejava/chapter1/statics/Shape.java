package com.vraj.playground.ejava.chapter1.statics;

public class Shape {
	
	public Square getSquare() {
		return new Square();
	}
	
	private class Square {
		
	}
}
