package com.task.demo.first_task.driver.model;

import lombok.*;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
@EqualsAndHashCode
@ToString
public class DriverRequestForUpdate {
    private String name;
    private int age;
}
