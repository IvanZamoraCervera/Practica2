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
public class AlquilerObjeto {
    //declaracion de variables
    Objeto object = new Objeto();
    public static ArrayList<Objeto> listaObjetos;
    int id_alq, id_obj;
    Scanner entrada = new Scanner(System.in);
    Usuario user = new Usuario();
    public static ArrayList<Usuario> listaUsuarios;
    boolean valido = false;
    public static ArrayList<Objeto> listaAlquileres;
    String fecha_ini, fecha_fin;
    double incremento = 0.10;
    Alquiler alquiler = new Alquiler();
    
    //constructor de la clase
    AlquilerObjeto()
    {
        listaUsuarios = user.getListaUsuarios();
        listaObjetos = object.getListaObjeto();
        //entrada y validacion de datos
        try{
            if(listaObjetos.isEmpty()|| listaUsuarios.isEmpty())
            {
                System.out.println("No hay objetos o usuarios registrados, por favor registrelos antes antes. \n");
            }
            else
            {
                do
                {
                System.out.print("Escribe el id del alquilador: ");
                this.id_alq = entrada.nextInt();
                if(listaUsuarios.contains(id_alq))
                {
                    valido = true;
                }
                else
                {
                    System.out.println("El usuario no esxiste, introducelo de nuevo: ");
                }
                }while(valido== false);
                
                listaObjetos = object.getListaObjeto();
                
                System.out.print("Escribe el id del objeto que se desee alquilar: ");
                this.id_obj = entrada.nextInt();
                
                System.out.println("Introduce la fecha de inicio de alquiler: ");
                this.fecha_ini = entrada.next();
                
                System.out.println("Introduce la fecha de fin de alquiler: ");
                this.fecha_fin = entrada.next();
                
                
                //se valida la fecha
                    if (object.validarFecha(fecha_ini) != true && object.validarFecha(fecha_fin) != true)
                        {
                            System.out.println("Introduce una fecha correcta");
                        }  
                        else
                        {
                            alquiler = new Alquiler(id_alq, id_obj, fecha_ini, fecha_fin);
                            object.addObjeto(object);
                        }
            }
            
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
