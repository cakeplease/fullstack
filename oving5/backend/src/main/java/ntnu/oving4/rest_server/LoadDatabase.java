package ntnu.oving4.rest_server;

import ntnu.oving4.rest_server.model.User;
import ntnu.oving4.rest_server.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(UserRepository repository) {
        return args -> {
            log.info("Preloading " + repository.save(new User("Bilbo Baggins", "burglar123")));
            log.info("Preloading " + repository.save(new User("Frodo Baggins", "thief123")));
        };
    }
}