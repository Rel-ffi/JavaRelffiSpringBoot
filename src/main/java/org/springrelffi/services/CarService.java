package org.springrelffi.services;

import lombok.Getter;
import org.springframework.stereotype.Service;
import org.springrelffi.models.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Getter
public class CarService {

    private final List<Car> cars = new ArrayList<>();

    public CarService() {
        cars.add(new Car(1,"ae-model","toyota",250));
        cars.add(new Car(2,"ar-model","toyota",270));
        cars.add(new Car(3,"ab-model","BMW",210));
        cars.add(new Car(4,"al-model","BMW",240));
        cars.add(new Car(5,"bq-model","BMW",280));
        cars.add(new Car(6,"ba-model","mazda",190));
        cars.add(new Car(7,"bk-model","mazda",230));
    }

    public Optional<Car> findCarById(int id) {
        return cars.stream().filter(car -> car.getId() == id).findFirst();
    }
    // add card in body json
    public void addNewCar(Car car) {
        cars.add(car);
    }

    public void deleteCar(int id) {
        cars.removeIf(car -> car.getId() == id);
    }

    public List<Car> findCarsWithPower(int power) {
        return cars.stream().filter(car -> car.getPower() == power).toList();
    }
    public List<Car> findCarsWithProducer(String producer) {
        return cars.stream().filter(car -> car.getProducer().equals(producer)).toList();
    }
}
