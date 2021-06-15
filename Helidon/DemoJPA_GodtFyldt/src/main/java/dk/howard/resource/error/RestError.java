package dk.howard.resource.error;

public class RestError {

    private final String message;
    private final String sid;
    private final String traceId;

    public RestError(String sid, String message, String traceId) {
        this.message = message;
        this.sid = sid;
        this.traceId = traceId;
    }

    public String getMessage() {
        return message;
    }

    public String getSid() {
        return sid;
    }

    public String getTraceId() {
        return traceId;
    }

    public String toString() {
        return String.format("Error occured Sid %s traceid %s  message %s", sid, traceId, message);
    }

}
