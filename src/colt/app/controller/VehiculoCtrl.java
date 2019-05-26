/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colt.app.controller;

import colt.app.dto.VehiculoDTO;
import colt.app.model.VehiculoMdl;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author
 */
public class VehiculoCtrl {
    
    VehiculoMdl vehiculoMdl;

    public VehiculoCtrl() {
      vehiculoMdl = new VehiculoMdl();      
    }
    
    public VehiculoDTO grabarVehiculo(VehiculoDTO vehiculo) throws SQLException{
        return vehiculoMdl.grabarVehiculo(vehiculo);
    }

    public VehiculoDTO actualizarVehiculo(VehiculoDTO selected) throws SQLException {
        return vehiculoMdl.actualizarVehiculo(selected);
    }

    public void eliminar(VehiculoDTO selected)throws SQLException {
        vehiculoMdl.eliminarVehiculo(selected);
    }
    
    public ArrayList<VehiculoDTO> consultar(VehiculoDTO vehiculo)throws SQLException{
        return vehiculoMdl.consultar(vehiculo);
    }
    
}
