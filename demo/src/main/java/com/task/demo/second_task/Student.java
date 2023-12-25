package com.task.demo.second_task;

import lombok.*;

import java.util.Objects;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
@ToString
public class Student {
    private String name;
    private String lastName;

    public String getFullName() {
        return name + " " + lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name) && Objects.equals(lastName, student.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, lastName);
    }

    public String print(int grade) {
        return getFullName() + ": " + grade;
    }
}
