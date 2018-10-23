/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

import java.util.ArrayList;
import java.util.Collections;
import static javaapplication2.BajaObjeto.listaUsuarios;

/**
 *
 * @author cristian
 */
public class ListarAsiduos {
    
    Alquiler alq = new Alquiler();
    public static ArrayList<Alquiler> listaAlquiler;
    Usuario user = new Usuario();
    public static ArrayList<Usuario> listaUsuarios;
    Integer id_user;
    Integer aux = 0;
    Integer valor = 0;
    Integer max = 0;
    public static ArrayList<Integer> asiduos = new ArrayList();
    public static ArrayList<Integer> asiduos2 = new ArrayList();
    
    ListarAsiduos()
    {
        listaUsuarios = user.getListaUsuarios();
        listaAlquiler = alq.getListaAlquiler();
        for (int i = 0; i < listaUsuarios.size(); i++)
        {
            id_user = listaUsuarios.get(i).getIDusuario();
            alq.listarAlquiler();
            
            for(int j = 0; j < listaAlquiler.size(); j++)
            {
                alq.listarAlquiler();
                if(id_user == listaAlquiler.get(j).getId_alq())
                {
                    aux = aux + listaAlquiler.get(j).getImporte();
                }
            }
            asiduos.add(id_user);
            asiduos2.add(aux);
        }
        Collections.sort(asiduos2);
        System.out.println(alq.listarAlquiler());
        
    }
    
    
}
