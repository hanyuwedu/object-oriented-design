package type.reallifeobject.kindle.exceptions;

public class FormatUnrecognizedException extends RuntimeException {
    public FormatUnrecognizedException(String message) {
        super(message);
    }

    public FormatUnrecognizedException() {
        this("This format is not supported by this kindle");
    }
}
