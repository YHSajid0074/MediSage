package com.example.MediSage.config.ai.service;


import com.example.MediSage.auth.model.User;
import com.example.MediSage.auth.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AskCvService {
    @Autowired
    UserRepo userRepo;
    @Autowired
    CohereService cohereService;
//    @Autowired
//    OpenRouterService openRouterService;


    public String askCv(String question) {

//        String cv=user.getCandidate().getCvInText();
    String answer = cohereService.askCreator("write within 2 lines and fast and straight answer.no need additional talking  "+question);
        return answer;
    }

}
