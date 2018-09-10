package hu.wirthandras.owl.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import hu.wirthandras.owl.domain.Translation;

@Service
public class OwlService {
	
	private final int ELEMENTS_IN_LIST = 10;
	
    @Value("${owl.target.server.url}")
    private String path;

	public Translation[] getTexts() {
		RestTemplate restTemplate = new RestTemplate();
		Translation[] result = restTemplate.getForObject(path, Translation[].class);
		return result;
	}
	
	public List<Translation> getBestTen() {
		List<Translation> t = new ArrayList<Translation>(Arrays.asList(getTexts()));
		Collections.sort(t, Collections.reverseOrder());
		return t.subList(0, ELEMENTS_IN_LIST);
	}
	
	public List<Translation> getWorstTen() {
		List<Translation> t = new ArrayList<Translation>(Arrays.asList(getTexts()));
		Collections.sort(t);
		return t.subList(0, ELEMENTS_IN_LIST);
	}
	
}
