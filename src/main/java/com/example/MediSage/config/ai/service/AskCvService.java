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


    public String askCv(Long id,String question) {
        User user = userRepo.findById(id).get();
//        String cv=user.getCandidate().getCvInText();
//        String answer = cohereService.askCreator(cv+"         bro just read the full above text and think that it is you and based on that try to answer the below question.                write within 2 lines and fast and straight answer.no need additional talking  "+question);
        return null;
    }

}
