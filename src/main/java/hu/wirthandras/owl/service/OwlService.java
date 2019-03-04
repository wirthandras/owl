package hu.wirthandras.owl.service;

import static java.util.Collections.reverseOrder;
import static java.util.Collections.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.wirthandras.owl.domain.Translation;
import hu.wirthandras.owl.domain.comparator.FrequentComparator;

@Service
public class OwlService {

	private final int ELEMENTS_IN_LIST = 10;
	private final int START_INDEX = 0;

	@Autowired
	private RemoteService remoteService;

	public List<Translation> getBestTen() {
		List<Translation> t = getTranslations();
		sort(t, reverseOrder());
		return t.subList(START_INDEX, ELEMENTS_IN_LIST);
	}

	public List<Translation> getWorstTen() {
		List<Translation> t = getTranslations();
		sort(t);
		return t.subList(START_INDEX, ELEMENTS_IN_LIST);
	}

	public List<Translation> getFrequentTen() {
		List<Translation> t = getTranslations();
		sort(t, reverseOrder(new FrequentComparator()));
		return t.subList(START_INDEX, ELEMENTS_IN_LIST);
	}

	public List<Translation> getRareTen() {
		List<Translation> t = getTranslations();
		sort(t, new FrequentComparator());
		return t.subList(START_INDEX, ELEMENTS_IN_LIST);
	}

	private List<Translation> getTranslations() {
		List<Translation> t = new ArrayList<Translation>(Arrays.asList(remoteService.getTexts()));
		return t;
	}

}
