
package proyecto0.pkg1;
import java.util.Scanner;
public class Proyecto01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
  // Usuario usuario = new Usuario(); 
  int opcionUsuario;
        do {
            System.out.print("============Usuario============= ");
            System.out.print("\nQue desea hacer?");
            System.out.print("\n1. Observar el menu de comida" + "\n2. Hacer la orden y pagar"+"\n3. Salir del restaurante");
            System.out.println("\nEscoja una opcion: ");
            opcionUsuario = scanner.nextInt();
            while (opcionUsuario != 1 && opcionUsuario != 2 && opcionUsuario != 3) {
                System.out.println("Ingrese solo una opcion valida: ");
                opcionUsuario = scanner.nextInt();
            }
            switch (opcionUsuario) {
                case 1:
                    System.out.print("\n=======MENU========\n ");
                    Archivo a = new Archivo ();
                     System.out.println(a.leerTXT("C:\\Users\\HP\\Downloads\\Proyecto0.1\\Menu.txt"));
                    break;
                case 2:
                    Cocinero cocinero = new Cocinero();
                    cocinero.SeleccionMenu();
                    Cliente cliente = new Cliente();
                    cliente.op2Usuario();
                    break;
                case 3:
                    System.out.print("Saliendo ");
                    break;
                default:
            }
    }while (opcionUsuario != 3);

   
    }
}
/*menu del cliente
switch 
*/