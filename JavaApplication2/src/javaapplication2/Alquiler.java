/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import static javaapplication2.Objeto.listaObjetos;

/**
 *
 * @author cristian
 */

    

public class Alquiler {
    private int id_alq;                       
    private int id_obj;                         
    int importe = 0;
    public static ArrayList<Alquiler> listaAlquiler = new ArrayList<Alquiler>();
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private String fecha_ini = sdf.format(new Date()); 
    private String fecha_fin = sdf.format(new Date());
    Usuario user = new Usuario();
    
    Alquiler(){}
    
    Alquiler(int id_alq, int id_obj, String fecha_ini, String fecha_fin)
    {
        this.fecha_fin = fecha_fin;
        this.fecha_ini = fecha_ini;
        this.id_alq = id_alq;
        this.id_obj = id_obj;
    }

    public int getId_alq() {
        return id_alq;
    }

    public void setId_alq(int id_alq) {
        this.id_alq = id_alq;
    }

    public int getImporte() {
        return importe;
    }

    public void setImporte(int importe) {
        this.importe = importe;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public int getId_obj() {
        return id_obj;
    }

    public void setId_obj(int id_obj) {
        this.id_obj = id_obj;
    }

    public static ArrayList<Alquiler> getListaAlquiler() {
        return listaAlquiler;
    }

    public static void setListaAlquiler(ArrayList<Alquiler> listaAlquiler) {
        Alquiler.listaAlquiler = listaAlquiler;
    }

    public SimpleDateFormat getSdf() {
        return sdf;
    }

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
