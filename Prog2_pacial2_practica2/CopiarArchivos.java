
/**
 * Escriba (con libre criterio) un programa JAVA que copie el contenido de un archivo de caracteres a otro.
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.*;

public class CopiarArchivos {
    public static void main(String[] args) {
        // Definir los nombres de los archivos
        String nombreArchivoOrigen = "ArchivoOriginal.txt";
        String nombreArchivoDestino = "Archivo2Copia.txt";

        try {
            // Verificar si el archivo de origen existe
            Path pathArchivoOrigen = Paths.get(nombreArchivoOrigen);

            if (!Files.exists(pathArchivoOrigen)) {
                // Crear el archivo de origen si no existe
                Files.createFile(pathArchivoOrigen);

                // Poblar el archivo de origen
                try (BufferedWriter out = Files.newBufferedWriter(pathArchivoOrigen)) {
                    out.write("Línea 1");
                    out.newLine();  // Agregar una nueva línea
                    out.write("Línea 2");
                }

                System.out.println("El archivo de origen ha sido creado y poblado.");
            }

            // Leer y copiar el contenido
            try (BufferedReader in = Files.newBufferedReader(pathArchivoOrigen);
                 BufferedWriter out = Files.newBufferedWriter(Paths.get(nombreArchivoDestino))) {

                String linea;

                while ((linea = in.readLine()) != null) {
                    out.write(linea);
                    out.newLine();  // Agregar una nueva línea
                }

                System.out.println("Contenido copiado de " + nombreArchivoOrigen + " a " + nombreArchivoDestino + ".");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



