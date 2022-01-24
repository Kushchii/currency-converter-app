package com.reactive.examples.repository.converter.reader;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.reactive.examples.model.dto.Rates;
import com.reactive.examples.repository.converter.FromJsonConverter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.convert.ReadingConverter;

@Slf4j
@ReadingConverter
public class ActionFromJsonConverter extends FromJsonConverter<Rates> {

    public ActionFromJsonConverter(ObjectMapper objectMapper) {
        super(objectMapper);
    }

    @Override
    public Class<Rates> getSupportedClass() {
        return Rates.class;
    }


}
