package clasesOperativas;

import java.io.*;

public class SerializarObjeto {
    //     C:\Users\sebas\Documents\SEBASTIAN\Topicos\Proyecto_Topicos\src\clientes
    public static boolean serializarObjeto(String rutaArchivo, Serializable objeto){
        boolean sw = false;
        try(FileOutputStream fos = new FileOutputStream(rutaArchivo);
            ObjectOutputStream salida = new ObjectOutputStream(fos);) {
            salida.writeObject(objeto);
            sw = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return sw;
    }
    public static <E> E desealizarObjeto(String rutaArchivo, Class<E> claseObjetivo){
        E objeto = null;
        try(FileInputStream fis = new FileInputStream(rutaArchivo);
            ObjectInputStream entrada = new ObjectInputStream(fis);){
            objeto = (E) entrada.readObject();
        }catch (Exception e){
            e.printStackTrace();
        }
        return objeto;
    }
}
