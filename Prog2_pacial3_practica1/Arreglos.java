import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;

/**
 * Escriba un programa JAVA que, utilizando un Array de 75 caracteres, los escriba en un archivo en la carpeta actual. 
 * Luego, lea sólo los primeros 50 caracteres ingresados y los muestre por pantalla.
 */
public class Arreglos {
    public static void main(String[] args) {
        char[] caract = new char[75];

        // Rellenar el array de caracteres
        for (int i = 0; i < 75; i++) {
            caract[i] = 'a';
        }

        try {
            File file = new File("caracteres.txt");

            try (FileWriter fw = new FileWriter(file)) {
                fw.write(caract);
            }

            try (FileReader fr = new FileReader(file); BufferedReader br = new BufferedReader(fr)) {
                for (int i = 0; i < 50; i++) {
                    int c = br.read();
                    if (c != -1) {
                        System.out.print((char) c);
                    }
                }
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
