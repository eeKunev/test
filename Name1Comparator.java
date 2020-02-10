package fmi.informatics.comparators;

import fmi.informatics.extending.Person;

public class Name1Comparator extends PersonComparator {

	@Override
	public int compare(Person person1, Person person2) {
		if (person2.getName().equals(person1.getName())) {
			return 0;
		} else {
			return (person2.getName().compareTo(person1.getName()) * sortOrder);
		}
	}
}

