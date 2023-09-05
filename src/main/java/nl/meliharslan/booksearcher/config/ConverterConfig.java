package nl.meliharslan.booksearcher.config;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import nl.meliharslan.booksearcher.converters.WsBookResponseToBookListConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.ConverterRegistry;

// Adding manually created converters to the registry so webservice objects can be converted to object this application will use
@Configuration
@RequiredArgsConstructor
public class ConverterConfig {

    private final ConverterRegistry converterRegistry;

    private final WsBookResponseToBookListConverter wsBookResponseToBookListConverter;

    @PostConstruct
    public void registerConverters() {
        converterRegistry.addConverter(wsBookResponseToBookListConverter);
    }
}
