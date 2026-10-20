package service;

import dto.request.RechargeRequest;
import dto.response.RechargeResponse;

public interface RechargeService {
    RechargeResponse recharge(String msisdn, RechargeRequest request);
}
