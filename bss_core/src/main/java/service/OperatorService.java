package service;

import dto.request.OperatorLoginReqest;
import model.Operator;

public interface OperatorService {
    Operator OperatorLogin(OperatorLoginReqest operatorLoginReqest);
}
