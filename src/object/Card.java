package object;

public class Card {
	int color, form, qty, fill;
	
	public Card(int color, int form, int qty, int fill) {
		this.color = color;
		this.form = form;
		this.qty = qty;
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

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public int getFill() {
		return fill;
	}

	public void setFill(int fill) {
		this.fill = fill;
	}

	@Override
	public String toString() {
		return "Card [color=" + color + ", form=" + form + ", qty=" + qty + ", fill=" + fill + "]";
	}
	
}
