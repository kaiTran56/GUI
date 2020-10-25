package com.team.main;
import java.util.ArrayList;
import java.util.Iterator;

public class PrimeList {
	ArrayList<Integer> sc;

	public Iterator<Integer> Iterator() {
		return new MyGen();
	}

	public PrimeList() {
		sc = new ArrayList<Integer>();
	}

	private class MyGen implements Iterator {
		private int index;

		public MyGen() {
			index = 0;
			sc.add(2);
			sc.add(3);
			sc.add(5);
			sc.add(7);
			sc.add(11);
			sc.add(13);
			sc.add(17);
			sc.add(19);
			sc.add(23);
			sc.add(29);

		}
		
		

		public boolean hasNext() {
			// TODO Auto-generated method stub
			return index < 10;
		}

		/* 
		 * return the next element in Iteration 
		 * 
		 */
		
		@Override
		public Object next() {
			// TODO Auto-generated method stub
			if (hasNext()) {
				return sc.get(index++);
			}
			return -1;
		}

	}
}