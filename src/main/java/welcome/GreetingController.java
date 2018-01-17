package welcome;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }
    
    @RequestMapping("/greeting/{myName}")
    public Greeting greeting2(@PathVariable String myName) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, myName));
    }
    
 /*   @RequestMapping("/welcome")
    public String welcome(@RequestParam("value =""")) {
    	
    }*/
}
