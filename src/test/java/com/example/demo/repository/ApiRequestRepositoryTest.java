package com.example.demo.repository;

import com.example.demo.model.ApiRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(SpringExtension.class)
@DataJpaTest
class ApiRequestRepositoryTest {
    @Autowired
    private ApiRequestRepository apiRequestRepository;

    private ApiRequest apiRequest;
    @BeforeEach
    void setUp(){
        apiRequest = new ApiRequest();
        apiRequest.setLogin("login");
        apiRequest.setNumOfRequest(2);
        apiRequestRepository.save(apiRequest);
    }

    @Test
    void findByLoginTest(){
        ApiRequest login = apiRequestRepository.findByLogin("login");
        assertEquals(2,login.getNumOfRequest());
        assertEquals("login",login.getLogin());
    }
}