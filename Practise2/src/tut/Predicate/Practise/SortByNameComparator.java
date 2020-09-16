package tut.Predicate.Practise;

import java.util.Comparator;

public class SortByNameComparator implements Comparator<Person> {

	@Override
	public int compare(Person o1, Person o2) {

		return o1.getName().compareTo(o2.getName()) + o1.getId().compareTo(o2.getId());
	}

}
