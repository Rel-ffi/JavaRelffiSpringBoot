package org.springrelffi;

import org.springframework.web.bind.annotation.*;
import org.springrelffi.models.Car;

import java.util.List;
import java.util.Optional;

@RestController
public class CarController {
    private final CarRepository carRepository;

    public CarController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @GetMapping("/cars")
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    @GetMapping("/cars/{id}")
    public Optional<Car> getCarById(@PathVariable int id) {
        return carRepository.getById(id);
    }
    @PostMapping("/cars")
    public void addNewCar(@RequestBody Car car) {
        carRepository.save(car);
    }
    @DeleteMapping("/cars/{id}")
    public void deleteCar(@PathVariable int id) {
        carRepository.deleteById(id);
    }
    @GetMapping("/cars/power/{value}")
    public List<Car> findCarWithPower(@PathVariable int value) {
        return carRepository.getByPower(value);
    }
    @GetMapping("/cars/producer/{value}")
    public List<Car> findCarWithProducer(@PathVariable String value) {
        return carRepository.getByProducer(value);
    }







}