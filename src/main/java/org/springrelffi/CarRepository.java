package org.springrelffi;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springrelffi.models.Car;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {
    Optional<Car> getById(int id);

    List<Car> getByPower(int power);

    List<Car> getByProducer(String producer);
}
