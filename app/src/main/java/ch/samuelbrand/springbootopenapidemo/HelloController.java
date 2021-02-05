package ch.samuelbrand.springbootopenapidemo;

import ch.samuelbrand.api.HelloApi;
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
}
