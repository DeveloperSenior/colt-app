/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colt.app.utilities;

/**
 *
 * @author 
 */
public class ColtException extends RuntimeException{

    public ColtException(String message) {
     super(message);
    }

    public ColtException(Throwable tr) {
      super(tr);
    }

    public ColtException(String message,Throwable tr) {
      super(message, tr);
    }
    
    
}
