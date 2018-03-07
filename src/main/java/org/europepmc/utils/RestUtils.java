package org.europepmc.utils;

import org.springframework.web.client.RestTemplate;

public class RestUtils {
	public static String loadText(String url) {
		RestTemplate restTemplate = new RestTemplate();
		String text = restTemplate.getForObject(url, String.class);
		return text;
	}
}
