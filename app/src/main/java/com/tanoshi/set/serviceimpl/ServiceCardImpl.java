package com.tanoshi.set.serviceimpl;

import java.util.Random;

import com.tanoshi.set.object.Card;
import com.tanoshi.set.service.ServiceCard;

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
