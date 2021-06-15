package dk.howard.service.exception;

public class InputException extends RuntimeException {
    private final Sid sid;

    public InputException(Sid sid, String message) {
        super(message);
        this.sid = sid;
    }

    public InputException(Sid sid, String message, Throwable cause) {
        super(message, cause);
        this.sid = sid;
    }

    public InputException(Sid sid, Throwable cause) {
        super(cause);
        this.sid = sid;
    }

    public Sid getSid() {
        return sid;
    }
}
