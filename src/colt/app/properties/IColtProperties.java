/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colt.app.properties;

import colt.app.utilities.ColtException;

/**
 *
 * @author 
 */
public interface IColtProperties {
    
    String getString(String propertie) throws ColtException;
    
}
