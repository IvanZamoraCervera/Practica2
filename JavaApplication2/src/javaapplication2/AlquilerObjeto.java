/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

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
    boolean valid2 = false;
    boolean valid3 = false;
    public static ArrayList<Objeto> listaAlquileres;
    String fecha_ini, fecha_fin;
    double incremento = 0.10;
    Alquiler alquiler = new Alquiler();
    int importe;
    String nombre;
    
    //constructor de la clase
    AlquilerObjeto()
    {
        listaUsuarios = user.getListaUsuarios();
        listaObjetos = object.getListaObjeto();
        //entrada y validacion de datos
        try{
            //comprueba si existen usuarios y objetos
            if(listaObjetos.isEmpty()|| listaUsuarios.isEmpty())
            {
                System.out.println("No hay objetos o usuarios registrados, por favor registrelos antes antes. \n");
                System.out.println("No se ha alguilado ningun objeto");
            }
            else
            {
                //se piden los datos al usuario
                do
                {
                    System.out.print("Dime el ID de tu usuario: ");
                    this.id_alq = entrada.nextInt();

                    if(this.id_alq <= listaUsuarios.size()+1)
                    {
                        valido = true;
                        this.nombre = listaUsuarios.get(user.getIDusuario()).getNombre();
                        alquiler.setNombreUsuario(this.nombre);
                    }
                    else
                    {
                        System.out.println("El usuario no existe, introducelo de nuevo: ");
                    }
                }while(valido== false);
                
                listaObjetos = object.getListaObjeto();
                
                System.out.print("Escribe el id del objeto que se desee alquilar: ");
                this.id_obj = entrada.nextInt();
                
                // Comprobamos las fechas
                for(int i = 0; i < listaObjetos.size(); i++)
                {
                    do{
                        if(listaObjetos.get(i).getIDObjeto() == this.id_obj)
                        {
                            this.importe = listaObjetos.get(i).getPrecio_dia();
                            alquiler.setImporte(this.importe);
                            
                            System.out.print("Introduce la fecha de inicio de alquiler: ");
                            this.fecha_ini = entrada.next();
                            if(this.fecha_ini.compareTo((listaObjetos.get(i).getFechaInicio())) >= 0)
                                valid2 = true;
                            else
                            {
                                System.out.println("La fecha de inicio es invalida");
                                System.out.print("Introduce la fecha de inicio de alquiler: ");
                                this.fecha_ini = entrada.next();
                            }
                        }
                    }while(valid2 = false);
                    // Fecha de fin
                    do{
                        if(listaObjetos.get(i).getIDObjeto() == this.id_obj)
                        {
                            System.out.print("Introduce la fecha de fin de alquiler: ");
                            this.fecha_fin = entrada.next();
                            
                            if(this.fecha_fin.compareTo((listaObjetos.get(i).getFechaFin())) <= 0)
                            {
                                valid3 = true;
                                alquiler.calcularDias(this.fecha_ini, this.fecha_fin);
                            }
                            else
                            {
                                System.out.println("La fecha de fin es invalida");
                                System.out.print("Introduce la fecha de fin de alquiler: ");
                                this.fecha_fin = entrada.next();
                            }
                        }
                    }while(valid3 = false);
                    
                    
                }
                alquiler = new Alquiler(this.id_alq, this.id_obj, this.fecha_ini, this.fecha_fin,this.nombre ,this.importe);
                alquiler.addAlquiler(alquiler);
                System.out.println("El usuario " + this.id_alq + " a alguilado el objeto " + this.id_obj + " correctamente.");
            }
            
        }catch(ParseException e)
        {
            e.printStackTrace();
        }
    }
}
