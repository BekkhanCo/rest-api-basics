package exception.gift_certificate;

public class InvalidCertificateException extends RuntimeException{
    public InvalidCertificateException(String message){
        super(message);
    }
}
