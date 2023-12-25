package com.task.demo.first_task.driver.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
@EqualsAndHashCode
@ToString
public class DriverDto {
    @NotBlank(message = "Name of driver is required")
    private String name;
    @Min(value = 18, message = "Age should be more then 17")
    private int age;
}
