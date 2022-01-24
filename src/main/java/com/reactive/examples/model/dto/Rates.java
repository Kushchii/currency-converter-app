package com.reactive.examples.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Rates {

    @JsonProperty("UAH")
    private Double UAH;

    @JsonProperty("USD")
    private Double USD;

    @JsonProperty("RUB")
    private Double RUB;

    @JsonProperty("INR")
    private Double INR;

}
