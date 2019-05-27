/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colt.app.controller;

import colt.app.dto.CiudadDTO;
import colt.app.dto.RutaDTO;
import colt.app.model.CiudadMdl;
import colt.app.model.RutaMdl;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author
 */
public class RutaCtrl {
    
    RutaMdl rutaMdl;
    CiudadMdl ciudadMdl;

    public RutaCtrl() {
      rutaMdl = new RutaMdl();
      ciudadMdl = new CiudadMdl();
    }
    
    public RutaDTO grabarRuta(RutaDTO ruta) throws SQLException{
        return rutaMdl.grabarRuta(ruta);
    }

    public RutaDTO actualizarRuta(RutaDTO selected) throws SQLException {
        return rutaMdl.actualizarRuta(selected);
    }

    public void eliminar(RutaDTO selected)throws SQLException {
        rutaMdl.eliminarRuta(selected);
    }
    
    public ArrayList<RutaDTO> consultar(RutaDTO ruta)throws SQLException{
        return rutaMdl.consultar(ruta);
    }
    
    public ArrayList<CiudadDTO> consultarCiudades(CiudadDTO ciudad)throws SQLException{
        return ciudadMdl.consultar(ciudad);
    }
    
}
