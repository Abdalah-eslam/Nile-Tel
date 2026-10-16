package service.Impl;

import dto.request.operatorLoginReq;
import dto.request.subscriberLoginReq;
import model.Subscriber;
import repository.LoginRepo;
import service.loginInterface;
import utils.CheckPin;

import java.security.MessageDigest;


public class loginService implements loginInterface {
    private LoginRepo loginRepo;

    public loginService() {
        this.loginRepo = new LoginRepo();
    }

    @Override
    public Subscriber Subscriberlogin(subscriberLoginReq req) {

        Subscriber subscriber = loginRepo.findSubscriberbyNumber(req.msisdn());
        if(subscriber == null) {
            throw new RuntimeException("Invalid Credentials");
        }
        if(!subscriber.getStatus().equals('A')) {
            throw new RuntimeException("Subscriber is not active");
        }

        if(CheckPin.checkPin(req.pin(), subscriber.getHashedPin())==false){
               throw new RuntimeException("Invalid Credentials");
           }

        return subscriber ;





    }

    @Override
    public void Operatorlogin(operatorLoginReq req) {

    }

    @Override
    public void logout() {

    }
}
