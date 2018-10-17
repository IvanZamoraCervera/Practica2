/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;
import java.util.Scanner;

/**
 *
 * @author cristian
 */
public class AltaUsuario {
    
    // Creación de variables
    private Usuario user;
    private String nombre;
    private String correo;
    
    Scanner entrada = new Scanner(System.in);
    
    AltaUsuario()
    {
        try{
            // Recogemos los valores introducidos 
            System.out.print("Dime tu nombre: ");
            nombre = entrada.nextLine();
            
            System.out.print("Dime tu correo (solo el nombre, automaticamente se añadira al correo de la empresa @gmail.com): ");
            correo = entrada.nextLine();
            
            // Creo el usuario con los parametros que han puesto por la consola
            user = new Usuario(nombre,correo);
            // Llamo a la funcion de Usuario para que añado al nuevo usuario al array de usuarios
            user.addUsuario(user);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
