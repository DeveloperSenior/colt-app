/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colt.app.controller;

import colt.app.model.DummyMdl;
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author user
 */
public class DummyCtrl {
    /**
     * Definicion de modelo DummyMdl
     */
    private final DummyMdl mdl;
    public DummyCtrl() {
        /**
         * Instancia del modelo DummyMdl
         */
       mdl = new DummyMdl();
    }
    
    public DefaultComboBoxModel consultarDummy() throws SQLException{
        return mdl.consultarDummy();
    }
    
}
