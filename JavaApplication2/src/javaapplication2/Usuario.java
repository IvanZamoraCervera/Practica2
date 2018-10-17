/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

import java.util.ArrayList;

/**
 *
 * @author Ivan Zamora
 */
public class Usuario 
{
    // Creación de variables
    private int IDusuario = 0; // creo el codigo que se va a incrementando cada vez que añado un usuario
    private static int proximoID = 1;
    public static ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();// Creo un arrayList para almacenar los usuarios del sistema
    private String nombre; // variable para saber el nombre del usuario
    private String correo; // variable para saber el correo del usuario
    private String dominio = "@gmail.com"; // 
    private String Cadena_idcliente; // String para imprimir el id con 3 digitos
    /*
      Constructor de la clase con parametros
    */
    Usuario(String nombre, String correo) {
        this.nombre = nombre;
        this.correo = correo + dominio;
        this.IDusuario = proximoID; // Incremento el ID
        this.proximoID++;
        this.Cadena_idcliente = String.format("%03d", IDusuario);
    }
    /*
      Constructor de la clase sin parametros
    */
    Usuario() {
        
    }
    /**
    * Devuelve el nombre del usuario.
    * @return
    */
    public String getNombre() {
        return nombre;
    }
    /**
    * Asigna el nombre al usuario.
    * @param nombre
    */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
    * Devuelve el correo del usuario.
    * @return
    */
    public String getCorreo() {
        return correo;
    }
    /**
    * Asigna el correo al usuario.
    * @param correo
    */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getIDusuario() {
        return IDusuario;
    }
    
    /**
    * Añado el usuario al arraylist
     * @param user
    */
    public void addUsuario(Usuario user)
    {
        listaUsuarios.add(user);
        listarUsuario();
    }
    /**
    * Recogo el ArrayList de usuarios.
    * @return
    */
    public ArrayList<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }
    /**
     * Realiza un listado de todos los usuarios.
     */
    public void listarUsuario() 
    {
        listaUsuarios.forEach((n) -> {
            System.out.println(n.toString());
        }); 
    }
    /**
    * Sobreescritura del metodo toString para mostrar el ID del usuario, el nombre y el correo 
    * @return 
    */
    @Override
    public String toString() 
    {
        return "ID: " + Cadena_idcliente + " ID " + IDusuario + " - Nombre: " + this.nombre + " - Correo: " + this.correo + "\n";
    }
}
