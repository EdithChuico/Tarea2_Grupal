package com.mycompany.p1tarea2_chuico_jimenez_risco;

import java.util.Scanner;
import java.io.*;
import org.json.simple.JSONObject;

public class Cliente extends Restaurante {
      Mesero a = new Mesero("","","","",1,1,1,1,"","","");
     // Restaurante d= new Restaurante("");
    public String nombreUser;
    public String apellidoUser;
    public String Cedula;
    public String TipodePago;
   public String FormadePago;
   public String monto;
   public float cambio;
    public String getNombreUser() {
        return this.nombreUser;
    }

    public String getApellidoUser() {
        return this.apellidoUser;
    }

    public String getNumeroCedula() {
        return this.Cedula;
    }
    public String getTipodePago() {
        return TipodePago;
    }
    public String getFormadePago() {
        return FormadePago;
    }

    public Cliente(String nombreUser, String apellidoUser, String Cedula, String TipodePago, String FormadePago, String monto, float cambio, String opcionUsuario) {
        super(opcionUsuario);
        this.nombreUser = nombreUser;
        this.apellidoUser = apellidoUser;
        this.Cedula = Cedula;
        this.TipodePago = TipodePago;
        this.FormadePago = FormadePago;
        this.monto = monto;
        this.cambio = cambio;
    }

    
    
      public void PagarcrearInfoCSV(Mesero mesero) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("=========== Registro de los datos del cliente para el pago ===========");
    System.out.print("Ingrese su nombre: ");
    nombreUser=scanner.nextLine();
    while(!nombreUser.matches("[a-zA-Z]+")){
          System.out.print("Ingrese palabras sin datos numericos: ");
          nombreUser=scanner.nextLine();
         }
    System.out.print("Ingrese su apellido: ");
    apellidoUser=scanner.nextLine();
    while(!apellidoUser.matches("[a-zA-Z]+")){
          System.out.print("Ingrese palabras sin datos numericos: ");
          apellidoUser=scanner.nextLine();
         }
    System.out.print("Ingrese su n de cedula: ");
    Cedula=scanner.nextLine();
    while (!Cedula.matches("\\d+") && Cedula.length() != 10){
            System.out.print("Dato no valido, debe tener 10 digitos y ser solo numeros: ");
            Cedula=scanner.nextLine();
        }
        while (!Cedula.matches("\\d+") || Cedula.length() != 10){
            System.out.print("Dato no valido, debe tener 10 digitos y ser solo numeros: ");
            Cedula=scanner.nextLine();
        }
        System.out.println("===================================");
         System.out.println("\nCajero: Como desea pagar? (Transferencia o Efectivo)");
         FormadePago=scanner.nextLine().trim();
         while (!FormadePago.equalsIgnoreCase("Transferencia") && !FormadePago.equalsIgnoreCase("Efectivo")){
             System.out.print("Ingrese un mensaje valido (Transferencia o Efectivo)");
             FormadePago=scanner.nextLine().trim();
         }
         if (FormadePago.equalsIgnoreCase("Transferencia")) {
         System.out.println("\nCajero: Listo! Aquí tiene el numero de cuenta al cual debe realizar la transferencia: \n"+ "2209900366");
         System.out.print("\nCajero: Espere su factura por favor \n"); 
         float precioFloat = mesero.getPrecio();
        String precioString = Float.toString(precioFloat);
         RegistroClientesCSV.crearArchivoCSV(" | ",nombreUser+"     ",apellidoUser+ "        ",Cedula +"    ", precioString);
         } else {
         //Mesero s= new Mesero("","","","",1,1,1,1,"","","");
         System.out.println("Cajero: Listo, el total de pago es " + mesero.getPrecio());
         System.out.println("Ingrese el monto porfavor: ");
         monto= scanner.nextLine();
        while (!monto.matches("\\d+")){
             System.out.print("Dato no valido, indique el monto en numero: ");
             monto=scanner.nextLine();
         }
        float fmonto = Float.parseFloat(monto);
        while(fmonto<mesero.getPrecio()){
            System.out.print("El monto ingresado es insuficiente, intente de nuevo porfavor: ");
            monto= Float.toString(fmonto);
            monto= scanner.nextLine();
            while (!monto.matches("\\d+")){
             System.out.print("Dato no valido, indique el monto en numero: ");
             monto=scanner.nextLine();
         }
        fmonto = Float.parseFloat(monto);
        }
        if( fmonto>mesero.getPrecio()){
            System.out.print("Listo, su cambio es:");
            cambio= fmonto-mesero.getPrecio();
            System.out.print(cambio+"\n");
            
    }
        System.out.print("\nCajero: Espere su factura por favor \n");  
       float precioFloat = mesero.getPrecio();
        String precioString = Float.toString(precioFloat);
        RegistroClientesCSV.crearArchivoCSV(" | ",nombreUser+"     ",apellidoUser+ "        ",Cedula +"    ", precioString);
}}   
    public void verMenu (){
        System.out.print("**** Este archivo se imprime mediante txt ****");
        System.out.print("\n=======MENU========\n ");
        Menu a = new Menu();
        System.out.println(a.leerTXT( "Menu.txt"));
    }
    public void imprimir(Mesero mesero) {

    System.out.println("               Don Kamaron            ");
    System.out.println("     ====================================");
    System.out.println("     Ciente: "+nombreUser +" "+ apellidoUser);
    System.out.println("     Identificacion: "+Cedula);
    //System.out.println("Forma de pago: "+mesero.getPago());
    System.out.println("     ====================================");
    System.out.println("     Descripcion     ");
    System.out.println("     "+(mesero.getMenu1()));
    System.out.println("     "+(mesero.getMenu2()));
    System.out.println("     "+(mesero.getMenu3()));
    System.out.println("     ====================================");
    System.out.println("      Total= " + mesero.getPrecio());
    //Guardado en archivo.jsona
    JSONObject facturaJSON = new JSONObject();
        facturaJSON.put("Cliente" +  nombreUser + " " + apellidoUser, "");
        facturaJSON.put("Identificacion"+ Cedula,"");
        facturaJSON.put("FormaPago"+ FormadePago,"");
        
    JSONObject productos = new JSONObject();
        productos.put(mesero.getMenu1(), "");
        productos.put(mesero.getMenu2(), "");
        productos.put(mesero.getMenu3(), "");
        
        facturaJSON.put("Productos", productos);
        facturaJSON.put("Total",4.50);
        
        String archivoFactura = "Factura.json";
        try (FileWriter file = new FileWriter(archivoFactura)) {
            file.write(facturaJSON.toJSONString());
            System.out.println("\nSe ha guardado la factura en el archivo JSON correctamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


