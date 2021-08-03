package com.example.demo.services;

import com.example.demo.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.math.RoundingMode;


@Service
public class UserService {
@Autowired
private ApiRequestService apiRequestService;

    /**
     *
     * @param login - GitHub user login
     * @return User with all data
     */
    public User getUserData(String login){
        User user;
        try {
            user = loadDataFromApi(login);
        }
        catch (Exception ex) {
            return null;
        }
        apiRequestService.checkNewRequest(login);
        return setCalculatedValue(user);
    }

    /** Download data from GitHub Api
     *
     * @param login - GitHub user login
     * @return
     */
    private User loadDataFromApi(String login){
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("https://api.github.com/users/"+login,User.class);
    }
    /** Calculation of algorithm 6/follower * (2+public_repos)
     *
     * @param user -Object of User class
     */
    private User setCalculatedValue(User user){
        BigDecimal followers = BigDecimal.valueOf(user.getFollowers());
        checkDivisionByZero(followers);
        BigDecimal numOfRepos= BigDecimal.valueOf(user.getPublicRepos());
        numOfRepos = numOfRepos.add(BigDecimal.valueOf(2));
        BigDecimal result =  BigDecimal.valueOf(6).divide(followers,6, RoundingMode.HALF_EVEN).multiply(numOfRepos);
        user.setCalculations(result);
        return user;
    }

    /** Checking division by 0
     *
     * @param divisor - Number that divides another number
     */
    @ResponseStatus(HttpStatus.NOT_FOUND)
    private void checkDivisionByZero(BigDecimal divisor) {
        if(divisor.equals(BigDecimal.ZERO)){
            throw new ArithmeticException("Division by 0 is not allowed. The number of followers is zero.\n");
        }
    }
}
