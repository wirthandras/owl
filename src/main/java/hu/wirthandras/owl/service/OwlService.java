package hu.wirthandras.owl.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import hu.wirthandras.owl.domain.Translation;

@Service
public class OwlService {
	
    @Value("${owl.target.server.url}")
    private String path;

	public Translation[] getTexts() {
		RestTemplate restTemplate = new RestTemplate();
		Translation[] result = restTemplate.getForObject(path, Translation[].class);
		return result;
	}
}
