package service;

import dto.request.operatorLoginReq;
import dto.request.subscriberLoginReq;
import model.Subscriber;

public interface loginInterface {

    public Subscriber Subscriberlogin(subscriberLoginReq req);
    public void Operatorlogin(operatorLoginReq req);

    public void logout();


}
