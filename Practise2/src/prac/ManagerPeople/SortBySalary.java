package prac.ManagerPeople;

import java.util.Comparator;

public class SortBySalary implements Comparator<Engineer> {

	@Override
	public int compare(Engineer o1, Engineer o2) {
		if (o1.getSalary() < o2.getSalary()) {
			return 1;
		} else
			return -1;

	}

}
