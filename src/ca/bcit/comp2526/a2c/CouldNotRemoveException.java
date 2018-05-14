package ca.bcit.comp2526.a2c;

public class CouldNotRemoveException extends Exception {

    /**
     * Default serial version UID.
     */
    private static final long serialVersionUID = 1L;
    
    /**
     * Creates an object of type BadWidthException.
     */
    public CouldNotRemoveException() {
        
    }
    
    /**
     * Creates an object of type BadWidthException.
     * @param message the message stored in the exception
     */
    public CouldNotRemoveException(String message) {
        super(message);
    }

    /**
     * Creates an object of type BadWidthException.
     * @param cause the cause of the exception
     */
    public CouldNotRemoveException(Throwable cause) {
        super(cause);
    }
    
}
