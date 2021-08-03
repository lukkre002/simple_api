package com.example.demo.repository;

import com.example.demo.model.ApiRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApiRequestRepository extends JpaRepository<ApiRequest,String> {
    ApiRequest findByLogin(String login);
}
