import java.io.Serializable;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.File;
import java.util.Scanner;
import java.io.ObjectOutputStream;

/**
 Dado el JAVABean en imagen adjunta, escriba un programa JAVA que
 serialize la misma en un archivo "empleados.dat" en la carpeta
 actual, excepto el atributo "id". Sobreescriba el método
 toString() en consecuencia.
 */
public class Empleado implements Serializable
{
    
    private transient int id; //le saco la serializacion
    private String nombre;
    private int salario;

    public Empleado()
    {
    }

    public Empleado (String nombre, int salario){
        this.nombre=nombre;
        this.salario=salario;
    }
    
    public int getId(){
        return id;
    }
    
    public void setId(int id){
        this.id=id;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public void setNombres(String nombre){
        this.nombre=nombre;
    }
    
    public int getSalario(){
        return salario;
    }
    
    public void setSalario(int salario){
        this.salario=salario;
    }
    
    //sobreescritura del toString
    
    public String toString(){
        
        if(id==0){
            String texto="no disponible";
            return "Id: NO DISPONIBLE" +  " Nombre: "+ nombre + " Salario: " + salario ;
        }else{
            return "Id: " + id + " Nombre: "+ nombre + " Salario: " + salario; 
            
        }
        
    }
    
    public static void main(){
        FileInputStream in= null;
        FileOutputStream out = null;
        Scanner teclado= new Scanner(System.in);
        
        try
        {
            
            System.out.println("Ingrese el nombre del empleado");
            String nombre = teclado.nextLine();
            
            System.out.println("Ingrese el salario del empleado");
            int salario = teclado.nextInt();

            
            Empleado e= new Empleado(nombre, salario);
            //Serializar el objeto (excepto id) y escribirlo en el archivo "empleados.dat"
            
            File f = new File("empleados.dat");
            f.createNewFile();
            out = new FileOutputStream(f);
            ObjectOutputStream objectOut= new ObjectOutputStream(out); //serializar un objeto de tipo Empleado y escribirlo en un archivo llamado "empleados.dat" se utiliza para serializar objetos en Java
            
            //asignar el id antes de serializar
            e.setId(100);
            //serializar y escribir el objeto
            objectOut.writeObject(e);
            
            System.out.println("El objeto a sido serializado");
            
        }
        catch (java.io.IOException ioe)
        {
            ioe.printStackTrace();
        }finally{
            if(in!=null){
                try
                {
                    in.close();
                }
                catch (java.io.IOException ioe)
                {
                    ioe.printStackTrace();
                }
            }
            if(out!=null){
                try
                {
                    out.close();
                }
                catch (java.io.IOException ioe)
                {
                    ioe.printStackTrace();
                }
            }
        }
        
        /**
         * out.write(e.setId(idE));, out.write(e.setNombres(nom)); y out.write(e.setSalario(sal)); 
         * no se puede utilizar para escribir los atributos id, nombre y salario en un archivo directamente de esa manera.
         * son métodos de la clase Empleado que no devuelven ningún valor para escribir directamente en un flujo de salida (OutputStream)
         * Estos métodos simplemente establecen los valores de los atributos del objeto Empleado, no devuelven datos que puedan ser 
         * escritos directamente en un archivo.
         * Para almacenar los datos de id, nombre y salario en un archivo, generalmente se serializa el objeto Empleado usando 
         * ObjectOutputStream y antes pasar los parametros por el CONSTRUCTOR Empleado e= new Empleado(nombre, salario);
         */
    
    }
}
