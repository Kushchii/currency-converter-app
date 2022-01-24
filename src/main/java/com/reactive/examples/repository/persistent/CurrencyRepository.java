package com.reactive.examples.repository.persistent;

import com.reactive.examples.model.CurrencyRateInboundResponse;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface CurrencyRepository extends ReactiveCrudRepository<CurrencyRateInboundResponse, Long> {

}
