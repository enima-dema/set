package serviceimpl;

import java.util.Random;

import object.Card;
import service.ServiceCard;

public class ServiceCardImpl implements ServiceCard{

	@Override
	public Card generateCard() {
		int color = new Random().nextInt(3);
		int form = new Random().nextInt(3);
		int qty = new Random().nextInt(3);
		int fill = new Random().nextInt(3);
		
		return new Card(color, form, qty, fill);
	}

}
