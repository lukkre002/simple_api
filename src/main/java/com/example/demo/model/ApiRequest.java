package com.example.demo.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
@Data
public class ApiRequest {
    @Column
    @Id
    private String login;
    @Column
    private int numOfRequest;

}
