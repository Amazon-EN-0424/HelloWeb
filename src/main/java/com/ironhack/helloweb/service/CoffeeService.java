package com.ironhack.helloweb.service;

import com.ironhack.helloweb.model.Coffee;
import com.ironhack.helloweb.repository.CoffeeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class CoffeeService {

    private final CoffeeRepository coffeeRepository;

    public List<Coffee> findAll() {
        log.info("Processing request to find all coffees");
        return coffeeRepository.findAll();
    }

    public Optional<Coffee> findById(Long id) {
        log.info("Processing request to find coffee by {}", id);
        return coffeeRepository.findById(id);
    }

    private List<Coffee> findAllByOrigin(String origin){
        log.info("Processing request to find coffee by origin: {}", origin);
        return coffeeRepository.findAllByOriginIgnoreCase(origin);
    }

    private List<Coffee> findAllByOriginAndName(String origin, String name){
        log.info("Processing request to find coffee by origin: {} and name: {}", origin, name);
        return coffeeRepository.findAllByOriginIgnoreCaseAndNameIgnoreCase(origin, name);
    }


    public List<Coffee> filtersByOriginAndName(String origin, String name) {
        if (name == null) {
            return findAllByOrigin(origin);
        } else {
            return findAllByOriginAndName(origin, name);
        }
    }
//    public List<Coffee> filtersByOriginAndName(String origin, Optional<String> name) {
//        if (name.isEmpty()) {
//            return findAllByOrigin(origin);
//        } else {
//            return findAllByOriginAndName(origin, name.get());
//        }
//    }

}
