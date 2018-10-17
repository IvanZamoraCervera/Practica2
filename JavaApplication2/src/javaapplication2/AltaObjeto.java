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
public final class AltaObjeto 
{
    
    // Creación de variables
    Scanner entrada = new Scanner(System.in);
    Usuario user = new Usuario();
    Objeto object = new Objeto();
    private int precio;
    private int propietario;
    private String descripcion;
    public static ArrayList<Usuario> listaUsuarios;
    String price, prop; 
    String fecha;
    
    AltaObjeto() throws ParseException
    {
        // Inicializo el array para cargarlos valores que ya existen
        listaUsuarios = user.getListaUsuarios();
        try{
            // Si no hay ningun usuario registrado que no siga
            if(listaUsuarios.isEmpty())
                System.out.println("No hay usuarios registrados, por favor registrate antes. \n");
            else
            {
                // Si hay usuarios, los muestra para elegir
                user.listarUsuario();
                
                System.out.print("Escribe el id del propietario: ");
                this.prop = entrada.next();
                do{
                    //Comprobamos que nos introduce el id en entero
                    if (isNumeric(prop) == true)
                        this.propietario = Integer.parseInt(this.prop);
                    else
                    {
                        System.out.print("Solo se aceptan numeros, ");
                        System.out.print("Escribe el id del propietario: ");
                        this.prop = entrada.next();
                    }
                }while (isNumeric(prop) != true); 
                
                // Si el ID dado no coincide con los ID's que hay almacenados, se sale
                if(this.propietario >= listaUsuarios.size()+1)
                {       
                    System.out.println("El ID " + this.propietario + " no esta registrado, registrelo antes.");
                    System.out.println("No se ha registrado ningun Objeto");
                }
                else // Sino seguimos pidiendo datos..
                {
                    do{
                        System.out.print("Escribe la descripcion del objeto: ");
                        descripcion = entrada.next();
                        // Comprobamos que la descripción no esta vacia
                        if(descripcion == null)
                            System.out.print("La descripcion no puede estar vacia, ");
                    }while(descripcion == null);
                    //bucle que se repite para comprobar que el precio del alquiler es un precio valido
                    do{
                        System.out.print("Escribe el precio del alquiler por dia: ");
                        price = entrada.next();
                        //asigra el valor introducido a una variable para incluirla en el array de objetos si el valor introducido es valido
                        if (isNumeric(price) != true) //Compruebo si el precio es entero
                            System.out.print("Solo se aceptan numeros, ");
                        else if (Integer.parseInt(price) > 0)
                            precio = Integer.parseInt(price);
                        else
                            System.out.print("No se aceptan numeros negativos en el campo precio, ");
                    }while(isNumeric(price) != true);  
                    
                    do{
                        System.out.println("Fecha de hoy " + object.getFechaInicio());
                        System.out.print("Introduce la fecha de finalización de disponibilidad en formato dd/mm/yyyy: ");
                        fecha = entrada.next();
                        
                        // Comprobar que la fecha introducida es correcta
                        if (object.validarFecha(fecha) != true)
                            System.out.println("Introduce una fecha correcta en el formato dd/mm/yyyy");
                        else
                        {
                            object = new Objeto(propietario, descripcion, precio,fecha);
                            object.addObjeto(object);
                        }
                    }while(object.validarFecha(fecha) != true);
                    
                    System.out.println("Se ha registrado el Objeto correctamente");
                }
            }
        }catch(NumberFormatException e)
        {
            e.printStackTrace();
        } 
    }
    
    /**
    * comprueba si un elemento es numerico.
    * @param n //elemento a comprobar
     * @return 
    */
    public boolean isNumeric(String n)
    {
        boolean ent;
	try 
        {
            Integer.parseInt(n);
            ent = true;
	} 
        catch (NumberFormatException ex)
        {
            ent = false;
	}
        
        return ent;
    }
}
