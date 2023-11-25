import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

/** 
Escriba (con libre criterio) un programa JAVA que cree una Colección de objetos String, 
la "pueble" con datos ingresados por teclado, y luego la muestre por 
pantalla ordenada alfabéticamente en forma inversa.
 */
public class Objetos
{
    public static void main(){
        ArrayList<String>datos= new ArrayList<String>();
        
        Scanner teclado= new Scanner(System.in);
        
        System.out.println("Ingrese los objetos que desea poner en la coleccion, para terminar escriba 'fin'");
        //leer objetos hasta que el usuario escriba fin
        
        while(true){
            String objetos=teclado.nextLine();
            if(objetos.equalsIgnoreCase("fin")){
                break;
            }
            datos.add(objetos);
        }
        
        // Ordenar la lista en forma inversa
        Collections.sort(datos,Collections.reverseOrder());
        //para ordenar la lista de forma normal:
        //Collections.sort(datos);
        
        System.out.println("Los datos ingresados se mostraran de forma inversa: "+ datos);
        
    
    }
}
