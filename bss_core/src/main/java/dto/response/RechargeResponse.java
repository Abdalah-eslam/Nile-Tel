package dto.response;

import java.math.BigInteger;

public record RechargeResponse(String txnId,
                               BigInteger amountPiasters,
                               BigInteger balancePiasters) {
}
