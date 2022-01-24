package com.reactive.examples.repository.converter;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.r2dbc.postgresql.codec.Json;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;

@Slf4j
@RequiredArgsConstructor
public abstract class FromJsonConverter<T> implements Converter<Json, T> {

    private final ObjectMapper objectMapper;

    public abstract Class<T> getSupportedClass();

    @Override
    public T convert(Json json) {
        try {
            return objectMapper.readValue(json.asString(), getSupportedClass());
        } catch (IOException e) {
            log.error("Problem while parsing JSON: {}", json, e);
        }
        return null;
    }
}
