package org.springrelffi.services;

import org.springframework.stereotype.Service;
import org.springrelffi.controllers.CarRepository;
import org.springrelffi.models.Car;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {
    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    public Optional<Car> getCarById(int id) {
        return carRepository.findById(id);
    }

    public Car addNewCar(Car car) {
        return carRepository.save(car);
    }

    public void deleteCar(int id) {
        carRepository.deleteById(id);
    }

    public List<Car> findCarWithPower(int power) {
        return carRepository.getByPower(power);
    }

    public List<Car> findCarWithProducer(String producer) {
        return carRepository.getByProducer(producer);
    }
}
