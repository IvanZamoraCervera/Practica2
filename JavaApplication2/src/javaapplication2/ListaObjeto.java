
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

import java.util.ArrayList;

/**
 *
 * @author cristian
 */
public class ListaObjeto {
    
    // Creacion de variables
    Objeto object = new Objeto();
    public static ArrayList<Objeto> listaObjetos;//Arraylist de Objetos;
    
    ListaObjeto() 
    {
        try{
            // Obtengo la lista de objetos
            listaObjetos = object.getListaObjeto();
            // Si la lista esta vacia lo comunico, sino la muestro
            if(listaObjetos.isEmpty())
                System.out.println("No hay objetos a mostrar");
            else
                object.listarObjeto();
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        
        
    }
    
}
