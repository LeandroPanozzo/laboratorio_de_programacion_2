import java.io.Serializable;

import java.io.Serializable;

public class Vehiculo implements Serializable, Articulo
{
    
    private static int contadorId=1;
    private int id;
    private String marca;
    private String modelo;
    private String color;
    private String carroceria;
    private String ceroKm;
    private String year;
    private int kilometraje;
    private String enTaller;

    public Vehiculo(){
         this.id = contadorId;
        contadorId++;
    }
    
    
    public Vehiculo(String marca, String modelo, String color, String carroceria, String ceroKm, String year, int kilometraje, String enTaller) {
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.carroceria = carroceria;
        this.ceroKm = ceroKm;
        this.year = year;
        this.kilometraje = kilometraje;
        this.enTaller=enTaller;
        this.id=contadorId; //entonces cada vez que agregue un vehiculo a la arrayList se le asignara un id
        contadorId++;
    }
    
    // Getters
    public int getId(){
        return id;
    }

    public String getEnTaller() {
        return enTaller;
    }
    
    
    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getColor() {
        return color;
    }

    public String getCarroceria() {
        return carroceria;
    }

    public String getAno() {
        return year;
    }

    public int getKilometraje() {
        return kilometraje;
    }

    // Setters
    public void setId(int id){
        this.id=id;
    }

    public void setEnTaller(String enTaller) {
        this.enTaller = enTaller;
    }
    
    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setCarroceria(String carroceria) {
        this.carroceria = carroceria;
    }

    

    public void setAno(String year) {
        this.year = year;
    }

    public void setKilometraje(int kilometraje) {
        this.kilometraje = kilometraje;
    }
    
    //metodos
    public boolean disponible(String disp) {
        disp = disp.toLowerCase();
        return disp.equals("s");
    }
/***
 * 
 * El campo contadorId es privado, por lo que no puedes establecer su valor directamente con 
 * Vehiculo.contadorId = in.readInt(); al cargar desde el archivo
 */

    public static void setContadorId(int id) {
        contadorId = id;
    }
    
    public void mantenimiento(String mant) {
        mant = mant.toLowerCase();  // Assign the result back to mant
        if (mant.equals("s")) {
            System.out.println("Ya se realizó el mantenimiento");
        } else {
            System.out.println("Debe realizarse el mantenimiento");
        }
    }

    public boolean verificarAno(Integer year) {
        if (year >= 1886) {
            System.out.println("Año guardado");
            return true;
        } else {
            System.out.println("El año no puede ser negativo. Por favor, ingrese un año válido.");
            return false;
        }
    }


    public String toString() {
        return "Vehiculo" + " Marca: " + marca + " / " + "Modelo: " + modelo + " / " + "Color: " + color + " / "
                + "Carroceria: " + carroceria + " / " + "CeroKm: " + ceroKm + " / " + "Kilometraje: " + kilometraje
                + " / " + "Antiguedad: " + year;
    }
    
    public int km(int km){
        if(km>0){
            System.out.println("Se debe realizar mantenimiento en el taller");
            return 1;
        }else{
            if(km==0){
                System.out.println("no se debe realizar mantenimiento");
                return 0;
            }else{
                System.out.println("Ingreso un valor invalido, intentelo otra vez");
                return -1;
            }
        }
    
    }
    
}