package EntradaSalida_Datos;


import Excepciones.ErrorEntradaNoValida;
import Excepciones.ErrorDeTipoDeDato;
import java.util.Scanner;
import Modelos.Invitado;
import Principal.Main;
import static Principal.Main.invitados;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lazaro
 */
public class Consola {

    public static void mostrarOpciones() {
        System.out.println("Opciones:");
        System.out.println("1: Añadir invitado");
        System.out.println("2: Mostrar lista de invitados");
        System.out.println("3: Modificar Invitado");
        System.out.println("4: Borrar Invitado");
        System.out.println("5: Guardar cambios");
        System.out.println("6: Salir");
    }

    public static int ObtenerOpcion() throws ErrorDeTipoDeDato{
        
        Scanner read = new Scanner(System.in);
        int opcionEscogida = read.nextInt();
        
        return opcionEscogida;
    }
    
    /**
     * Opcion #1 de la consola
     * @return  objeto Participante
     */
    public static Invitado entrarInvitado(){
        Scanner read = new Scanner(System.in);
        
        System.out.println("\nAñadiendo invitado:");
        
        System.out.println("Diga el nombre: ");
        String nombre = read.nextLine();
        
        System.out.println("Diga los apellidos: ");
        String apellidos = read.nextLine();
        
        System.out.println("Diga el Carnet de identidad: ");
        long carnetIdentidad = read.nextInt();
        
        System.out.println("Diga la edad:");
        int edad = read.nextInt();
        
        Invitado nuevo = new Invitado(nombre, apellidos, carnetIdentidad, edad);
        return nuevo;
    }
    
    /**
     * Opcion #2 de la consola
     */
    public static void mostrarInvitados(ArrayList invitados){
        System.out.println("");
        for(int i=0;i<invitados.size();i++){
            System.out.print("Invitado #"+(i+1)+"  ");
            System.out.println(invitados.get(i).toString());
        }
            System.out.println("");
        
    }
    
    /**
     * Opcion #3 de la consola
     */
    public static void modificarInvitado(int numeroInvitado) throws ErrorDeTipoDeDato, ErrorEntradaNoValida{
        Scanner read = new Scanner(System.in);
        
        Invitado invitado = Invitado.get(numeroInvitado);
        
        System.out.println("Diga que dato desea cambiar.");
        System.out.println("1: Nombre.");
        System.out.println("2: Apellidos.");
        System.out.println("3: Carnet de identidad.");
        System.out.println("4: Edad.");
        System.out.println("5: Todo.");
        
        int opcion = read.nextInt();
        if(opcion>5 || opcion<1) throw new ErrorEntradaNoValida();
        
        if(opcion==1){
            String nombre=read.nextLine();
           invitado.setNombre(nombre);
        }
        else if(opcion==2){
            String apellidos=read.nextLine();
            invitado.setApellidos(apellidos);
        }
        else if(opcion==3){
            long carnetIdentidad=read.nextInt();
            invitado.setCarnetIdentidad(carnetIdentidad);
        }
        else if(opcion==4){
            int edad=read.nextInt();
            invitado.setEdad(edad);
        } 
        else{
           invitado= Consola.entrarInvitado();
        }
    }
    
    /**
     * Opcion #4 de la consola
     * (Es solo notificacion)
     */
    public static void borrarInvitadoNotificacion() {
        System.out.println("El Invitado fue borrado correctamente.");
    }
    
    /**
     * Opcion #5 de la consola
     * (Es solo notificacion)
     */
    public static void guardarCambiosNotificacion(){
        System.out.println("\nLos datos fueron guardados correctamente.");
    }
    
    /**
     * Opcion #6 de la consola
     */
    public static void salirNotificacion(){
        System.out.println("Tenga buen dia.");
    }
    
    /**
     * Pide al usuario elegir un participante
     * @return el numero de posicion en el arrayList
     * @throws ErrorDeTipoDeDato
     * @throws ErrorEntradaNoValida 
     */
    public static int elegirInvitado()throws ErrorDeTipoDeDato, ErrorEntradaNoValida{
        System.out.println("Diga el numero del invitado");
        
        Scanner read = new Scanner(System.in);
        int pos = read.nextInt();
        
        if(pos<1 || pos>Main.invitados.size()){
            throw new ErrorEntradaNoValida();
        }
        
        pos -- ;
        return pos;
    }
    
    /**
     * Imprime un mensaje de una linea por consola.
     * @param msg el mensaje a imprimir
     */
    public static void imprimirMensaje(String msg){
        System.out.println("\n"+msg);
    }
    
}