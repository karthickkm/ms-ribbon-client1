package com.msribbonclient1.msribbonclient1.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RibbonClient(name = "say-hello", configuration = SayHelloConfiguration.class)
public class UserApplication {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/hi")
    public String hi(@RequestParam(value="name", defaultValue="Artaban") String name) {
        String greeting = this.restTemplate.getForObject("http://say-hello/greeting", String.class);
        return String.format("%s, %s!", greeting, name);
    }

}
