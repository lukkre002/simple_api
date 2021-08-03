package com.example.demo.services;

import com.example.demo.model.ApiRequest;
import com.example.demo.repository.ApiRequestRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@RunWith(MockitoJUnitRunner.class)

class ApiRequestServiceTest {


@Test
    public void checkNewRequest(){
    // given

    ApiRequestService apiRequestService = mock(ApiRequestService.class);
    doNothing().when(apiRequestService).checkNewRequest(anyString());
    apiRequestService.checkNewRequest("login");
    verify(apiRequestService,times(1)).checkNewRequest("login");
}

}