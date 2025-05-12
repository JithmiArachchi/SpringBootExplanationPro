package com.springProject.spring_boot.ioc_explanation;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/demo")


public class DemoController {

//    @Autowired // object inject
    Car car;

    // recommended way - construction injection
    public DemoController(Car car) {
        this.car = car;
    }

    @GetMapping
    public String getName(){
        return car.start();
    }



}
