import java.util.Objects;
import java.io.Serializable;

/**
 Escriba (con libre criterio) un programa JAVA que diseñe una Clase que cumplimente el 
 Patrón JAVABean, con 2 atributos, y sobrescriba (tambien con libre criterio) los métodos 
 toString(), equals() y hashCode().
 */
public class Humano implements Serializable
{
    // instance variables - replace the example below with your own
    private int edad;
    private String nombre;

    public Humano()
    {
        
    }
    public Humano(int edad, String nombre){
    
        this.nombre=nombre;
        this.edad=edad;
    }
    
    //getter y setter
    
    public void setEdad(int edad){
        this.edad=edad;
    }
    
    public int getEdad(){
        return edad;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    
    //sobrescritura del toString
    
    public String toString(){
        return "persona: "+ "nombre: "+ nombre+" edad: "+ edad;
    
    }
    
    //sobrescritura de equals
    
    public boolean equals(Object o){ 
        //equals(Persona o) si pongo asi al hacer esto no estarías sobrescribiendo el método equals de la clase Object (que toma un parámetro de tipo Object), sino que estarías sobrecargando el método equals con una nueva firma.
        if(this==o)return true; //compara si ambas referencias apuntan al mismo objeto en la memoria en la que está almacenado el objeto en la memoria.
        //this se refiere a la instancia actual del objeto en la memoria
        if(o==null||getClass()!=o.getClass()) return false; //Si o es null, se devuelve false, si son de dos clases diferentes dan false tambien
        //getClass() != o.getClass() Si las clases no son iguales, significa que se está comparando la instancia actual con un objeto de una clase diferente
        Humano persona =(Humano)o; //casteo, convertimos el objeto o a uno de clase humano, pude dar ClassCastException
        return edad==persona.edad&& Objects.equals(nombre, persona.nombre);
        //Compara si la edad de la instancia actual (this) es igual a la edad de la instancia de Humano referenciada por la variable persona. Si ambas edades son iguales, esta parte de la expresión devuelve true.
        //Objects.equals(nombre, persona.nombre), nombre hace referencia al atributo nombre de la instancia actual (referenciada por this) y persona.nombre hace referencia al atributo nombre de la instancia de Humano referenciada por la variable persona.
    }
    
    //sobrescritura hashCode
    
    public int hashCode(){
        return Objects.hash(nombre, edad);
        //stá llamando al método hash de la clase Objects en Java para generar un hashcode basado en los valores de nombre y edad
    }
    
    public static void main(String[] args){
    
        Humano p1= new Humano(30,"Jose");
        Humano p2= new Humano(20,"Pepe");
        
        System.out.println("persona 1 " + p1);
        System.out.println("persona 2 "+ p2);
        
        System.out.println("Las personas son iguales?"+ p1.equals(p2));
        System.out.println("Hashcode de la persona 1"+ p1.hashCode());
        System.out.println("Hashcode de la persona 2"+ p2.hashCode());
    }
}
