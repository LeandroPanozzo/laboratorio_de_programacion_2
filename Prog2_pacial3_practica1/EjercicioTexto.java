import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
/**
 * Escriba un programa JAVA que cree un archivo "Ejercicio1.txt" en la carpeta 
 actual, lo pueble con caracteres vía teclado, y luego lo recorra mostrando 
 por pantalla su contenido, suprimiendo los espacios en blanco. Por ejemplo, 
 si contiene : ""Hello world!", deberá mostrar : "Helloworld!"
 */
public class EjercicioTexto {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        try (BufferedWriter out = new BufferedWriter(new FileWriter("Ejercicio1.txt"))) {
            System.out.println("Ingrese el texto que desea poner en el archivo:");
            String datos = teclado.nextLine();
            out.write(datos);
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }

        // Mostrar el contenido del archivo sin espacios en blanco
        try (BufferedReader in = new BufferedReader(new FileReader("Ejercicio1.txt"))) {
            String line;
            while ((line = in.readLine()) != null) {
                // Elimina los espacios en blanco
                String contenido = line.replaceAll("\\s+", "");
                System.out.println(contenido);
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}
