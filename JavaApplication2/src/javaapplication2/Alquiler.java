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

/**
 *
 * @author cristian
 */

    

public class Alquiler {
    // Declaracion de variables
    private int id_alq;                       
    private int id_obj;                         
    private int importe = 0;
    private String nombre;
    public static ArrayList<Alquiler> listaAlquiler = new ArrayList<Alquiler>();
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private String fecha_ini = sdf.format(new Date()); 
    private String fecha_fin = sdf.format(new Date());
    Usuario user = new Usuario();
    /*
      Constructor de la clase sin parametros
    */
    Alquiler(){}
    /*
      Constructor de la clase con parametros
    */
    Alquiler(int id_alq, int id_obj, String fecha_ini, String fecha_fin, String nombre, int importe)
    {
        this.fecha_fin = fecha_fin;
        this.fecha_ini = fecha_ini;
        this.id_alq = id_alq;
        this.id_obj = id_obj;
        this.nombre = nombre;
        this.importe = importe;
    }
    /**
    * Devuelve el id del alquiler.
    * @return
    */
    public int getId_alq() {
        return id_alq;
    }
    /**
    * Asigna el id del alquiler.
     * @param id_alq
    */
    public void setId_alq(int id_alq) {
        this.id_alq = id_alq;
    }
    
    /**
    * Devuelve el nombre del usuario.
    * @return
    */
    public int getImporteStartup() {
        return (int) (importe*0.10);
    }
    /**
    * Devuelve el nombre del usuario.
    * @return
    */
    public int getImporte() {
        return importe;
    }
    /**
    * Devuelve el nombre del usuario.
     * @param importe
    */
    public void setImporte(int importe) {
        
        this.importe = importe;
    }
    /**
    * Devuelve el nombre del usuario.
    * @return
    */
    public Usuario getUser() {
        return user;
    }
    /**
    * Asigno el usuario.
     * @param user
    */
    public void setUser(Usuario user) {
        this.user = user;
    }
    /**
    * Devuelve el id del objeto.
    * @return
    */
    public int getId_obj() {
        return id_obj;
    }
    /**
    * Devuelve el nombre del usuario.
     * @param id_obj
    */
    public void setId_obj(int id_obj) {
        this.id_obj = id_obj;
    }
    
    /**
    * Devuelve el formato de la fecha.
    * @return sdf
    */
    public SimpleDateFormat getSdf() {
        return sdf;
    }
    /**
    * Devuelve el nombre del usuario.
     * @param sdf
    */
    public void setSdf(SimpleDateFormat sdf) {
        this.sdf = sdf;
    }
    /**
    * Obtengo la fecha de inicio del objeto
     * @return 
    */
    public String getFecha_ini() {
        return fecha_ini;
    }
    /**
    * Obtengo la fecha de final del objeto
     * @param fecha_ini 
    */
    public void setFecha_ini(String fecha_ini) {
        this.fecha_ini = fecha_ini;
    }
    /**
    * Obtengo la fecha de final del objeto
     * @return 
    */
    public String getFecha_fin() {
        return fecha_fin;
    }
    /**
    * Asigna la fecha de fin 
    * @param fecha_fin
    */
    public void setFecha_fin(String fecha_fin) {
        this.fecha_fin = fecha_fin;
    }
    
    public void setNombreUsuario(String nombre)
    {
        this.nombre = nombre;
    }
    
    public String getNombreUsuario()
    {
        return this.nombre;
    }
    
    public void calcularDias(String fecha_ini, String fecha_fin) throws ParseException
    {
        Date fechaInicial=sdf.parse(fecha_ini);
        Date fechaFinal=sdf.parse(fecha_fin);

        int dias=(int) ((fechaFinal.getTime()-fechaInicial.getTime())/86400000);
        System.out.println("Hay " + dias + " dias de diferencia");
    }
    /**
    * Devuelve el array.
    * @return
    */
    public ArrayList<Alquiler> getListaAlquiler() {
        return listaAlquiler;
    }
    /**
    * Asigna el array del alquiler.
     * @param listaAlquiler
    */
    public static void setListaAlquiler(ArrayList<Alquiler> listaAlquiler) {
        Alquiler.listaAlquiler = listaAlquiler;
    }
    /**
    * Añado el usuario al arraylist
     * @param alquiler
    */
    public void addAlquiler(Alquiler alquiler)
    {
        listaAlquiler.add(alquiler);
        listarAlquiler();
    }
    /**
    * Realiza un listado de todos los usuarios.
    */
    public String listarAlquiler() 
    {
        String s = "";
        for(Alquiler al: listaAlquiler)
        {
            s +=   "\t\t  Nombre del cliente " + al.getNombreUsuario() + "\n" +
                    "\t\t  Fechas del prestamo: " + al.getFecha_ini() + " - " + al.getFecha_fin() + "\n" +
                    "\t\t  Importe para el propietario: " + al.getImporte() + " euros" + "\n" +
                    "\t\t  Importe para la startup: " + al.getImporteStartup() + " euros" + "\n";
        }
        return s;
    }
    /**
    * Sobreescritura del metodo toString para mostrar los datos del alquiler
    * @return 
    */
    @Override
    public String toString() 
    {
        return " ID del alquilador: " + id_alq + " ID del objeto: " + id_obj + " fecha de inicio: " + fecha_ini + " Fecha de fin: " + fecha_fin + " Saldo del propietario " + importe + " Saldo de la startup: " + importe*0.10;
    }
}
