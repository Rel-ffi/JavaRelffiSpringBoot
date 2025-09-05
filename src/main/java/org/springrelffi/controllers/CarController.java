package org.springrelffi.controllers;

import com.fasterxml.jackson.annotation.JsonView;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springrelffi.models.Car;
import org.springrelffi.models.levels.CarViews;
import org.springrelffi.services.CarService;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class CarController {
    private final CarService carService;

    @JsonView(CarViews.CarLevel3.class)
    @GetMapping("/cars")
    public ResponseEntity<List<Car>> getAllCars() {
        return new ResponseEntity<>(carService.getAllCars(), HttpStatus.OK);
    }

    @JsonView(CarViews.CarLevel1.class)
    @GetMapping("/cars/{id}")
    public  ResponseEntity<Optional<Car>> getCarById(@PathVariable int id) {
        return new ResponseEntity<>(carService.getCarById(id), HttpStatus.OK);
    }

    @PostMapping("/cars")
    public ResponseEntity<HttpStatus> addNewCar(@ModelAttribute @Valid Car car,
        @RequestParam("image") MultipartFile file) {
        carService.addNewCar(car, file);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/cars/{id}")
    public ResponseEntity<HttpStatus> deleteCar(@PathVariable int id) {
        carService.deleteCar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @JsonView(CarViews.CarLevel2.class)
    @GetMapping("/cars/power/{value}")
    public  ResponseEntity<List<Car>> findCarWithPower(@PathVariable int value) {
        return new ResponseEntity<>(carService.findCarWithPower(value), HttpStatus.OK);
    }

    @JsonView(CarViews.CarLevel2.class)
    @GetMapping("/cars/producer/{value}")
    public ResponseEntity<List<Car>> findCarWithProducer(@PathVariable String value) {
        return new ResponseEntity<>(carService.findCarWithProducer(value), HttpStatus.OK);
    }

}