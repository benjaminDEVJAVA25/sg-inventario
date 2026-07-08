package com.mycompany.sginventario_v102072026.modelo.servicios;

import com.mycompany.sginventario_v102072026.modelo.Rol;
import com.mycompany.sginventario_v102072026.modelo.Usuario;
import java.util.HashMap;
import java.util.Objects;

public class UsuarioService {
    
    private HashMap<String, Usuario> usuarios;

    public UsuarioService() {
        usuarios = new HashMap<>();
        cargarUsuarioInicial();
    }
    private void cargarUsuarioInicial(){
        Usuario usuarioPorDefecto = new Usuario("admin", "1234", Rol.Admin);
        agregarUsuario(usuarioPorDefecto);
    }
    
    public boolean agregarUsuario(Usuario usuario){
        if(usuarios.containsKey(usuario.getUsername())){
            return false;
        }
        usuarios.put(usuario.getUsername(), usuario);
        return true;
    }
    
    public Usuario autenticar(String username, String password){
        Usuario usuarioBuscado = usuarios.get(username);
        if(usuarioBuscado != null && Objects.equals(usuarioBuscado.getPassword(), password)){
            return usuarioBuscado;
        }
        return null;
    };
}
