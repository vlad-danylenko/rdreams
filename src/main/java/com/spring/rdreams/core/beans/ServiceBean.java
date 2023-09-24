package com.spring.rdreams.core.beans;

import com.spring.rdreams.core.service.StudentService;
import jakarta.annotation.PostConstruct;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeansException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class ServiceBean implements ApplicationContextAware {

    private final StudentService studentService;

    @Autowired
    public ServiceBean(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostConstruct
    public void init() {
        log.info("Get all students");
        studentService.getStudents();
        System.out.println("test");
    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

    }
}
