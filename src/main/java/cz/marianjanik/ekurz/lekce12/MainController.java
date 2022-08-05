package cz.marianjanik.ekurz.lekce12;

import org.springframework.web.bind.annotation.*;

@RestController
public class MainController {

    //Bez Dependency Injection
    //MainService mainService = new MainService();

    //Dependency Injection (field) - na to pozor (možná cylklická závislost)
    //@Autowired
    //MainService mainService;

    //Dependency Injection (construktor) - lepší způsob
    final MainServiceInterface mainService;

    public MainController(MainServiceInterface mainService) {
        this.mainService = mainService;
    }

    @GetMapping(path = "/hello")
    public String hello() {
        return "Pozdrav z Vendryně";
    }

    @GetMapping(path = "/ahoj")
    public String helloService() {
        return mainService.sayHello();
    }

    @GetMapping(path = "/jaksemas")
    public String jaksemasService(@RequestParam String jmeno) {
        return mainService.sayHelloWithName(jmeno);
    }

    @GetMapping(path = "/user/{id}")
    public String getUserById(@PathVariable Long id) {
        return "User " + id;
    }

    @PostMapping(path = "/user")
    public String saveValue(@RequestBody String body) {
        return "User: " + body;
    }
    @GetMapping(path = "/getUser")
    public User getUser() {
        User user = new User("Karel","Novák");
        return user;
    }

}
