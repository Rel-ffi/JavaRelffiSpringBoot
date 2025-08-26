package org.springrelffi;

import org.springframework.web.bind.annotation.*;
import org.springrelffi.models.Car;
import org.springrelffi.services.CarService;

import java.util.List;
import java.util.Optional;

@RestController
public class CarController {
    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/cars")
    public List<Car> getAllCars() {
        return carService.getCars();
    }

    @GetMapping("/cars/{id}")
    public Optional<Car> getCarById(@PathVariable int id) {
        return carService.findCarById(id);
    }
    @PostMapping("/cars")
    public void addNewCar(@RequestBody Car car) {
        carService.addNewCar(car);
        System.out.println(carService.getCars()); // checkout
    }
    @DeleteMapping("/cars/{id}")
    public void deleteCar(@PathVariable int id) {
        carService.deleteCar(id);
        System.out.println(carService.getCars()); // checkout
    }
    @GetMapping("/cars/power/{value}")
    public List<Car> findCarWithPower(@PathVariable int value) {
        return carService.findCarsWithPower(value);
    }
    @GetMapping("/cars/producer/{value}")
    public List<Car> findCarWithProducer(@PathVariable String value) {
        return carService.findCarsWithProducer(value);
    }







}
