package org.springrelffi.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springrelffi.controllers.CarRepository;
import org.springrelffi.models.Car;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CarService {
    private final CarRepository carRepository;
    private final MailService mailService;


    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    public Optional<Car> getCarById(int id) {
        return carRepository.findById(id);
    }

    public void addNewCar(Car car, MultipartFile file) {
        String path = System.getProperty("user.home");
        try {
            Files.createDirectories(Path.of(path,"ImagesRelffi"));
            Path imagesRelffi = Path.of(path, "ImagesRelffi", file.getOriginalFilename());
            file.transferTo(imagesRelffi);
            car.setFile(file.getOriginalFilename());


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        carRepository.save(car);
        mailService.sendEmail("e36884722@gmail.com",
                "Added new car to database",
                car.toString());

    }

    public void deleteCar(int id) {
        Car car = carRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Car not found :(  : " + id));
       // сюди вже можна впихнути видалення фото из папки user.home/ImagesRelffi/
        // але сенсу немає, тому-що табличка в бд перестворюється заново.
        //у випадку якщо все ж таки потрібно реалізувати це, дайте мені знайти в тг.

        carRepository.deleteById(car.getId());
        mailService.sendEmail("e36884722@gmail.com","Deleted car from database", car.toString());
    }

    public List<Car> findCarWithPower(int power) {
        return carRepository.getByPower(power);
    }

    public List<Car> findCarWithProducer(String producer) {
        return carRepository.getByProducer(producer);
    }




}

