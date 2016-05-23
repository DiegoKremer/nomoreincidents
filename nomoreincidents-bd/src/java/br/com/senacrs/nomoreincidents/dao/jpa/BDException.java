/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senacrs.nomoreincidents.dao.jpa;

/**
 *
 * @author Diego Kremer
 */
public class BDException extends RuntimeException{

    public BDException() {
        super();
    }

    public BDException(String message) {
        super(message);
    }

    public BDException(String message, Throwable cause) {
        super(message, cause);
    }

    public BDException(Throwable cause) {
        super(cause);
    }
    
}
