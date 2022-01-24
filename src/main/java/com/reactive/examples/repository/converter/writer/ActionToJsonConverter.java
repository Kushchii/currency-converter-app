package com.reactive.examples.repository.converter.writer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.reactive.examples.model.dto.Rates;
import com.reactive.examples.repository.converter.ToJsonConverter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.convert.WritingConverter;

@Slf4j
@WritingConverter
public class ActionToJsonConverter extends ToJsonConverter<Rates> {

    public ActionToJsonConverter(ObjectMapper objectMapper) {
        super(objectMapper);
    }

}
