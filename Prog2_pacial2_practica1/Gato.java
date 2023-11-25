import java.util.Objects;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
/**
 Dada la Clase en código adjunto en imagen, se pide (con libre criterio) :
- Sobreescriba el método toString().
- Sobreescriba el método equals(), asumiendo como "Criterio de comparación" el nombre.
- "Normalizando" a minúsculas, ordene en forma alfabética por nombre en forma descendente.
 */
public class Gato implements Comparable <Gato>
{
    //La interfaz Comparable<T> en Java es una interfaz genérica que especifica un contrato para comparar instancias de la clase que la 
    //implementa. Esta interfaz tiene un solo método llamado compareTo() que debe ser implementado por la clase para proporcionar la 
    //lógica de comparación.
    private String nombre;
    private String color;
    private String raza;
    
    public Gato (String nombre, String color, String raza){
        this.nombre= nombre;
        this.color=color;
        this.raza=raza;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public String getRaza(){
        return raza;
    }
    
    public String toString(){
        return "gato: "+ nombre+ " color: "+ color+" raza: "+raza;
    }
    
    public boolean equals(Object o){
        if(this==o)return true;
        
        if(o==null||getClass()!=o.getClass()) return false;
        
        Gato g= (Gato) o;
        
        return Objects.equals(nombre.toLowerCase(), g.nombre.toLowerCase());
        //se utiliza Objects.equals() para comparar los nombres normalizados a minúsculas en lugar de simplemente usar == para comparar 
        //las referencias de las cadenas (String). Esto se hace para garantizar una comparación adecuada y precisa de los nombres de los 
        //gatos
    }
    
    public int compareTo(Gato otroGato){
        String nombre1=this.nombre.toLowerCase();
        String nombre2=otroGato.nombre.toLowerCase();
        return nombre2.compareTo(nombre1);
        //compareTo() de String. Devuelve un número negativo si el nombre del otro gato precede al nombre de este gato en orden lexicográfico
        //(indicando un orden descendente), cero si los nombres son iguales y un número positivo si el nombre de este gato precede al 
        //nombre del otro gato (indicando un orden ascendente).
    }
    
    public static void main(String[] args){
    
        List <Gato> gatos = new ArrayList();
        
        gatos.add(new Gato("Pepe", "negro", "otro"));
        gatos.add(new Gato("Jose", "naranja", "egipcio"));
        gatos.add(new Gato("michi", "gris", "atigrado"));
        
        // Ordenar la lista de gatos por nombre en forma descendente
        Collections.sort(gatos);
        //Cuando llamas a Collections.sort(gatos), la función sort() utiliza el método compareTo() internamente para comparar 
        //y ordenar los elementos de la lista de gatos.
        for(Gato gato:gatos){
            System.out.println(gato);
        }
        
        
    } 
    
}
