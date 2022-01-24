package com.reactive.examples.client;

import com.reactive.examples.model.CurrencyRateInboundResponse;
import com.reactive.examples.model.CurrencyRateRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Slf4j
@RequiredArgsConstructor
@Service
public class CurrencyRateClient {
    private final WebClient client = WebClient.create("http://api.exchangeratesapi.io");


    public Mono<CurrencyRateInboundResponse> getCurrencyRates(CurrencyRateRequest currencyRateRequest) {
        return client.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/v1/latest")
                        .queryParam("access_key", "d22966701ddaa65d57ebda19123cdc6e")
                        .queryParam("symbols", currencyRateRequest.getConvertTo())
                        .build())
                .retrieve().bodyToMono(CurrencyRateInboundResponse.class)
                .log("Created Currency : ");

    }


}
