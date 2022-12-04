package Principal;

import Modelos.Invitado;
import EntradaSalida_Datos.AccesoDiscoDuro;
import EntradaSalida_Datos.Consola;
import Excepciones.ErrorDeTipoDeDato;
import Excepciones.ErrorEntradaNoValida;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Lazaro
 */
public class Main {
        public static ArrayList<Invitado> invitados;
    
    public static void main(String[] args) {
        
            try {
                invitados= AccesoDiscoDuro.cargarDatos();
            } catch(FileNotFoundException ex){
                Consola.imprimirMensaje("No hay datos.");
                invitados=new ArrayList<>();
            } catch (IOException ex) {
                invitados=new ArrayList<>();
                System.out.println("IOExcepcion");
                Consola.imprimirMensaje(ex.getMessage());
            } catch (ClassNotFoundException ex) {
                invitados=new ArrayList<>();
                Consola.imprimirMensaje(ex.getMessage());
            }
        
        boolean funcionando=true;
        
        while(funcionando){
            
            Consola.mostrarOpciones();
            int opcion = Consola.ObtenerOpcion();
            
            
            if(opcion==1){
                invitados.add(Consola.entrarInvitado());
            }
            else if(opcion==2){
                Consola.mostrarInvitados(invitados);
            }
            else if(opcion==3){
                try{
                int participante = Consola.elegirInvitado();
                Consola.modificarInvitado(participante);
                }catch(ErrorDeTipoDeDato | ErrorEntradaNoValida e){
                        Consola.imprimirMensaje(e.getMessage());
                }
            }
            else if(opcion==4){
                int numeroParticipante;
                try {
                    numeroParticipante = Consola.elegirInvitado();
                    invitados.remove(numeroParticipante);
                    Consola.borrarInvitadoNotificacion();
                } catch (ErrorDeTipoDeDato | ErrorEntradaNoValida ex) {
                    Consola.imprimirMensaje(ex.getMessage());
                }
            }
            else if(opcion==5){
                try {
                    AccesoDiscoDuro.guardarDatos(invitados);
                    Consola.guardarCambiosNotificacion();
                } catch (IOException ex) {
                    Consola.imprimirMensaje(ex.getMessage());
                }
            }
            else if(opcion==6){
                Consola.salirNotificacion();
                System.exit(0);
            }
            
        }
    }
    
}
