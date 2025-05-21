package how.to.greeting.service;

import how.to.greeting.entity.Greeting;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class GreetingServiceImpl implements GreetingService {

    private int count = 1;
    private static final String SALUTATION_HELLO = "Hello";
    private static final String DEFAULT_GREETING = "%s, World!".formatted(SALUTATION_HELLO);

    private void updateId() {
        count = count + 1;
        log.debug("ID has been updated.");
    }

    private int getId() {
        updateId();
        log.debug("Current ID {}", count - 1);
        return count - 1;
    }

    private String getNameGreeting(String name) {
        return SALUTATION_HELLO + ", " + name;
    }

    @Override
    public Greeting getDefaultGreeting() {
        int id = getId();
        log.debug("Default Greeting: { \"id\": \"{}\", \"content\": \"{}\"}", id, DEFAULT_GREETING);
        return new Greeting(id, DEFAULT_GREETING);
    }

    @Override
    public Greeting getGreetingByName(String name) {
        int id = getId();
        String greetingName = getNameGreeting(name);
        log.debug("Greeting By Name: { \"id\": \"{}\", \"content\": \"{}\"}", id, greetingName);
        return new Greeting(id, greetingName);
    }
}
