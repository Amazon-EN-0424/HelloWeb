package com.ironhack.helloweb.controller;


import com.ironhack.helloweb.model.Coffee;
import com.ironhack.helloweb.service.CoffeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/coffee")
@RequiredArgsConstructor
public class CoffeeController {

    private final CoffeeService coffeeService;

    //    localhost:8080/coffee
    @GetMapping
    public List<Coffee> getAllCoffees() {
        return coffeeService.findAll();
    }


    //    localhost:8080/coffee/1
    @GetMapping("/{id}")
    public Optional<Coffee> getCoffeeById(@PathVariable("id") Long id) {
        return coffeeService.findById(id);
    }

    //    localhost:8080/coffee/filters?origin=Ethiopia
    @GetMapping("/filters")
    public List<Coffee> getCoffeeFiltered(@RequestParam String origin,
                                          @RequestParam(required = false) String name) {
        return coffeeService.filtersByOriginAndName(origin, name);
    }

//    @GetMapping("/filters")
//    public List<Coffee> getCoffeeFiltered(@RequestParam String origin,
//                                          @RequestParam Optional<String> name) {
//        return coffeeService.filtersByOriginAndName(origin, name);
//    }


}
