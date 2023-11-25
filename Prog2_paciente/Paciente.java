
public class Paciente
{
    // instance variables - replace the example below with your own
    private String nombre;
    private String apellido;
    private int edad;
    private int dni;
    private char sexo;
    private int peso;
    private int altura;
    
    //constructores
    public Paciente()
    {
        
    }
    public Paciente (int dni,String nombre){
        this.dni=dni;
        this.nombre=nombre;
    }
    public Paciente (int dni,String nombre,String apellido,int edad,char sexo){
        this.dni=dni;
        this.nombre=nombre;
        this.apellido=apellido;
        this.edad=edad;
        this.sexo=sexo;
    }
    public Paciente (int dni,String nombre,String apellido,int edad,char sexo,int peso, int altura){
        this.dni=dni;
        this.nombre=nombre;
        this.apellido=apellido;
        this.edad=edad;
        this.sexo=sexo;
        this.peso=peso;
        this.altura=altura;
    }
    //getter y seter
    
    public void setDni(int dni){
        this.dni=dni;
    }
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    public void setApellido(String apellido){
        this.apellido=apellido;
    }
    public void setEdad(int edad){
        this.edad=edad;
    }
    public void setSexo(char sexo){
        this.sexo=sexo;
    }
    public void setPeso(int peso){
        this.peso=peso;
    }
    public void setAltura(int altura){
        this.altura=altura;
    }
    
    public int getEdad(){
        return edad;
    }
    public String getNombre(){
        return nombre;
    }
    public int getDni(){
        return dni;
    }
    public String getApellido(){
        return apellido;
    }
    public char getSexo(){
        return sexo;
    }
    public int getPeso(){
        return peso;
    }
    public int getAltura(){
        return altura;
    }
    
    public int calcularIMC(int peso,int altura){
        double resultado= peso/Math.pow(altura,2);
        if(resultado<20){
            return -1;
        }else{
            if(resultado>20||resultado<=25){
                return 0;
            }else{
                return 1;
            }
        }
        
    }
    
    public boolean esMayorDeEdad(int edad){
        if(edad<18){
            return false;
        }else{
            return true;
        }
    }
    
    public void comprobarSexo(char sexo){
        switch(sexo){
            case 'M':
                System.out.println("ingreso femenino");
                break;
            case 'm':
                System.out.println("ingreso femenino");
                break;
                
            case 'H':
                System.out.println("ingreso masculino");
                break;
            case 'h':
                System.out.println("ingreso masculino");
                break;
                
            default:
                System.out.println("ingreso un valor incorrecto");
        
        }
    }
    
    public void Persona(int dni,String nombre,String apellido,int edad,char sexo,int peso, int altura){
        System.out.println("nombre de la persona"+ nombre);
        System.out.println("apellido de la persona"+ apellido);
        System.out.println("dni de la persona"+ dni);
        System.out.println("edad de la persona"+ edad);
        System.out.println("sexo de la persona"+ sexo);
        System.out.println("peso de la persona"+ peso);
        System.out.println("altura de la persona"+ altura);
    }
    
    
}
