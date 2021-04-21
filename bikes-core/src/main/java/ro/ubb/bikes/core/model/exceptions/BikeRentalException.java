package ro.ubb.bikes.core.model.exceptions;

public class BikeRentalException extends RuntimeException{
    public BikeRentalException(String message) {
        super(message);
    }

    public BikeRentalException(String message, Throwable cause) {
        super(message, cause);
    }

    public BikeRentalException(Throwable cause) {
        super(cause);
    }
}
