package org.springrelffi.controllers;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springrelffi.models.Car;

@Repository
public interface CarRepository extends MongoRepository<Car, String> {

}