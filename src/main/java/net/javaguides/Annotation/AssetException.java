package net.javaguides.Annotation;

public class AssetException extends RuntimeException{
    public AssetException() {
        super();
    }

    public AssetException(String message, Throwable cause) {
        super(message, cause);
    }

    public AssetException(String message){
        super(message);
    }

    public AssetException(Throwable cause) {
        super(cause);
    }

    protected AssetException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
