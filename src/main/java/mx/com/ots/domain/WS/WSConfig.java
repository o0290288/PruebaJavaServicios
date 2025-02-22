package mx.com.ots.domain.WS;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WSConfig {
    @Bean
    public WebClient webClient() {
        return WebClient.builder().baseUrl("http://gateway.marvel.com/v1/public/characters?ts=1&apikey=b9ee21dd00af3912675a53623f33e923&hash=a11d5b53da9bed8098ee983c2ad8828a").build();
    }
    @Bean
    public WebClient webClientId() {
        return WebClient.builder().baseUrl("http://gateway.marvel.com/v1/public/characters/{characterId}?ts=1&apikey=b9ee21dd00af3912675a53623f33e923&hash=a11d5b53da9bed8098ee983c2ad8828a").build();
    }
}
