package com.hinner.test.discard;

public class WhitePerson extends Person {

	@Override
	public void sayHi() {
		super.sayHi();
		System.out.println("Hi WhitePerson");
	}

	public WhitePerson() {
		// super();
		System.out.println("WhitePerson");
	}

	public static void main(String[] args) {
		WhitePerson wp = new WhitePerson();
		// wp.sayHi();
	}

}
