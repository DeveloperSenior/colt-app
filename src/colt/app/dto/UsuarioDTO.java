/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colt.app.dto;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author 
 */
public class UsuarioDTO implements Serializable{
    
    private int idUsuario;
    private String login;
    private String clave;
    private PerfilDTO perfil;
    private String nombre;
    private String apellido;
    private String cedula;
    private Date fechaNacimiento;
    private String telefono;
    private String sexo;

    public UsuarioDTO() {
    }

    public UsuarioDTO(String login, String clave, PerfilDTO perfil, String nombre, String apellido, String cedula, Date fechaNacimiento, String telefono, String sexo) {
        this.login = login;
        this.clave = clave;
        this.perfil = perfil;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.sexo = sexo;
    }
    
    
    
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public PerfilDTO getPerfil() {
        return perfil;
    }

    public void setPerfil(PerfilDTO perfil) {
        this.perfil = perfil;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    
    public Object[] showDataTable() {
        return new Object[]{this, cedula,nombre,apellido,telefono,sexo,fechaNacimiento};
    }
    
}
