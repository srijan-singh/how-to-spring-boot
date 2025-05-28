package how.to.greeting.service;

import how.to.greeting.entity.Greeting;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class GreetingServiceImpl implements GreetingService {

    @Autowired
    private GreetingServiceConfiguration greetingServiceConfiguration;

    @Override
    public Greeting getDefaultGreeting() {
        int id = greetingServiceConfiguration.getId();
        log.debug("Default Greeting: { \"id\": \"{}\", \"content\": \"{}\"}", id,
                greetingServiceConfiguration.getDefaultGreeting());
        return new Greeting(id, greetingServiceConfiguration.getDefaultGreeting());
    }

    @Override
    public Greeting getGreetingByName(String name) {
        int id = greetingServiceConfiguration.getId();
        String greetingName = greetingServiceConfiguration.getNameGreeting(name);
        log.debug("Greeting By Name: { \"id\": \"{}\", \"content\": \"{}\"}", id, greetingName);
        return new Greeting(id, greetingName);
    }
}
