/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

import java.util.ArrayList;
import java.util.Scanner;
import static javaapplication2.AltaObjeto.listaUsuarios;

/**
 *
 * @author cristian
 */
public class BajaObjeto {
    // Creación de variables
    Objeto object = new Objeto();
    public static ArrayList<Objeto> listaObjetos;
    int id_prop, id_obj;
    Scanner entrada = new Scanner(System.in);
    Usuario user = new Usuario();
    public static ArrayList<Usuario> listaUsuarios;
    boolean valido = false;
    
    BajaObjeto()
    {
        // Obtengo las listas de usuarios y objetos
        listaUsuarios = user.getListaUsuarios();
        listaObjetos = object.getListaObjeto();
        try{
            // Compruebo si la lista de objetos esta vacia
            if(listaObjetos.isEmpty())
            {
                System.out.println("No hay objetos registrados, por favor registra uno antes. \n");
            }
            else// Sino sigo comprobando
            {
                do
                {
                    System.out.print("Escribe el id del propietario: ");
                    this.id_prop = entrada.nextInt(); 
                    
                    // Compruebo si el id del propietario estan en la lista de propietarios
                    if(this.id_prop >= listaUsuarios.size()+1)
                        System.out.println("El usuario no existe, introducelo de nuevo: ");
                    else
                        valido = true;
                }while(valido== false);
                
                System.out.print("Escribe el id del objeto: ");
                this.id_obj = entrada.nextInt();
                if(id_prop == listaObjetos.get(id_obj-1).getIDPropietario())
                {
                    for(int i = 0; i < listaObjetos.size(); i++)
                    {
                        if(listaObjetos.get(i).getIDObjeto() == id_obj)
                        {
                            listaObjetos.remove(i);
                            System.out.print("Se ha eliminado el objeto con exito\n");
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
  
