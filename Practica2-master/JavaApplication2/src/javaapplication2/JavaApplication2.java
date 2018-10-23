/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;
import java.text.ParseException;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 *
 * @author Ivan Zamora
 */
public class JavaApplication2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
        Scanner entrada = new Scanner(System.in);
        boolean salir = false;
        int opcion = 0;
        Usuario u = new Usuario();
        Objeto o = new Objeto();
        u.crearUsuarios();
        o.crearObjetos();
        System.out.println("-- Bienvenido a la gestión del STARTUP -- \n");
        while(!salir)
        {
            System.out.println("1 – Alta de usuario");
            System.out.println("2 – Alta de objeto");
            System.out.println("3 – Alquiler de objeto");
            System.out.println("4 – Listar todos los objetos");
            System.out.println("5 – Baja de objeto");
            System.out.println("6 – Mostrar saldos");
            System.out.println("7 – Cambiar importe por dia de un objeto");
            System.out.println("8 - Guardar en fichero");
            System.out.println("9 – Baja de un usuario");
            System.out.println("10 - Listar mas asiduos");
            System.out.println("11 – Salir");
            
            System.out.print("Escribe el numero de la opcion deseada: ");
            opcion = entrada.nextInt();
            try
            {
                switch(opcion)
                {
                    case 1:
                        System.out.println("Se ha seleccionado la opcion de alta de usuario \n");
                        AltaUsuario au = new AltaUsuario();
                        break;
                    
                    case 2:
                        System.out.println("Se ha seleccionado la opcion de alta de objeto \n");
                        AltaObjeto ao = new AltaObjeto();
                        break;
                    
                    case 3:
                        System.out.println("Se ha seleccionado la opcion de alquiler de objeto \n");
                        AlquilerObjeto aol = new AlquilerObjeto();
                        break;
                    
                    case 4:
                        System.out.println("Se ha seleccionado la opcion de listar todos los objetos \n");
                        ListaObjeto lo = new ListaObjeto();
                        break;
                    
                    case 5:
                        System.out.println("Se ha seleccionado la opcion de baja de objeto \n");
                        BajaObjeto bo = new BajaObjeto();
                        break;
                    
                    case 6:
                        System.out.println("Se ha seleccionado la opcion de mostrar saldos \n");
                        MostrarSaldos ms = new MostrarSaldos();
                        break;
                        
                    case 7:
                        System.out.println("Se ha secleccionado la opcion de modificar el importe por dia");
                        ModificarImporte mi = new ModificarImporte();
                        break;
                        
                    case 8:
                        System.out.println("Se ha secleccionado la opcion de modificar el importe por dia");
                        GuardarFichero gf = new GuardarFichero();
                        break; 
                        
                    case 9:
                        System.out.println("Se ha secleccionado la opcion de modificar el importe por dia");
                        BajaUsuario bu = new BajaUsuario();
                        break;
                        
                    case 10:
                        System.out.println("Se ha secleccionado la opcion listar mas asiduos");
                        ListarAsiduos la = new ListarAsiduos();
                        break;
                        
                    case 11:
                        System.out.println("Gracias por usar la aplicacion \n");
                        salir = true;
                        System.exit(0);
                        break;
                        
                    default:
                        System.out.println("Solo se admiten los numeros listados en el menu \n");
                        break;
                }
            }
            catch (InputMismatchException e) 
            {
                System.out.println("Solo se aceptan numeros \n");
                entrada.next();
            }
            
        }
    }
    
}
