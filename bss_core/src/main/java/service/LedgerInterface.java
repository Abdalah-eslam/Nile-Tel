package service;

import dto.response.LedgerDto;
import jakarta.servlet.http.HttpSession;

import java.util.List;

public interface LedgerInterface {
    public List<LedgerDto> getTransactionStatement(HttpSession session, String fromStr, String toStr);

}
