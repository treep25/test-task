package com.task.demo.second_task;

import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
public class Department {

    private final Map<Student, Integer> studentGrades = new HashMap<>();

    public void addStudent(Student student, int grade) {
        studentGrades.entrySet()
                .removeIf
                        (entry -> entry
                                .getKey()
                                .getLastName()
                                .equals(student.getLastName()));

        studentGrades.put(student, grade);
    }

    public void printStudentGrades() {
        studentGrades
                .forEach((student, grade) ->
                        System.out.println(student.print(grade)));
    }

    public static void main(String[] args) {
        Department department = new Department();

        Student student1 = new Student("John", "Wick");
        Student student2 = new Student("Jane", "Wick");

        department.addStudent(student1, 85);
        department.addStudent(student2, 90);

        department.printStudentGrades();
        System.out.println();
        
        Student student3 = new Student("John", "Pretty");
        department.addStudent(student3, 95);

        department.printStudentGrades();
    }
}
