package com.reactive.examples.config;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.reactive.examples.repository.converter.reader.ActionFromJsonConverter;
import com.reactive.examples.repository.converter.writer.ActionToJsonConverter;
import io.r2dbc.spi.ConnectionFactories;
import io.r2dbc.spi.ConnectionFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration;
import org.springframework.data.r2dbc.convert.R2dbcCustomConversions;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

@RequiredArgsConstructor
@Configuration
@EnableR2dbcRepositories("com.reactive.examples.repository")
public class ReactivePostgresConfig extends AbstractR2dbcConfiguration {

    private final ObjectMapper objectMapper;

    @Override
    public ConnectionFactory connectionFactory() {
        return ConnectionFactories.get("r2dbc:pool:postgresql://postgres:postgres@localhost:5432/test");

    }

    @Bean
    @Override
    public R2dbcCustomConversions r2dbcCustomConversions() {
        List<Converter<?, ?>> converters = new ArrayList<>();
        //reader
        converters.add(new ActionFromJsonConverter(objectMapper));

        //writer
        converters.add(new ActionToJsonConverter(objectMapper));
        return new R2dbcCustomConversions(getStoreConversions(), converters);
    }
}
