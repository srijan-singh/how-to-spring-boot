package how.to.greeting.service;

import how.to.greeting.entity.Greeting;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class GreetingServiceImplTest {
    private static final String SALUTATION_HELLO = "Hello";
    private static final String DEFAULT_GREETING = "%s, World!".formatted(SALUTATION_HELLO);
    private static final String NAME_1 = "India";
    private static final String NAME_2 = "Bharat";
    private static final String NAME_3 = "Hindustan";

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
        Greeting actualGreeting = greetingService.getGreetingByName(NAME_1);
        // then
        Greeting expectedGreeting = new Greeting(id, getNameGreetingContent(NAME_1));
        // verify
        assertEquals(expectedGreeting, actualGreeting);
    }

    @Test
    void testGreetingByMultipleNames() {
        // when
        List<Greeting> actualGreetings = List.of(
            greetingService.getGreetingByName(NAME_1),
            greetingService.getGreetingByName(NAME_2),
            greetingService.getGreetingByName(NAME_3)
        );
        // then
        List<Greeting> expectedGreetings = new ArrayList<>();
        expectedGreetings.add(new Greeting(id, getNameGreetingContent(NAME_1)));
        updateId();
        expectedGreetings.add(new Greeting(id, getNameGreetingContent(NAME_2)));
        updateId();
        expectedGreetings.add(new Greeting(id, getNameGreetingContent(NAME_3)));
        // verify
        assertEquals(expectedGreetings, actualGreetings);
    }

    private String getNameGreetingContent(String name) {
        return SALUTATION_HELLO + ", " + name;
    }
}
