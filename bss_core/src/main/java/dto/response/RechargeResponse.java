package dto.response;

import java.math.BigInteger;

public record RechargeResponse(long txnId,
                               BigInteger amountPiasters,
                               BigInteger balancePiasters) {
}
