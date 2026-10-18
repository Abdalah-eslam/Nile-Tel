package service.Impl;

import dto.request.OperatorLoginReqest;
import exception.InvalidCredentialsException;
import exception.NotActiveCustomException;
import model.Operator;
import repository.OperatorRepo;
import service.OperatorService;
import utils.CheckPin;

public class OperatorServiceImpl implements OperatorService {
    private final OperatorRepo operatorRepo;

    public OperatorServiceImpl() {
        this.operatorRepo =new OperatorRepo();
    }


    @Override
    public Operator OperatorLogin(OperatorLoginReqest operatorLoginReqest) {
     Operator Existedoperator =   operatorRepo.findOperatorByUsername(operatorLoginReqest.username());

     if(Existedoperator == null) {
         throw new InvalidCredentialsException("AUTH003");
     }
     if (Existedoperator.getIs_active() != 'Y') {
         throw new NotActiveCustomException("AUTH003");
     }
     if(CheckPin.checkPin(operatorLoginReqest.password(), Existedoperator.getHashedpassword())==false){
        throw new InvalidCredentialsException("AUTH003");
    }
     return Existedoperator;
    }

}
