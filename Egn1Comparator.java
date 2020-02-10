package fmi.informatics.comparators;

import fmi.informatics.extending.Person;

public class Egn1Comparator extends PersonComparator {

	@Override
	public int compare(Person person1, Person person2) {
		Integer egn1 = Integer.valueOf(person1.getEgn());
		Integer egn2 = Integer.valueOf(person2.getEgn());
		
		if (egn2.equals(egn1)) {
			return 0;
		} else {
			return (egn2.compareTo(egn1)) * sortOrder;
		}
	}
}
