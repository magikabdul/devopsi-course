package cloud.cholewa.photographs;

import cloud.cholewa.photographs.commons.LocalDateProvider;
import cloud.cholewa.photographs.domain.PhotographsServiceImpl;
import cloud.cholewa.photographs.ports.DateProvider;
import cloud.cholewa.photographs.ports.PhotographsRepository;
import cloud.cholewa.photographs.ports.PhotographsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PhotographsConfiguration {

    @Bean
    public DateProvider createDateProvider() {
        return new LocalDateProvider();
    }

    @Bean
    public PhotographsService createPhotographsService(DateProvider dateProvider, PhotographsRepository photographsRepository) {
        return new PhotographsServiceImpl(dateProvider, photographsRepository);
    }
}
