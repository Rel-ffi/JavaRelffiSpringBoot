package org.springrelffi.services;

import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springrelffi.controllers.CarRepository;

@Service
@AllArgsConstructor
public class DbScheduledService {
    private final CarRepository carRepository;

    @Scheduled(fixedDelay = 10000)
    public void deleteNotValidCarPower() {
        carRepository.deleteAll(carRepository.findAll()
                .stream().filter(car -> car.getPower() < 100)
                .toList());
    }
}
