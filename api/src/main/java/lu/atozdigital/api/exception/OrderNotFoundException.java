package lu.atozdigital.api.exception;

public class OrderNotFoundException extends  RuntimeException{
    public OrderNotFoundException(String message) {
        super(message);
    }
}

