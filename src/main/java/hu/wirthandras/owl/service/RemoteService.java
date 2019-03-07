package hu.wirthandras.owl.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import hu.wirthandras.owl.domain.Translation;

@Service
public class RemoteService {

	@Value("${owl.target.server.url}")
	private String path;

	private RestTemplate restTemplate = new RestTemplate();

	public Translation[] getTexts() {
		return restTemplate.getForObject(path, Translation[].class);
	}

	RestTemplate getRestTemplate() {
		return restTemplate;
	}

}
