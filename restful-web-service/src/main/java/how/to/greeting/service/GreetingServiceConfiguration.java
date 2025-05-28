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

    private void updateId() {
        count.addAndGet(1);
        log.debug("ID has been updated.");
    }

    public int getId() {
        updateId();
        log.debug("Current ID {}", count.get() - 1);
        return count.get() - 1;
    }

    public String getNameGreeting(String name) {
        return salutation + ", " + name;
    }
}
