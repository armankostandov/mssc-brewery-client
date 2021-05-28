package ru.foreverjun.msscbreweryclient.web.client;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.foreverjun.msscbreweryclient.web.model.BeerDto;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BreweryClientTest {

    @Autowired
    BreweryClient client;

    @Test
    void getBeerById() {
        BeerDto dto = client.getBeerById(UUID.randomUUID());

        assertNotNull(dto);
    }

    @Test
    void saveNewBeer() {
        // given
        BeerDto dto = BeerDto.builder()
                .beerName("New Beer")
                .beerStyle("Lager")
                .build();

        URI uri = client.saveNewBeer(dto);

        assertNotNull(uri);
        System.out.println(uri.toString());
    }

    @Test
    void updateBeer() {
        // given
        BeerDto dto = BeerDto.builder()
                .beerName("New Beer")
                .beerStyle("Lager")
                .build();

        client.updateBeer(UUID.randomUUID(), dto);
    }

    @Test
    void deleteBeer() {
        client.deleteBeer(UUID.randomUUID());
    }
}