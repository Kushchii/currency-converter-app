package com.reactive.examples.repository.converter;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.r2dbc.postgresql.codec.Json;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;

@Slf4j
@RequiredArgsConstructor
public abstract class ToJsonConverter<T> implements Converter<T, Json> {

    private final ObjectMapper objectMapper;

    @Override
    public Json convert(T source) {
        try {
            return Json.of(objectMapper.writeValueAsString(source));
        } catch (IOException e) {
            log.error("Error occurred while serializing map to JSON: {}", source, e);
        }
        return Json.of("");
    }
}
