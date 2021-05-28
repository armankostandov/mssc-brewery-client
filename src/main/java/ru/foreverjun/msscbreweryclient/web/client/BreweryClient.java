package ru.foreverjun.msscbreweryclient.web.client;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import ru.foreverjun.msscbreweryclient.web.model.BeerDto;

import java.util.UUID;

@Component
@ConfigurationProperties(prefix = "ru.foreverjun.brewery", ignoreUnknownFields = false)
public class BreweryClient {

    public final String BEER_PATH_V1 = "/api/v1/beer/";
    private String apihost;

    private final RestTemplate restTemplate;

    public BreweryClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public BeerDto getBeerById(UUID id) {
        return restTemplate.getForObject(apihost + BEER_PATH_V1 + id, BeerDto.class);
    }

    public void setApihost(String apihost) {
        this.apihost = apihost;
    }
}
