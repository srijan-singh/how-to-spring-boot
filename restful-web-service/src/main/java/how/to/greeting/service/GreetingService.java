package how.to.greeting.service;

import how.to.greeting.entity.Greeting;

public interface GreetingService {

    Greeting getDefaultGreeting();

    Greeting getGreetingByName(String name);
}
