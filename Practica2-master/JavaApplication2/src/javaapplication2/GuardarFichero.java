/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;


/**
 *
 * @author cristian
 */
public class GuardarFichero {
    
    // Creacion de variables
    Objeto object = new Objeto();
    Alquiler alquiler = new Alquiler();
    Usuario user = new Usuario();
    public static ArrayList<Objeto> listaObjetos;//Arraylist de Objetos;
    public static ArrayList<Usuario> listaUsuarios;//Arraylist de Usuarios;
    public static ArrayList<Alquiler> listaAlquiler;//Arraylist de Alquiler;
    int importe = 0;
    String nombre = "src\\javaapplication2\\Datos.txt";
    
    GuardarFichero() 
    {
        try{
            System.out.println("Guardando fichero ");
            FileWriter fichero = new FileWriter(nombre);
            PrintWriter print = new PrintWriter(fichero);
            listaUsuarios = user.getListaUsuarios();
            listaObjetos = object.getListaObjeto();
            listaAlquiler = alquiler.getListaAlquiler();
            // Si la lista esta vacia lo comunico, sino la muestro
            if(listaObjetos.isEmpty())
                System.out.println("No hay objetos a mostrar");
            else
            {
                print.print(this.user.listarUsuario());
                print.print(this.alquiler.listarAlquiler());
                
                for(int i = 0; i < listaAlquiler.size(); i++)
                {
                    this.importe += listaAlquiler.get(i).getImporteStartup();
                }
                print.println("Importe total acumulado para la startup: " + this.importe);
            }
            print.close();
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
}
