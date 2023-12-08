package com.mycompany.p1tarea2_chuico_jimenez_risco;
import java.util.Scanner;
public class Mesero extends Restaurante {
    Scanner scanner = new Scanner(System.in);
   public String entrada;
   public String segundo;
   public String postre;
   public String menuf;
   public int entradaInt;
   public int segundoInt;
   public int postreInt;
   public float precio;

   public String[] menu={"Ninguno","Sopa de pollo","Sopa de verduras","Crema de brocoli","Ninguna","Arroz con pollo","Carne apanada","Pollo apanado","Camaron apanado","Ninguna","Jugo de naranja","Jugo de limon","Coctel de frutas","Pinia colada"};//arreglo
   public String getMenu1(){
       return this.menu[entradaInt];
   }
   public String getMenu2(){
       return this.menu[segundoInt];
   }
   public String getMenu3(){
       return this.menu[postreInt];
   }

    public float getPrecio() {
        return this.precio;
    }
   
    public Mesero(String entrada, String segundo, String postre, String menuf, int entradaInt, int segundoInt, int postreInt, float precio, String TipodePago, String FormadePago, String opcionUsuario) {
        super(opcionUsuario);
        this.entrada = entrada;
        this.segundo = segundo;
        this.postre = postre;
        this.menuf = menuf;
        this.entradaInt = entradaInt;
        this.segundoInt = segundoInt;
        this.postreInt = postreInt;
        //this.precio = precio;
    }
   public void tomarLaOrden(){
   do{ 
   
   System.out.print("            ===  Hola soy el mesero del restaurant. === \n"+ "=== Aqui tiene el menu del dia para que pueda ordenar lo que desee. === \n");
   Menu a = new Menu ();
   //System.out.print("**** Este archivo se imprime mediante txt ****");
     Cliente cliente = new Cliente("","","","","","",1,"");
   cliente.verMenu();
   precio=0;
   System.out.print("\nSeleccione la opcion que desee del menu de acuerdo al digito de cada uno\n");
   System.out.print("Desea algo de entrada? (Seleccione desde la opcion 0 hasta 3):\n");
   entrada=scanner.nextLine();
         while (!entrada.matches("\\d+") || Integer.parseInt(entrada) < 0 || Integer.parseInt(entrada) > 3){
             System.out.print("Dato no valido, indique la entrada con un numero (De 0 a 3): ");
             entrada=scanner.nextLine();
         }
          entradaInt = Integer.parseInt(entrada);
          if (entradaInt==1){
              precio+=1.50;
          }if (entradaInt==2){
              precio+=1.50;
          }if (entradaInt==3){
              precio+=2.50;
          }else{
              
              precio+=0;
          }
   System.out.print("Desea algo de segundo? (Seleccione desde la opcion 4 hasta 8):\n");
   segundo=scanner.nextLine();
         while (!segundo.matches("\\d+") || Integer.parseInt(segundo) < 4 || Integer.parseInt(segundo) > 8){
             System.out.print("Dato no valido, indique el segundo con un numero (De 4 a 8): ");
             segundo=scanner.nextLine();
         }
          segundoInt = Integer.parseInt(segundo);
          if (segundoInt==5){
              precio+=1.50;
          }if (segundoInt==6){
              precio+=2;
          }if (segundoInt==7){
              precio+=2;
          }if (segundoInt==8){
              precio+=2.50;
          }else{
              precio+=0;
          }
   System.out.print("Desea algo de postres o bebidas? (Seleccione desde la opcion 9 hasta 13):\n");
   postre=scanner.nextLine();
         while (!postre.matches("\\d+") || Integer.parseInt(postre) < 9 || Integer.parseInt(postre) > 13){
             System.out.print("Dato no valido, indique la postre con un numero (De 9 a 13): ");
             postre=scanner.nextLine();
         }
          postreInt = Integer.parseInt(postre);
          if (postreInt==10){
              precio+=0.50;
          }if (postreInt==11){
              precio+=0.50;
          }if (postreInt==12){
              precio+=3;
          }if (postreInt==13){
              precio+=5;
          }else{
              precio+=0;
          }
   System.out.println("Listo, su orden seria:\n" + "De entrada:" + menu[entradaInt] + "\nAcompaniado con: " + menu[segundoInt] + "\nY como postre o bebida: " + menu[postreInt]);
   System.out. println("Desea modificar la orden?\n" + "0: Si\n" + "1: No\n");
   menuf = scanner.nextLine();
        while (!menuf.matches("\\d+") || Integer.parseInt(menuf) < 0 || Integer.parseInt(menuf) > 1){
            System.out.print("Dato no valido, debe indicar 0 o 1 : ");
        menuf=scanner.nextLine();
        }
        //System.out.print(precio);
    }while(Integer.parseInt(menuf)!=1);
   System.out.print("Listo! En unos minutos su orden estara lista\n"+ "Buen provecho :)\n");
 
   }

}
