package ca.bcit.comp2526.a2c;

public class CouldNotAddException extends Exception {

    /**
     * Default serial version UID.
     */
    private static final long serialVersionUID = 1L;
    
    /**
     * Creates an object of type BadWidthException.
     */
    public CouldNotAddException() {
        
    }
    
    /**
     * Creates an object of type BadWidthException.
     * @param message the message stored in the exception
     */
    public CouldNotAddException(String message) {
        super(message);
    }

    /**
     * Creates an object of type BadWidthException.
     * @param cause the cause of the exception
     */
    public CouldNotAddException(Throwable cause) {
        super(cause);
    }
    
}
