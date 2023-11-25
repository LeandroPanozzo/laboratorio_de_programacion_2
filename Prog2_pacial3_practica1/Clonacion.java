import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
/**
 *  Escriba un programa JAVA que, asumiendo un archivo ya creado y poblado en la 
 carpeta actual, lo "clone" a un segundo archivo "apareado", mostrando el 
 contenido de este ultimo por pantalla.-
 */
public class Clonacion {
    public static void main(String[] args) {
        BufferedReader in = null;
        BufferedWriter out = null;

        try {
            // ARCHIVO ORIGEN
            File f = new File("Archivo1.txt");
            f.createNewFile();

            out = new BufferedWriter(new FileWriter(f));

            out.write("Linea 1\n");
            out.write("Linea 2\n");
            out.write("Linea 3\n");
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }

        try {
            // ARCHIVO DESTINO
            File f2 = new File("Archivo2.txt");
            f2.createNewFile();

            in = new BufferedReader(new FileReader("Archivo1.txt"));
            out = new BufferedWriter(new FileWriter(f2));

            String aux;

            while ((aux = in.readLine()) != null) {
                System.out.println(aux);
                out.write(aux + "\n");
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
                if (out != null) {
                    out.close();
                }
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
    }
}
