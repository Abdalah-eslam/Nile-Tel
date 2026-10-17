package service.Impl;

import dto.request.OperatorLoginReqest;
import dto.request.SubscriberLoginRequest;
import model.Subscriber;
import repository.LoginRepo;
import service.LoginService;
import utils.CheckPin;


public class LoginServiceImpl implements LoginService {
    private LoginRepo loginRepo;

    public LoginServiceImpl() {
        this.loginRepo = new LoginRepo();
    }

    @Override
    public Subscriber subscriberLogin(SubscriberLoginRequest req) {

        Subscriber subscriber = loginRepo.findSubscriberByNumber(req.msisdn());
        if(subscriber == null) {
            throw new RuntimeException("Invalid Credentials");
        }
        if(!subscriber.getStatus().equals('A')) {
            throw new RuntimeException("Subscriber is not active");
        }

        if(CheckPin.checkPin(req.pin(), subscriber.getHashedPin())==false){
               throw new RuntimeException("Invalid Credentials");
           }

        return subscriber;
    }

    @Override
    public void operatorLogin(OperatorLoginReqest req) {

    }

    @Override
    public void logout() {

    }
}
