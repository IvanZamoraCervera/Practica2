/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author cristian
 */
public class Objeto {
    
    private int IDPropietario;                 //Id del propietario
    private int IDObjeto;                      //Id del objeto                                        
    private String descripcion;                //Descripcion del objeto
    private int precio_dia;                    //Precio de alquiler por dia del objeto
    private  static int proximoIDObjeto = 0;    //Varible Static para controlar ID dl objeto.
    public static ArrayList<Alquiler> listaAlquiler = new ArrayList<Alquiler>();//Arraylist de Objetos Alquilados;
    public static ArrayList<Objeto> listaObjetos = new ArrayList<Objeto>();//Arraylist de Objetos;
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private String fechaInicio = sdf.format(new Date()); 
    private String fechaFin = sdf.format(new Date());
    private String Cadena_idobjeto; // String para imprimir el id con 3 digitos
    Alquiler alquiler = new Alquiler();
    Usuario user = new Usuario();

    /**
     *   constructor de la calse objeto
     */
    Objeto(int IDPropietario, String descripcion, int precio_dia, String fechaFin)
    {
        this.IDPropietario = IDPropietario;
        this.descripcion=descripcion;
        this.precio_dia=precio_dia;
        this.IDObjeto = ++proximoIDObjeto;
        this.fechaFin = fechaFin;
        this.Cadena_idobjeto = String.format("%03d", IDObjeto);
    }
    
    Objeto(){}
    
    /**
    * Devuelve el nombre del propietario.
    * @return IDPropietario
    */
    public int getIDPropietario() {
        return IDPropietario;
    }
    
    /**
    * Asigna el nombre al propietario.
    * @param IDPropietario
    */
    public void setIDPropietario(int IDPropietario) {
        this.IDPropietario = IDPropietario;
    }

    /**
    * Devuelve el id del objeto.
    * @return IDObjeto
    */
    public int getIDObjeto() {
        return IDObjeto;
    }

    /**
    * Asigna el id al objeto.
    * @param IDObjeto
    */
    public void setIDObjeto(int IDObjeto) {
        this.IDObjeto = IDObjeto;
    }

    /**
    * Devuelve la descripcion del objeto.
    * @return descripcion
    */
    public String getDescripcion() {
        return descripcion;
    }

    /**
    * Asigna la descripcion al objeto.
    * @param descripcion
    */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
    * Devuelve el precio por dia del objetp.
    * @return precio_dia
    */
    public int getPrecio_dia() {
        return precio_dia;
    }

    /**
    * Asigna el precio por dia del objeto.
    * @param precio_dia
    */
    public void setPrecio_dia(int precio_dia) {
        this.precio_dia = precio_dia;
    }

    /**
    * Devuelve el id del proximo id que asignar a un objeto.
    * @return proximoIDObjeto
    */
    public static int getProximoIDObjeto() {
        return proximoIDObjeto;
    }

    /**
    * Asigna el proximo id que podra tomar un objeto.
    * @param proximoIDObjeto
    */
    public static void setProximoIDObjeto(int proximoIDObjeto) {
        Objeto.proximoIDObjeto = proximoIDObjeto;
    }
    /**
    * Obtengo la fecha de inicio del objeto
     * @return 
    */
    public String getFechaInicio() {
        return fechaInicio;
    }
    /**
    * Obtengo la fecha de final del objeto
     * @return 
    */
    public String getFechaFin() {
        return fechaFin;
    }
    
    /**
    * Compruebo si la fecha es correcta
     * @param fecha
     * @return 
    */ 
    public static boolean validarFecha(String fecha) 
    {
        try {
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
            formatoFecha.setLenient(false);
            formatoFecha.parse(fecha);
            
        } catch (ParseException e) {
            return false;
        }
        return true;
    }
    
    /**
    * Añado el usuario al arraylist
     * @param object
    */
    public void addObjeto(Objeto object)
    {
        listaObjetos.add(object);
        listarObjeto();
    }
    /**
    * Realiza un listado de todos los usuarios.
    */
    public void listarObjeto() 
    {
        for (Objeto id : listaObjetos) 
        {
            //System.out.println(id.toString());
            System.out.println("OBJETOS DEL PROPIETARIO " + id.getIDPropietario() + "\n");
            System.out.println("Codigo del objeto: " + id.getIDObjeto());
            System.out.println("Descripcion: " + id.getDescripcion());
            System.out.println("Fecha de disponibilidad: " + id.getFechaInicio() + " - " + id.getFechaFin());
            System.out.println("Coste de prestamo por dia: " + id.getPrecio_dia()  + "\n");
            System.out.println("\tPRESTAMOS DEL OBJETO " + id.getIDObjeto() + "\n");
            
            for(Alquiler al : listaAlquiler)
            {
                System.out.println("Nombre del cliente " + user.getNombre() + "\n");
                System.out.println("Fechas del prestamo: " + al.getFecha_ini() + " - " + al.getFecha_fin());
                System.out.println("Importe para el propietario: " + al.getImporte());
                System.out.println("Importe para la startup: " + al.getImporte()*0.10);
            }
        } 
    }
    /**
    * Recogo el ArrayList de objetos.
    * @return
    */
    public ArrayList<Objeto> getListaObjeto() {
        return listaObjetos;
    }
    /**
    * Sobreescritura del metodo toString para mostrar el ID del usuario, el nombre y el correo 
    * @return 
    */
    @Override
    public String toString() 
    {
        return " ID del propietario: " + Cadena_idobjeto + " ID del objeto: " + IDObjeto + " descripcion: " + descripcion + " Precio por dia: " + precio_dia + "€" + " y la fecha de disponibilidad " + fechaInicio + "-" + fechaFin;
    }
    /**
    * Alquila un objeto a un usuario en unas fechas determinadas.
    * @param usuario
    * @param fechaInicio
    */
    public void alquilar(Usuario usuario, GregorianCalendar fechaInicio)
    {
        //alquiler.add(new AlquilerObjeto(this, usuario, fechaInicio));
        //usuario.anyadirObjeto(this, fechaInicio);
    }
    
    /**
    * Devuelbe la lista de alquileres.
    * @return listaAlquiler
    */
    public ArrayList<Alquiler> getAlquiler()
    {
        return listaAlquiler;
    }
    
    /**
    * Asigna una nueva lista de alquileres.
     * @return 
    */
    public Alquiler getAlquilerActual()
    {
        if(listaAlquiler.isEmpty())
        {
            return null;
        }
        else
        {
            return listaAlquiler.get(listaAlquiler.size() - 1);
        }
    }
}
