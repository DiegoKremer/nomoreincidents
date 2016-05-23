package br.com.senacrs.nomoreincidents.business;

/**
 *
 * @author Diego Kremer
 */
public class BusinessException extends Exception {
    
    public BusinessException(String s) {
        super(s);
    }

    public BusinessException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public BusinessException(Throwable throwable) {
        super(throwable);
    }
    
}
