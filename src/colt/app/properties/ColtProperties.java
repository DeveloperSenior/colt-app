/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colt.app.properties;

import colt.app.utilities.ColtException;
import java.util.ResourceBundle;

/**
 *
 * @author
 */
public class ColtProperties implements IColtProperties {

    private static ResourceBundle names;

    public ColtProperties() {
        names = ResourceBundle.getBundle(ColtProperties.class.getName());
    }

    @Override
    public String getString(String propertie) throws ColtException {
        if (propertie == null) {
            throw new ColtException("La deficinicion de la propiedad esta vacia");
        }
        return names.getString(propertie);
    }

}
