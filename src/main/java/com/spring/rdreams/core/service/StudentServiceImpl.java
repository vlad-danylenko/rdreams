package com.spring.rdreams.core.service;

import com.spring.rdreams.core.di.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class StudentServiceImpl implements StudentService {

List<Student> students = new ArrayList<>();
    @PostConstruct
    public void init() {
        Student vlad = Student.builder()
                .id("1")
                .name("Vladyslav")
                .surname("Danylenko")
                .build();
        Student max = Student.builder()
                .id("2")
                .name("Maxim")
                .surname("Panchenko")
                .build();
        Student oleg = Student.builder()
                .id("3")
                .name("Oleg")
                .surname("Kletkin")
                .build();

        students.add(vlad);
        students.add(max);
        students.add(oleg);
    }

    @Override
    public void getStudents() {
        for (int i=0;i<students.size();i++) {
            System.out.println(students.get(i));
        }
    }
}
