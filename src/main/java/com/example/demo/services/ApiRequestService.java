package com.example.demo.services;

import com.example.demo.model.ApiRequest;
import com.example.demo.repository.ApiRequestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ApiRequestService {
    private final ApiRequestRepository apiRequestRepository;

    /**
     *
     * @param login - GitHub user login
     */
    public void checkNewRequest(String login){
        ApiRequest request = apiRequestRepository.findByLogin(login);
        if (isLoginExist(request)){
            updateNumOfReq(login);
        }
        else {
            saveNewApiRequest(login);
        }
    }

    /** Updates number of request for login
     *
     * @param login - GitHub login
     */
    private void updateNumOfReq(String login){
        ApiRequest request = apiRequestRepository.findByLogin(login);
        request.setNumOfRequest(request.getNumOfRequest()+1);
        apiRequestRepository.save(request);
    }

    /** Saves new Api Request to db
     *
     * @param login - GitHub user login
     */
    private void saveNewApiRequest(String login){
        ApiRequest apiRequest = new ApiRequest();
        apiRequest.setLogin(login);
        apiRequest.setNumOfRequest(1);
        apiRequestRepository.save(apiRequest);
    }

    /** Check is login exist in db
     *
     * @param request -ApiRequest object
     * @return
     */
    private boolean isLoginExist(ApiRequest request) {
        return request != null;
    }

}
