package hu.wirthandras.owl.domain.comparator;

import java.util.Comparator;

import hu.wirthandras.owl.domain.Translation;

public class FrequentComparator implements Comparator<Translation> {

	@Override
	public int compare(Translation o1, Translation o2) {
		return Integer.compare(o1.getOccurences(), o2.getOccurences());
	}

}
