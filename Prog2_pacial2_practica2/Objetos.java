import java.io.Serializable;
import java.io.File;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileInputStream;

/**
 Escriba (con libre criterio) un programa JAVA que diseñe una Clase con 2 
 atributos, y serialize en un archivo la misma, pero incluyendo en la 
 serialización solo uno de los atributos.
 */
public class Objetos implements Serializable {
    
    private String nombre;
    private transient String id;

    public Objetos() {}

    public Objetos(String nombre, String id) {
        this.nombre = nombre;
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getId() {
        return id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setId(String id) {
        this.id = id;
    }

    public static void main(String[] args) {
        Objetos objeto = new Objetos("Ejemplo", "1243345");
        File f = new File("objetos.txt");

        ObjectOutputStream out = null;
        ObjectInputStream in = null;

        try {
            // Serialización
            f.createNewFile();
            out = new ObjectOutputStream(new FileOutputStream(f));
            out.writeObject(objeto);
            System.out.println("Archivo Serializado correctamente");

            // Deserialización (opcional)
            in = new ObjectInputStream(new FileInputStream(f));
            Objetos objetoDeserializado = (Objetos) in.readObject();
            System.out.println("Deserialización exitosa. Nombre: " + objetoDeserializado.getNombre());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}