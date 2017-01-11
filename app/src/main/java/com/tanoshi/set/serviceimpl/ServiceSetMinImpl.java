package com.tanoshi.set.serviceimpl;

import com.tanoshi.set.object.Card;
import com.tanoshi.set.object.CardMin;
import com.tanoshi.set.object.Set;
import com.tanoshi.set.object.SetMin;
import com.tanoshi.set.service.ServiceSet;
import com.tanoshi.set.service.ServiceSetMin;

public class ServiceSetMinImpl implements ServiceSetMin {

	@Override
	public boolean isSetValid(SetMin set) {
		CardMin one = set.getOne();
		CardMin two = set.getTwo();
		CardMin three = set.getThree();
		if (!isCombiValid(one.getColor(), two.getColor(), three.getColor())){
			return false;
		}
		if (!isCombiValid(one.getForm(), two.getForm(), three.getForm())){
			return false;
		}
		if (!isCombiValid(one.getFill(), two.getFill(), three.getFill())){
			return false;
		}
		return true;
	}

	@Override
	public boolean isCombiValid(int one, int two, int three) {
		if ((one != two && two!=three && three!=one)||(one == two && two == three)){
			return true;
		}
		return false;
	}
}
