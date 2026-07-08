package com.mycompany.sginventario_v102072026.modelo;

public class Usuario {

    private String username, password;
    private Rol rol;

    public Usuario(String userName, String password, Rol rol) {
        this.username = userName;
        this.password = password;
        this.rol = rol;
    }

    public Usuario() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String userName) {
        this.username = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        return "[" + username + ", " + password + ", " + rol + "]";
    }

}
