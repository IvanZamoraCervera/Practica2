/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author cristian
 */
public class ModificarImporte {
    Objeto object = new Objeto();
    public static ArrayList<Objeto> listaObjetos;

    Scanner entrada = new Scanner(System.in);
    int id_obj;
    int precio;


    ModificarImporte()
    {
        listaObjetos = object.getListaObjeto();
        
        if(listaObjetos.isEmpty())
        {
            System.out.print("No hay objetos registrados, por favor registra uno antes. \n");
        }
        else// Sino sigo comprobando
        {
            System.out.print("Introduce el id del objeto que deseas modificar el importe por dia: ");
            this.id_obj = entrada.nextInt();  

            System.out.print("Introduce el nuevo precio por dia del objeto: ");
            this.precio = entrada.nextInt(); 

            for(int i = 0; i < listaObjetos.size(); i++)
            {
                if(listaObjetos.get(i).getIDObjeto() == id_obj)
                {
                    listaObjetos.get(i).setPrecio_dia(precio);
                    System.out.print("Se ha modificado el precio con exito\n");
                }
            }
        }  

    }
    
}
