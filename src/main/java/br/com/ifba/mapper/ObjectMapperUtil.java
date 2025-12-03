package br.com.ifba.mapper;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.config.Configuration;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

// -- ObjectMapperUtil: componente que encapsula o uso do ModelMapper
@Component
public class ObjectMapperUtil {

    private static final ModelMapper MODEL_MAPPER;

    static {
      MODEL_MAPPER = new ModelMapper();
    }

    public <Input, Output> Output map(final Input object, final Class<Output> clazz){
        MODEL_MAPPER.getConfiguration().setAmbiguityIgnored(true)
                .setMatchingStrategy(MatchingStrategies.STRICT)
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);

        Output c = MODEL_MAPPER.map(object, clazz);
        return c;
    }

    // converte uma lista de entidades para uma lista de DTOs
    public <Input, Output> List<Output> mapAll(final List<Input> source, final Class<Output> targetClass) {
        return source.stream()
                .map(element -> MODEL_MAPPER.map(element, targetClass))
                .collect(Collectors.toList());
    }
}
