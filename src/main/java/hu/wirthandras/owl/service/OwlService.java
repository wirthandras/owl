package hu.wirthandras.owl.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import hu.wirthandras.owl.domain.Translation;

@Service
public class OwlService {

	private final String path = "https://silion.herokuapp.com/api/json";

	public Translation[] getTexts() {

		RestTemplate restTemplate = new RestTemplate();
		Translation[] result = restTemplate.getForObject(path, Translation[].class);
		return result;
	}
}
