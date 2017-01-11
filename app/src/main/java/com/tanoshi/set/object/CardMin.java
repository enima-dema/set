package com.tanoshi.set.object;

public class CardMin {
	int color, form, fill;

	public CardMin(int color, int form, int fill) {
		this.color = color;
		this.form = form;
		this.fill = fill;
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

	public int getForm() {
		return form;
	}

	public void setForm(int form) {
		this.form = form;
	}

	public int getFill() {
		return fill;
	}

	public void setFill(int fill) {
		this.fill = fill;
	}

	@Override
	public String toString() {
		return "Card [color=" + color + ", form=" + form  + ", fill=" + fill + "]";
	}
	
}
