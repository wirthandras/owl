package hu.wirthandras.owl.domain.comparator;

import java.util.Comparator;

import hu.wirthandras.owl.domain.Translation;

public class PercentComparator implements Comparator<Translation> {

	@Override
	public int compare(Translation t1, Translation t2) {
		return Integer.compare(t1.getPercent(), t2.getPercent());
	}

}
