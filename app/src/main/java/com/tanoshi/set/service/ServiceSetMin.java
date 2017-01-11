package com.tanoshi.set.service;

import com.tanoshi.set.object.SetMin;

public interface ServiceSetMin {

	boolean isSetValid(SetMin set);
	
	boolean isCombiValid(int one, int two, int three);
}
