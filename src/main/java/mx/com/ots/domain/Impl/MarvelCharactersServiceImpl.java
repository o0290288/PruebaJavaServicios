package mx.com.ots.domain.Impl;

import lombok.extern.slf4j.Slf4j;
import mx.com.ots.domain.MarvelCharactersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;


public class MarvelCharactersServiceImpl implements MarvelCharactersService {
    @Autowired
    private WebClient webClient;

    @Autowired
    private WebClient webClientId;

    private final String  CHARACTERURL = "http://gateway.marvel.com/v1/public/characters?ts=1&apikey=b9ee21dd00af3912675a53623f33e923&hash=a11d5b53da9bed8098ee983c2ad8828a";
    private final String CHARACTERIDURL = "http://gateway.marvel.com/v1/public/characters/{characterId}?ts=1&apikey=b9ee21dd00af3912675a53623f33e923&hash=a11d5b53da9bed8098ee983c2ad8828a";

    public String charter() {
        webClient = WebClient.create(CHARACTERURL);
        String response = webClient
                .get()
                .uri(CHARACTERURL)
//                .body(Mono.just(""), String.class)
                .retrieve()
                .bodyToMono(String.class)
                .block();
//        System.out.println(response);
        return response;
    }

    public String charterId(Long id) {
        webClientId = WebClient.create(CHARACTERIDURL);
        String response = webClientId
                .get()
                .uri(CHARACTERIDURL.replaceAll("\\{characterId\\}",id.toString()))
//                .body(Mono.just(""), String.class)
                .retrieve()
                .bodyToMono(String.class)
                .block();
//        System.out.println(response);
        return response;
    }
}
