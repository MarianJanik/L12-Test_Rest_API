package cz.marianjanik.ekurz.lekce12;

import org.springframework.stereotype.Service;

@Service
public class MainService implements MainServiceInterface {

    public String sayHello() {
        return "Jak se máš?";
    }

    @Override
    public String sayHelloWithName(String jmeno) {
        return "Pozdrav " + jmeno;
    }


}
