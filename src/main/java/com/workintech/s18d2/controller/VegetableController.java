package com.workintech.s18d2.controller;

import com.workintech.s18d2.entity.Vegetable;
import com.workintech.s18d2.services.VegetableService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/vegetable")
public class VegetableController {

    private final VegetableService vegetableService;

    @Autowired
    public VegetableController(VegetableService vegetableService) {
        this.vegetableService = vegetableService;
    }

    @GetMapping
    public List<Vegetable> getAll() {
        return vegetableService.getByPriceAsc();
    }

    @GetMapping("/desc")
    public List<Vegetable> getAllDesc() {
        return vegetableService.getByPriceDesc();
    }

    @GetMapping("/{id}")
    public Vegetable getById(@PathVariable Long id) {
        return vegetableService.getById(id);
    }

    @GetMapping("/name/{name}")
    public List<Vegetable> getByName(@PathVariable String name) {
        return vegetableService.searchByName(name);
    }

    @PostMapping
    public Vegetable save(@RequestBody Vegetable vegetable) {
        return vegetableService.save(vegetable);
    }

    @DeleteMapping("/{id}")
    public Vegetable delete(@PathVariable Long id) {
        return vegetableService.delete(id);
    }
}