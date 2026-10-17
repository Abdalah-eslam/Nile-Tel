package dto.request;

public record SubscriberLoginRequest(
        String msisdn,
        String pin
) {
}
