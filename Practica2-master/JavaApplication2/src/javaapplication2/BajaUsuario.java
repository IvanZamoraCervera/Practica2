/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

import java.util.ArrayList;
import java.util.Scanner;
import static javaapplication2.BajaObjeto.listaObjetos;

/**
 *
 * @author cristian
 */
public class BajaUsuario {
    // Creación de variables

    int id_prop, id_obj;
    Scanner entrada = new Scanner(System.in);
    Usuario user = new Usuario();
    Objeto o = new Objeto();
    public static ArrayList<Usuario> listaUsuarios;
    boolean valido = false;
    Objeto object = new Objeto();
    public static ArrayList<Objeto> listaObjetos;
    
    BajaUsuario()
    {
        //falta la parte de dar de baja los objetos del usuario
        // Obtengo las listas de usuarios y objetos
        listaUsuarios = user.getListaUsuarios();
        listaObjetos = object.getListaObjeto();

        try{
            // Compruebo si la lista de objetos esta vacia
            if(listaUsuarios.isEmpty())
            {
                System.out.println("No hay usuarios registrados, por favor registra uno antes. \n");
            }
            else// Sino sigo comprobando
            {
                do
                {
                    System.out.print("Escribe el id del usuario: ");
                    this.id_prop = entrada.nextInt(); 
                    
                    // Compruebo si el id del propietario estan en la lista de propietarios
                    if(this.id_prop >= listaUsuarios.size()+1)
                        System.out.println("El usuario no existe, introducelo de nuevo: ");
                    else
                        valido = true;
                }while(valido== false);
                
                for(int i = 0; i < listaUsuarios.size(); i++)
                {
                    if(listaUsuarios.get(i).getIDusuario()== id_prop)
                    {
                        listaUsuarios.remove(i);
                        System.out.print("Se ha eliminado el usuario con exito\n");
                        
                        if(id_prop == listaObjetos.get(i).getIDPropietario())
                        {
                            for(int j = 0; j < listaObjetos.size(); j++)
                            {
                                listaObjetos.remove(j);
                                System.out.print("Se ha eliminado el objeto con exito\n");
                            }
                        }
                    }
                }
            }
        }catch(NumberFormatException e)
        {
            e.printStackTrace();
        }
    }
}
