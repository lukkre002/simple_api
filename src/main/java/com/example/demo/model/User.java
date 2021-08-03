package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Representation of user object
 */
@Data
@JsonPropertyOrder({ "id", "login", "name", "type","avatarUrl","createdAt","calculations"})
public class User {
    private String id;
    private String login;
    private String name;
    private String type;
    @JsonProperty(value="avatar_url")
    private String avatarUrl;
    @JsonProperty(value="created_at")
    private String createdAt;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private int followers;
    @JsonProperty(value="public_repos", access = JsonProperty.Access.WRITE_ONLY)
    private int publicRepos;
    private BigDecimal calculations;


}
