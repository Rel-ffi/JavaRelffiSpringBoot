package org.springrelffi.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springrelffi.models.Car;
import org.springrelffi.services.CarService;

import java.util.List;

@RestController
public class CarController {
    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/cars")
    public ResponseEntity<List<Car>> getAllCars() {
        return new ResponseEntity<>(carService.getAllCars(), HttpStatus.OK);
    }

    @GetMapping("/cars/{id}")
    public  ResponseEntity<Car> getCarById(@PathVariable String id) {
        return new ResponseEntity<>(carService.getCarById(id), HttpStatus.OK);
    }

    @PostMapping("/cars")
    public ResponseEntity<HttpStatus> addNewCar(@RequestBody Car car) {
        carService.addNewCar(car);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}