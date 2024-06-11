package com.ironhack.helloweb.demo;

import com.ironhack.helloweb.model.Coffee;
import com.ironhack.helloweb.repository.CoffeeRepository;
import com.ironhack.helloweb.service.CoffeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
@RequiredArgsConstructor
public class CoffeeDataLoader implements CommandLineRunner {

    private final CoffeeRepository coffeeRepository;

    @Override
    public void run(String... args) throws Exception {


        var coffeeList = List.of(
                new Coffee("Black", "Ethiopia", new BigDecimal("2.5")),
                new Coffee("DirtyChai", "Brazil", new BigDecimal("4.5")),
                new Coffee("FlatWhite", "Colombia", new BigDecimal("3.5")),
                new Coffee("Black", "Colombia", new BigDecimal("2.5")),
                new Coffee("FlatWhite", "Brazil", new BigDecimal("4.5"))
        );
        coffeeRepository.saveAll(coffeeList);
    }
}
