package org.springrelffi.services;

import org.springframework.stereotype.Service;
import org.springrelffi.controllers.CarRepository;
import org.springrelffi.models.Car;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CarService {
    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    public Car getCarById(String id) {
        return carRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException(id));

    }

    public void addNewCar(Car car) {
        carRepository.save(car);
    }

}
