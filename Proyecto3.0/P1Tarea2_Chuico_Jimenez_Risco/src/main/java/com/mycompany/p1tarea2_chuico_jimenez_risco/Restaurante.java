package com.mycompany.p1tarea2_chuico_jimenez_risco;
import java.util.Scanner;
import java.io.*;

public class Restaurante {
    public String opcionUsuario;
    public Restaurante( String opcionUsuario) {
           this.opcionUsuario = opcionUsuario;
    }
    public void Acciones (){
        Scanner scanner= new Scanner(System.in);
        Cliente cliente = new Cliente("","","","","","",1,"");
        //Cajero cajero = new Cajero("","" ,"","","","");
        do {
            System.out.print("============Usuario============= ");
            System.out.print("\nQue desea hacer?");
            System.out.print("\n1. Observar el menu de comida" + "\n2. Hacer la orden y pagar"+"\n3. Leer datos del cliente guardados en CSV"+"\n4. Salir del restaurante");
            System.out.println("\nEscoja una opcion: ");
            opcionUsuario=scanner.nextLine();
         while (!opcionUsuario.matches("\\d+") || Integer.parseInt(opcionUsuario) < 1 || Integer.parseInt(opcionUsuario) > 4){
             System.out.print("Opcion no valida, indique la cantidad con un numero (De 1 a 4): ");
             opcionUsuario=scanner.nextLine();
         }
         int opcion= Integer.parseInt(opcionUsuario);
            switch (opcion){
                case 1:
                    cliente.verMenu();
                    break;
                case 2:
                    Mesero mesero = new Mesero("","","","",1,1,1,1,"","","");
                    mesero.tomarLaOrden();
                    
                    cliente.PagarcrearInfoCSV(mesero);
                    cliente.imprimir( mesero);
                    break;
                case 3:
                    leerArchivoCSV();
                    break;
                case 4:
                    System.out.print("Saliendo ");
                    break;
                default:
            }
    }while (Integer.parseInt(opcionUsuario)!=4);
}
    public class Menu {
    public String leerTXT(String direccion){//direccion del archivo
        String texto = "";
        
        try {
            BufferedReader bf = new BufferedReader (new FileReader ("Menu.txt"));
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
    public  void guardarMenu (){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Menu.txt"))) {
            writer.write("Menu\n");
            writer.write("ENTRADAS\n");
            writer.write("0= Ninguno\n");
            writer.write("1 = Sopa de pollo ($ 1,50)\n");
            writer.write("2 = Sopa de verduras ($ 1,50)\n");
            writer.write("3 = Crema de brocoli ($ 2,50)\n");
            writer.write("SEGUNDO\n");
            writer.write("4 = Ninguna \n");
            writer.write("5 = Arroz con pollo ($ 1,50)\n");
            writer.write("6 = Carne apanada ($ 2,00)\n");
            writer.write("7 = Pollo apanado ($ 2,00)\n");
            writer.write("8 = Camaron apanado ($ 2,50)\n");
            writer.write("POSTRES Y BEBIDAS\n");
            writer.write("9 = Ninguna\n");
            writer.write("10 = Jugo de naranja ($ 0,50)\n");
            writer.write("11 = Jugo de limon ($ 0,50)\n");
            writer.write("12 = Coctel de frutas ($ 3,00)\n");
            writer.write("13 = Pinia colada ($ 5,00)\n");
            System.out.println("Datos guardados en el archivo.");
        } catch (IOException e) {
            e.printStackTrace();
        }  
    }
  public class RegistroClientesCSV {
    public static void crearArchivoCSV(String delim, String... info) {
        final String NEXT_LINE = "\n";
        try {
            // Asisgnación del nombre con el que se va a guardar el archivo 
            String file = "RegistroCliente.csv";
            FileWriter fw = new FileWriter(file, true);

            // Encabezado del archivo CSV
            fw.append(NEXT_LINE);
            fw.append("| Nombre    | ").append("Apellido     |  ").append("Cedula      |").append("Valor total a pagar");
            fw.append(NEXT_LINE).append(delim);
            // Información del usuario
            for (String value : info) {
                fw.append(value).append(delim);
            }
            fw.append(NEXT_LINE);

            fw.flush();
            fw.close();
            System.out.println("Archivo CSV creado con éxito en: " + file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }  
}
    public void leerArchivoCSV() {
   final String DELIMITER = ",";
        try (BufferedReader br = new BufferedReader(new FileReader("RegistroCliente.csv"))) {
            String line;
            // Lee la primera línea del código
            line = br.readLine();
            System.out.println(line);
            // Lee todas las lineas del codigo en caso de que hayan
            while ((line = br.readLine()) != null) {
                String[] datos = line.split(DELIMITER);
                for (String dato : datos) {
                    System.out.print(dato + "\t");
                }
                System.out.println();
            }
        } catch (IOException e) {
            System.out.println("El archivo CSV aún no ha sido creado.");
        } 
    }
}



