package g6.challlenge.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GutendexService {

    private final RestTemplate restTemplate;

    public GutendexService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String searchBooksByTitle(String title) {
        String url = "http://gutendex.com/books?search=" + title;
        return restTemplate.getForObject(url, String.class);
    }

    public String searchBooksByAuthor(String author) {
        String url = "http://gutendex.com/books?search=" + author;
        return restTemplate.getForObject(url, String.class);
    }
}
