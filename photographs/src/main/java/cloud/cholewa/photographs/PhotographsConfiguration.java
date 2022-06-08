package cloud.cholewa.photographs;

import cloud.cholewa.photographs.domain.PhotographsServiceImpl;
import cloud.cholewa.photographs.ports.PhotographsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PhotographsConfiguration {

    @Bean
    public PhotographsService createPhotographsService() {
        return new PhotographsServiceImpl();
    }
}
