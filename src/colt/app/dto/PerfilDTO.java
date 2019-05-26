/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colt.app.dto;

import java.awt.Label;

/**
 *
 * @author 
 */
public class PerfilDTO {
    
    private int idPerfil;
    private String nombre;
    private String activo;

    public PerfilDTO() {
    }

    public PerfilDTO(String nombre, String activo) {
        this.nombre = nombre;
        this.activo = activo;
    }
    

    public int getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(int idPerfil) {
        this.idPerfil = idPerfil;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }
    
    public Object[] showDataTable() {
        return new Object[]{this, idPerfil,nombre,activo};
    }    

    @Override
    public String toString() {
        return idPerfil+"-"+nombre;
    }
    
    
    
}
