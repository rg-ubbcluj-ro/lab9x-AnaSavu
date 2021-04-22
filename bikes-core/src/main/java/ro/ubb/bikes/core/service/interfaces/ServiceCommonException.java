package ro.ubb.bikes.core.service.interfaces;

public class ServiceCommonException extends RuntimeException {
    public ServiceCommonException(String message) {
        super(message);
    }

    public ServiceCommonException(String message, Throwable cause) {
        super(message, cause);
    }
}
