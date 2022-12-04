package EntradaSalida_Datos;


import Modelos.Invitado;
import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author Lazaro
 */
public class AccesoDiscoDuro {
    static String ruta="dataBase.data";

    public static ArrayList<Invitado> cargarDatos() throws FileNotFoundException, IOException, ClassNotFoundException {
        File baseDatos = new File(ruta);
        FileInputStream entradaDatos= new FileInputStream(baseDatos);
        ObjectInputStream entradaObjetos= new ObjectInputStream(entradaDatos);
        
        ArrayList<Invitado> participantes = new ArrayList<>();
        
        int cantidadParticipantes = entradaObjetos.readInt();
        
        for(int i=0; i<cantidadParticipantes;i++){
            Invitado nuevo=(Invitado)entradaObjetos.readObject();
            participantes.add(nuevo);
        }
        
        return participantes;
    }
    
    public static void guardarDatos(ArrayList<Invitado> participantes) throws FileNotFoundException, IOException{
        
        File baseDatos = new File(ruta);
        FileOutputStream salidaDatos = new FileOutputStream(baseDatos);
        ObjectOutputStream salidaObjetos = new ObjectOutputStream(salidaDatos);
        
        int cantidad = participantes.size();
        salidaObjetos.writeInt(cantidad);
        
        for(int i=0;i<cantidad;i++){
            salidaObjetos.writeObject(participantes.get(i));
        }
        
        salidaObjetos.flush();
        salidaObjetos.close();
    }
    
}