package proyecto0.pkg1;
import java.io.*;
        
public class Archivo {
    public String leerTXT(String direccion){//direccion del archivo
        String texto = "";
        
        try {
            BufferedReader bf = new BufferedReader (new FileReader (direccion));
            String linea;
            while ((linea = bf.readLine()) != null) {
                System.out.println(linea);
            }   
        }catch (IOException e){
            System.err.println("No se encontro el archivo");
        }
        return texto;
       
    }
}
