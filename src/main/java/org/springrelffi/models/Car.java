package org.springrelffi.models;

import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springrelffi.models.levels.CarViews;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(CarViews.CarLevel1.class)
    private int id;
    @Size(min = 2,message = "Model must contain at least 2 char")
    @Size(max = 20,message = "Model must be 20 char max")
    @NotBlank
    @JsonView({CarViews.CarLevel1.class,CarViews.CarLevel2.class, CarViews.CarLevel3.class})
    private String model;
    @Size(min = 2,message = "Prod of car must contain at least 2 char")
    @Size(max = 14,message = "Prod of car must be 14 char max")
    @NotBlank
    @JsonView({CarViews.CarLevel1.class, CarViews.CarLevel2.class, CarViews.CarLevel3.class})
    private String producer;
    @NotNull
    @Min(value = 100, message = "Power must be greater than 100")
    @Max(value = 300, message = "Power must be less than 300")
    @PositiveOrZero
    @JsonView({CarViews.CarLevel1.class, CarViews.CarLevel2.class})
    private int power;
}
