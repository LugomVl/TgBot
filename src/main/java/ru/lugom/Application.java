package ru.lugom;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.RestController;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import ru.lugom.model.City;
import ru.lugom.repository.CityRepository;

import javax.annotation.PostConstruct;


@RestController
@SpringBootApplication
@EnableJpaRepositories
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @PostConstruct
    public void init() {
        ApiContextInitializer.init();
    }

    @Bean
    public TelegramBotsApi telegramBotsApi() {
        return new TelegramBotsApi();
    }

    @Bean
    CommandLineRunner init(CityRepository cityRepository) {
        return args -> {
            if (!cityRepository.findByName("Minsk").isPresent() &&
                    !cityRepository.findByName("Moscow").isPresent() &&
                    !cityRepository.findByName("Washington").isPresent() &&
                    !cityRepository.findByName("Kiev").isPresent()) {
                cityRepository.save(new City(1, "Minsk", "The capital of Belarus"));
                cityRepository.save(new City(2, "Moscow", "The capital of Russia"));
                cityRepository.save(new City(3, "Washington", "The capital of USA"));
                cityRepository.save(new City(4, "Kiev", "The capital of Ukraine"));
            }
        };
    }
}
