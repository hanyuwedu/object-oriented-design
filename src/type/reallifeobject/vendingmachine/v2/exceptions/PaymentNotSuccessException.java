package type.reallifeobject.vendingmachine.v2.exceptions;

public class PaymentNotSuccessException extends RuntimeException {
    public PaymentNotSuccessException(String message) {
        super(message);
    }

    public PaymentNotSuccessException() {
        this("Payment is not success");
    }
}
