package serviceimpl;

import object.Card;
import object.Set;
import service.ServiceSet;

public class ServiceSetImpl implements ServiceSet {

	@Override
	public boolean isSetValid(Set set) {
		Card one = set.getOne();
		Card two = set.getTwo();
		Card three = set.getThree();
		if (!isCombiValid(one.getColor(), two.getColor(), three.getColor())){
			return false;
		}
		if (!isCombiValid(one.getForm(), two.getForm(), three.getForm())){
			return false;
		}
		if (!isCombiValid(one.getQty(), two.getQty(), three.getQty())){
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
