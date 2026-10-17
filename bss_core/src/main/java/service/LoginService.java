package service;

import dto.request.OperatorLoginReqest;
import dto.request.SubscriberLoginRequest;
import model.Subscriber;

public interface LoginService {

    public Subscriber subscriberLogin(SubscriberLoginRequest req);
    public void operatorLogin(OperatorLoginReqest req);

    public void logout();


}
