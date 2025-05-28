package how.to.greeting.rest;

import how.to.greeting.entity.Greeting;
import how.to.greeting.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    @Autowired
    private GreetingService greetingService;

    @GetMapping(name = "Get Default Greeting", value = "/greeting")
    public Greeting getDefaultGreeting() {
        return greetingService.getDefaultGreeting();
    }

    @GetMapping(name = "Get Greeting By Name", value = "/greeting?name={providedName}")
    public Greeting getGreetingByName(@PathVariable String providedName) {
        return greetingService.getGreetingByName(providedName);
    }
}
