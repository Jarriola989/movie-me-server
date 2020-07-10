package MOVIEME.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api")
@CrossOrigin
public class TestController {

    @GetMapping
    public String hello(){
        return "Hello! Movie Me app is running.";
    }
}
