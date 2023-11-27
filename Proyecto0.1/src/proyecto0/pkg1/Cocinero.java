
package proyecto0.pkg1;
import java.util.Scanner;
import java.lang.String;
public class Cocinero extends Proyecto01{
    Scanner scanner = new Scanner(System.in);
   public int opcion1;
   public int opcion2;
   public int opcion3;
   public int menuf;
   public String menu;//arreglo
   public void SeleccionMenu(){
   do{
   String[] menu={"Ninguno","Sopa de pollo","Sopa de verduras","Crema de brocoli","Ninguna","Arroz con pollo","Carne apanada","Pollo apanado","Camaron apanado","Ninguna","Jugo de naranja","Jugo de limon","Coctel de frutas","Pinia colada"}; 
   
   System.out.print("   ===  Hola soy el chef del restaurant, aqui tiene el menu del dia para que pueda ordenar lo que desee === \n");
   Archivo a = new Archivo ();
   System.out.println(a.leerTXT("C:\\Users\\HP\\Downloads\\Proyecto0.1\\Menu.txt"));
   System.out.print("\nSeleccione la opcion que desee del menu de acuerdo al digito de cada uno\n");
   System.out.print("Desea algo de entrada? (Seleccione desde la opcion 0 hasta 3):\n");
   opcion1 = scanner.nextInt();
   while (opcion1 <0 || opcion1>3){
      System.out.print("Opcion incorrecta, porfavor intente nuevamente: \n");
      opcion1 = scanner.nextInt();
   }
   System.out.print("Desea algo de segundo? (Seleccione desde la opcion 4 hasta 8):\n");
   opcion2 = scanner.nextInt();
   while (opcion2 <4 || opcion2>8){
      System.out.print("Opcion incorrecta, porfavor intente nuevamente:\n ");
      opcion2 = scanner.nextInt();
   }
   System.out.print("Desea algo de postres o bebidas? (Seleccione desde la opcion 9 hasta 13):\n");
   opcion3 = scanner.nextInt();
   while (opcion3 <9 || opcion3>13){
      System.out.print("Opcion incorrecta, porfavor intente nuevamente: \n");
      opcion3 = scanner.nextInt();
}
   System.out.println("Listo, su orden seria:\n" + "De entrada:" + menu[opcion1] + "\nAcompaniado con: " + menu[opcion2] + "\nY como postre o bebida: " + menu[opcion3]);
   System.out. println("Desea modificar la orden?\n" + "0: Si\n" + "1: No\n");
   menuf = scanner.nextInt();
   while (menuf <0 || menuf>1){
      System.out.print("Opcion incorrecta, porfavor intente nuevamente: \n");
      menuf = scanner.nextInt();
}
    }while(menuf!=1);
   }
}
