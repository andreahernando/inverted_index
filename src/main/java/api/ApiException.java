package api;

public class ApiException extends Exception{
    public ApiException(int code, String body) {
        super(code + ": " + body);
    }
}
