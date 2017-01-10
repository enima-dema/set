package com.tanoshi.set.client;

import com.tanoshi.set.object.Board;
import com.tanoshi.set.object.Card;
import com.tanoshi.set.object.Set;
import com.tanoshi.set.service.ServiceBoard;
import com.tanoshi.set.service.ServiceSet;
import com.tanoshi.set.serviceimpl.ServiceBoardImpl;
import com.tanoshi.set.serviceimpl.ServiceSetImpl;

public class TestClient {
	static ServiceSet ss = new ServiceSetImpl();
	static ServiceBoard sb = new ServiceBoardImpl();

	public static void main(String[] args) {
		System.out.println("////////////////////TEST ONE (SET VALIDITY)");
		Card one = new Card(1, 3, 1, 2);
		Card two= new Card(2, 2, 1, 2);
		Card three = new Card(3, 1, 1, 2);
		Set set = new Set(one, two, three);
		System.out.println(ss.isSetValid(set));
		
		System.out.println("////////////////////TEST TWO (BOARD GENERATION)");
		Board first = sb.dispatchCard(12);
		System.out.println(first.toString());
		
		System.out.println("////////////////////TEST THREE (TEST RANDOM VALIDITY)");
		int x =1;
		int y = 2;
		int z = 3;
		System.out.println(sb.getCard(first, x).toString());
		System.out.println(sb.getCard(first, y).toString());
		System.out.println(sb.getCard(first, z).toString());
		Set setThree = new Set (sb.getCard(first, x),sb.getCard(first, y),sb.getCard(first, z));
		System.out.println(ss.isSetValid(setThree));
	}

}
