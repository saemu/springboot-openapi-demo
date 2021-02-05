package ch.samuelbrand.springbootopenapidemo;

import ch.samuelbrand.api.HelloApi;
import ch.samuelbrand.model.Greeting;
import ch.samuelbrand.model.Person;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

@Controller
public class HelloController implements HelloApi {

    @Override
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("Hello World");
    }

    @Override
    public ResponseEntity<String> helloName(String name) {
        return ResponseEntity.ok("Hello " + name);
    }

    @Override
    public ResponseEntity<Greeting> helloPost(Person person) {
        final Greeting greeting = new Greeting();
        greeting.setText(String.format("Hello %s %s %s", person.getTitle(), person.getFirstname(), person.getLastname()));
        return ResponseEntity.ok(greeting);
    }
}
