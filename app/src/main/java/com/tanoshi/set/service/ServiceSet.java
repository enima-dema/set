package com.tanoshi.set.service;

import com.tanoshi.set.object.Set;

public interface ServiceSet {

	boolean isSetValid(Set set);
	
	boolean isCombiValid(int one, int two, int three);
}
