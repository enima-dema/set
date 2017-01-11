package com.tanoshi.set.serviceimpl;

import com.tanoshi.set.object.Card;
import com.tanoshi.set.object.CardMin;
import com.tanoshi.set.service.ServiceCard;
import com.tanoshi.set.service.ServiceCardMin;

import java.util.Random;

public class ServiceCardMinImpl implements ServiceCardMin {

	@Override
	public CardMin generateCard() {
		int color = new Random().nextInt(3);
		int form = new Random().nextInt(3);
		int fill = new Random().nextInt(3);
		
		return new CardMin(color, form, fill);
	}

}
