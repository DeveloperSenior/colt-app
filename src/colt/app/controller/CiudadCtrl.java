/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colt.app.controller;

import colt.app.dto.CiudadDTO;
import colt.app.model.CiudadMdl;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author
 */
public class CiudadCtrl {
    
    CiudadMdl ciudadMdl;

    public CiudadCtrl() {
      ciudadMdl = new CiudadMdl();      
    }
    
    public CiudadDTO grabarCiudad(CiudadDTO ciudad) throws SQLException{
        return ciudadMdl.grabarCiudad(ciudad);
    }

    public CiudadDTO actualizarCiudad(CiudadDTO selected) throws SQLException {
        return ciudadMdl.actualizarCiudad(selected);
    }

    public void eliminar(CiudadDTO selected)throws SQLException {
        ciudadMdl.eliminarCiudad(selected);
    }
    
    public ArrayList<CiudadDTO> consultar(CiudadDTO ciudad)throws SQLException{
        return ciudadMdl.consultar(ciudad);
    }
    
}
