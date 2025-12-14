package com.example.demo.student;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
@RequestMapping(path = "api1/v1/student")
public class StudentController {
    @GetMapping
    public List<student> getStudents(){
        return List.of(
                new student(
                        1L,
                        "Annie",
                        "annie16@gamil.com",
                        LocalDate.of(2000, Month.APRIL,5),
                        25
                )
        );
    }
}
