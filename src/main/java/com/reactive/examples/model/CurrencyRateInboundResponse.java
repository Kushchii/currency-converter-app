package com.reactive.examples.model;

import com.reactive.examples.model.dto.Rates;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("currency_rate")
public class CurrencyRateInboundResponse {

    @Id
    private Integer id;

    private Boolean success;

    private Long timestamp;

    private String base;

    private String date;

    private Rates rates;
}
