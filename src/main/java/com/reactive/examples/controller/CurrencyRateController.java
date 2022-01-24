package com.reactive.examples.controller;

import com.reactive.examples.client.CurrencyRateClient;
import com.reactive.examples.model.CurrencyRateInboundResponse;
import com.reactive.examples.model.CurrencyRateRequest;
import com.reactive.examples.repository.persistent.CurrencyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/currency/rates")
@RequiredArgsConstructor
public class CurrencyRateController {

    private final CurrencyRateClient currencyClient;

    private final CurrencyRepository currencyRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<CurrencyRateInboundResponse> create(@RequestBody CurrencyRateRequest currencyRateRequest) {
        return currencyClient.getCurrencyRates(currencyRateRequest)
                .flatMap(currencyRepository::save);
    }


}
