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
public class MostrarSaldos {
    
    // Creacion de variables
    Objeto object = new Objeto();
    Alquiler alquiler = new Alquiler();
    Usuario user = new Usuario();
    public static ArrayList<Objeto> listaObjetos;//Arraylist de Objetos;
    public static ArrayList<Usuario> listaUsuarios;//Arraylist de Usuarios;
    public static ArrayList<Alquiler> listaAlquiler;//Arraylist de Alquiler;
    int importe = 0;
    MostrarSaldos() 
    {
        try{
            // Obtengo la lista de objetos
            
            listaUsuarios = user.getListaUsuarios();
            listaObjetos = object.getListaObjeto();
            listaAlquiler = alquiler.getListaAlquiler();
            // Si la lista esta vacia lo comunico, sino la muestro
            if(listaObjetos.isEmpty())
                System.out.println("No hay objetos a mostrar");
            else
            {
                // Imprimo los usuarios
                user.listarUsuario();
                object.listarObjeto();
                alquiler.listarAlquiler();
                
                for(int i = 0; i < listaAlquiler.size(); i++)
                {
                    this.importe += listaAlquiler.get(i).getImporteStartup();
                }
                System.out.println("Importe total acumulado para la startup: " + this.importe);
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
