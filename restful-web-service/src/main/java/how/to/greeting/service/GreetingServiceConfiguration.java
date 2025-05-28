package how.to.greeting.service;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@Getter
@Component
public class GreetingServiceConfiguration {

    private AtomicInteger count = new AtomicInteger(1);

    @Value("${greeting.salutation}")
    public String salutation;

    @Value("${greeting.default}")
    public String defaultGreeting;

    public int getId() {
        log.debug("Current ID {}", count.get());
        return count.getAndIncrement();
    }

    public String getNameGreeting(String name) {
        return salutation + ", " + name;
    }
}
