package how.to.greeting.service;

import how.to.greeting.entity.Greeting;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class GreetingServiceImplTest {
    private static final String SALUTATION_HELLO = "Hello";
    private static final String DEFAULT_GREETING = "%s, World!".formatted(SALUTATION_HELLO);
    private static final String NAME = "Srijan";

    private static int id = 1;

    @Autowired
    private GreetingService greetingService;

    @AfterEach
    void updateId() {
        id++;
    }

    @Test
    void testDefaultGreeting() {
        // when
        Greeting actualGreeting = greetingService.getDefaultGreeting();
        // then
        Greeting expectedGreeting = new Greeting(id, DEFAULT_GREETING);
        // verify
        assertEquals(expectedGreeting, actualGreeting);
    }

    @Test
    void testGreetingByName() {
        // when
        Greeting actualGreeting = greetingService.getGreetingByName(NAME);
        // then
        Greeting expectedGreeting = new Greeting(id, getNameGreeting(NAME));
        // verify
        assertEquals(expectedGreeting, actualGreeting);
    }

    private String getNameGreeting(String name) {
        return SALUTATION_HELLO + ", " + name;
    }
}
