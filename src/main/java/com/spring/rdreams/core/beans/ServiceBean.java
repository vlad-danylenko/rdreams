package com.spring.rdreams.core.beans;

import lombok.extern.log4j.Log4j2;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class ServiceBean implements DisposableBean, InitializingBean {

    @Override
    public void destroy() throws Exception {
        log.info("InitializingBean (afterPropertiesSet) in ServiceBean");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("DisposableBean (destroy) in ServiceBean");
    }
}
