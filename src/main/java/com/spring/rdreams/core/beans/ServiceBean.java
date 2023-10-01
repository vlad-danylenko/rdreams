package com.spring.rdreams.core.beans;

import com.spring.rdreams.service.StudentService;
import jakarta.annotation.PostConstruct;
import lombok.extern.log4j.Log4j2;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class ServiceBean implements DisposableBean, InitializingBean {

    private final StudentService studentService;

    @Autowired
    public ServiceBean(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostConstruct
    public void init() {
        log.info("Get all students");
        studentService.getStudents();
    }

    @Override
    public void destroy() throws Exception {
        log.info("InitializingBean (afterPropertiesSet) in ServiceBean");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("DisposableBean (destroy) in ServiceBean");
    }
}
