
package proyecto0.pkg1;
import java.util.Scanner;
public class Cliente extends Proyecto01{
    private String nombreUser;
    private String apellidoUser;
    private String numero_cedula;
    private String orden;
    private String TipodePago;
    private String FormadePago;
    public Cliente() {
        
    }
    /*public Usuarios(String nombreUser, String apellidoUser, String numero_cedula, String orden, String TipodePago, String FormadePago){
        this.nombreUser=nombreUser;
        this.apellidoUser=apellidoUser;
        this.orden=orden;
        this.TipodePago=TipodePago;
        this.FormadePago=FormadePago;
    }*/

    public void op2Usuario(){
        Scanner scanner = new Scanner(System.in);
         System.out.println("\nCajero: Como desea pagar? (Datos o Consumidor final)");
         TipodePago=scanner.nextLine().trim();
         while (!TipodePago.equalsIgnoreCase("Datos") && !TipodePago.equalsIgnoreCase("Consumidor Final")){
             System.out.print("Ingrese un mensaje valido (Datos o Consumidor final)");
             TipodePago=scanner.nextLine().trim();
         }
         if(TipodePago.equalsIgnoreCase("Datos")){
             System.out.println("\nCajero: Ingrese porfavor su numero de cedula: ");
             numero_cedula=scanner.nextLine();
         }
         System.out.print("\nCajero: Indique porfavor la forma de pago (Tarjeta o En efectivo)");
         FormadePago=scanner.nextLine().trim();
         while (!FormadePago.equalsIgnoreCase("Tarjeta") && !FormadePago.equalsIgnoreCase("En efectivo")){
             System.out.print("Ingrese un mensaje valido (Tarjeta o En efectivo)");
             FormadePago=scanner.nextLine().trim();
         }
         if (FormadePago.equalsIgnoreCase("Tarjeta")) {
         System.out.println("\nCajero: Deme su tarjeta ");
         System.out.println("\n Tarjeta entregado ");
         } else {
         System.out.println("\nCajero: Deme su dinero ");
         System.out.println("\n Dinero entregado");
         
         System.out.println("\nCajero: Espere su factura por favor ");
       }
    }  
}
