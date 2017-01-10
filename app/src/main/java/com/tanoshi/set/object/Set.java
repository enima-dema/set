package com.tanoshi.set.object;

public class Set {
	Card one, two, three;

	public Set(Card one, Card two, Card three) {
		super();
		this.one = one;
		this.two = two;
		this.three = three;
	}

	public Card getOne() {
		return one;
	}

	public void setOne(Card one) {
		this.one = one;
	}

	public Card getTwo() {
		return two;
	}

	public void setTwo(Card two) {
		this.two = two;
	}

	public Card getThree() {
		return three;
	}

	public void setThree(Card three) {
		this.three = three;
	}
	
	
}
