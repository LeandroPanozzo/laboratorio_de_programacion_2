
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Concesionaria {
    public static void main(String[] args) {
        
        try {
            
            File f= new File("vehiculos.txt");

            f.createNewFile();
            
            Scanner teclado= new Scanner(System.in);
            String marcaSelec;
            String modeloSelec;
            String colorSelec;
            String carroceriaSelec;
            String respuesta;
            String anoSelec;
            Integer kilometraje;
            

            ArrayList<Vehiculo> vehiculosCargados = new ArrayList<>();
            ArrayList<Vehiculo> vehiculo = new ArrayList<>();
            Vehiculo v1 = new Auto();
            Vehiculo v2 = new Moto();
            Vehiculo v3 = new Camioneta();
            

            boolean salir = false;
            
            do {
            System.out.println("                     CONSESIONARIA                          ");
            System.out.println("======================================================================================================");
            System.out.println("ingrese un numero para seleccionar una opcion");
            System.out.println("1- agregar vehiculos");
            System.out.println("2- eliminar vehiculos");
            System.out.println("3- mostrar todos los vehiculos ");
            System.out.println("4- mostrar lista de vehiculos a la venta ");
            System.out.println("5- mostrar lista de vehiculos en taller ");
            System.out.println("6- salir");
            int opcion1= teclado.nextInt();
            
            switch(opcion1){
                case 1:
                    // Cargar datos existentes al inicio
                    try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(f))) {
                        vehiculosCargados = (ArrayList<Vehiculo>) in.readObject();
                        System.out.println("Datos de vehículos cargados desde el archivo.");
                    } catch (IOException | ClassNotFoundException e) {
                        // Manejar la excepción si no hay datos existentes o hay un problema al cargarlos
                        System.out.println("No se pudieron cargar datos existentes: " + e.getMessage());
                    }


                   Random random = new Random();
                    int nuevaId = random.nextInt(1000);
                    do{
                        // Establece la nueva ID al vehículo
                        v1.setId(nuevaId);
                        System.out.println("=========================================================================================================");
                        System.out.println("ingrese 'a' si desea ingresar un automovil, 'm' si desea ingresar una motocicletas o 'c' si desea ingresar una camioneta");
                        String opcion = teclado.next();
                        
                        //convierto la entrada en minuscula
                        opcion = opcion.toLowerCase();
                        
                        switch(opcion){
                            case "a":
                                System.out.println("Selecciono automoviles");
                                
                                System.out.println("Seleccione una marca:(ingrese UNO, DOS, TRES dependiendo de su eleccion)");
                                for(Auto.Marcas marcas : Auto.Marcas.values()){
                                    System.out.println(marcas);
                                }
                               boolean repetir = true;
                                while (repetir) {
                                    marcaSelec = teclado.next().toLowerCase();
                                    switch (marcaSelec) {
                                        case "uno":
                                            v1.setMarca("Toyota");
                                            repetir = false;
                                            break;
                                        case "dos":
                                            v1.setMarca("Chevrolet");
                                            repetir = false;
                                            break;
                                        case "tres":
                                            v1.setMarca("Ford");
                                            repetir = false;
                                            break;
                                        default:
                                            System.out.println("Ingresó un valor incorrecto, inténtelo de nuevo");
                                            break;
                                    }
                                }

                                System.out.println("Seleccione un modelo:(ingrese UNO, DOS, TRES dependiendo de su eleccion)");
                                for(Auto.Modelo modelo : Auto.Modelo.values()){
                                    System.out.println(modelo);
                                }
                                repetir = true;
                                while (repetir) {
                                    modeloSelec = teclado.next().toLowerCase();
                                    switch (modeloSelec) {
                                        case "uno":
                                            v1.setModelo("Combustion");
                                            repetir = false;
                                            break;
                                        case "dos":
                                            v1.setModelo("Hibrido");
                                            repetir = false;
                                            break;
                                        case "tres":
                                            v1.setModelo("Electrico");
                                            repetir = false;
                                            break;
                                        default:
                                            System.out.println("Ingresó un valor incorrecto, inténtelo de nuevo");
                                            break;
                                    }
                                }
 
                                Integer year;
                                Boolean entradaValida=false;
                                
                                do {
                                    try {
                                        System.out.println("Escriba el año del Vehiculo");
                                        anoSelec = teclado.next();
                                        year = Integer.parseInt(anoSelec);
                                        entradaValida = v1.verificarAno(year);
                                        if (entradaValida) {
                                            v1.setAno(anoSelec);

                                        }
                                    } catch (NumberFormatException edadExcepsion) {
                                        System.out.println("Entrada no válida. Por favor, ingrese un año válido.");
                                    }
                                } while (!entradaValida);
                                
                                System.out.println("Seleccione un color:(ingrese UNO, DOS, TRES, CUATRO dependiendo de su eleccion)");
                                for(Auto.Color color : Auto.Color.values()){
                                    System.out.println(color);
                                }
                                repetir = true;
                                while (repetir) {
                                    colorSelec = teclado.next().toLowerCase();
                                    switch (colorSelec) {
                                        case "uno":
                                            v1.setColor("Azul");
                                            repetir = false;
                                            break;
                                        case "dos":
                                            v1.setColor("Rojo");
                                            repetir = false;
                                            break;
                                        case "tres":
                                            v1.setColor("Gris");
                                            repetir = false;
                                            break;
                                        case "cuatro":
                                            v1.setColor("Blanco");
                                            repetir = false;
                                            break;
                                        default:
                                            System.out.println("Ingresó un valor incorrecto, inténtelo de nuevo");
                                            break;
                                    }
                                }

                                System.out.println("Seleccione una carroceria:(ingrese UNO, DOS, TRES, CUATRO, CINCO dependiendo de su eleccion)");
                                for(Auto.Carroceria carroceria : Auto.Carroceria.values()){
                                    System.out.println(carroceria);
                                }
                                repetir = true;
                                while (repetir) {
                                    carroceriaSelec = teclado.next().toLowerCase();
                                    switch (carroceriaSelec) {
                                        case "uno":
                                            v1.setCarroceria("Familiar");
                                            repetir = false;
                                            break;
                                        case "dos":
                                            v1.setCarroceria("Hatchback");
                                            repetir = false;
                                            break;
                                        case "tres":
                                            v1.setCarroceria("Suv");
                                            repetir = false;
                                            break;
                                        case "cuatro":
                                            v1.setCarroceria("Coupe");
                                            repetir = false;
                                            break;
                                        case "cinco":
                                            v1.setCarroceria("Pickup");
                                            repetir = false;
                                            break;
                                        default:
                                            System.out.println("Ingresó un valor incorrecto, inténtelo de nuevo");
                                            break;
                                    }
                                }
                               Integer entradaKm = -1;

                                do {
                                try {
                                    System.out.println("Ingrese el kilometraje");
                                    kilometraje = teclado.nextInt();
                                    entradaKm = v1.km(kilometraje);

                                    if (entradaKm == 0 ) {
                                        v1.setKilometraje(kilometraje);                                      
                                        v1.setEnTaller("[A LA VENTA]");
                                    } else {
                                            if (entradaKm > 0) {
                                            // Crea una nueva instancia para cada vehículo en el taller
                                            Auto nuevaAuto = new Auto();
                                            v1.setKilometraje(kilometraje);
                                            nuevaAuto.setId(nuevaId);
                                            nuevaAuto.setKilometraje(kilometraje);

                                            System.out.println("Se lo llevará al taller, para revisarlo");
                                            v1.setEnTaller("[EN EL TALLER]");


                                            
                                        }

                                    }
                                } catch (InputMismatchException e) {
                                    System.out.println("Entrada no válida. Por favor, ingrese un número válido.");
                                    teclado.nextLine(); // Limpia el búfer de entrada
                                }
                            } while (entradaKm == -1);

                                
                                teclado.nextLine();
                                
                                int nuevoContadorId = vehiculosCargados.isEmpty() ? 1 : vehiculosCargados.size() + 1;
                                v1.setId(nuevoContadorId);

                                // Obtén una nueva ID aleatoria para el vehículo
                                nuevaId = random.nextInt(1000); // Elige un rango apropiado para tus IDs
                                v1.setId(nuevaId);
                                
                                vehiculo.add(v1);
                                vehiculosCargados.add(v1);
                                
                                System.out.println(" ");
                                System.out.println("================================================================================================");
                                System.out.println("Valores elegidos: ");
                                System.out.println("----------------------------------------------------------------------- ");
                                System.out.println("Marca:  "+ v1.getMarca());
                                System.out.println("Modelo: " + v1.getModelo());
                                System.out.println("Color: " + v1.getColor());
                                System.out.println("Carroceria: " + v1.getCarroceria());
                                System.out.println("Año " + v1.getAno());
                                System.out.println("Kilometraje: "+ v1.getKilometraje());
                                System.out.println("Condicion: "+ v1.getEnTaller());
                                //se guardaron los dartos
                                try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(f))) {
                                    out.writeObject(vehiculosCargados); // Escribe la lista completa de vehículos en el archivo
                                    System.out.println("Datos de vehículos guardados en el archivo.");
                                } catch (IOException e) {
                                    System.err.println("Error al escribir en el archivo: " + e.getMessage());
                                }
                                
                                break;
                                
                            case "m":
                                System.out.println("Selecciono motocicletas");
                                
                                System.out.println(" Seleccione una marca: (ingrese UNO, DOS, TRES dependiendo de su eleccion)");
                                for(Moto.Marcas marcas : Moto.Marcas.values()){
                                    System.out.println(marcas);
                                }
                                repetir = true;
                                while (repetir) {
                                    marcaSelec = teclado.next().toLowerCase();
                                    switch (marcaSelec) {
                                        case "uno":
                                            v2.setMarca("Zanella");
                                            repetir = false;
                                            break;
                                        case "dos":
                                            v2.setMarca("Guerreto");
                                            repetir = false;
                                            break;
                                        case "tres":
                                            v2.setMarca("Mondial");
                                            repetir = false;
                                            break;
                                        default:
                                            System.out.println("Ingresó un valor incorrecto, inténtelo de nuevo");
                                            break;
                                    }
                                }
                                
                                System.out.println("Seleccione un modelo:(ingrese UNO, DOS, TRES dependiendo de su eleccion)");
                                for(Moto.Modelo modelo : Moto.Modelo.values()){
                                    System.out.println(modelo);
                                }
                                repetir = true;
                                while (repetir) {
                                    modeloSelec = teclado.next().toLowerCase();
                                    switch (modeloSelec) {
                                        case "uno":
                                            v2.setModelo("Combustion");
                                            repetir = false;
                                            break;
                                        case "dos":
                                            v2.setModelo("Hibrido");
                                            repetir = false;
                                            break;
                                        case "tres":
                                            v2.setModelo("Electrico");
                                            repetir = false;
                                            break;
                                        default:
                                            System.out.println("Ingresó un valor incorrecto, inténtelo de nuevo");
                                            break;
                                    }
                                }
          
                                entradaValida=false;
                                
                                do {
                                    
                                        System.out.println("Escriba el año del Vehiculo");
                                        anoSelec = teclado.next();
                                        year = Integer.parseInt(anoSelec);
                                        entradaValida = v2.verificarAno(year);
                                        if (entradaValida) {
                                            v2.setAno(anoSelec);
                                            
                                        }else{
                                            System.out.println("Entrada no válida. Por favor, ingrese un año válido.");
                                        }       
                                    
                                } while (!entradaValida);
                                
                                System.out.println("Seleccione un color:(ingrese UNO, DOS, TRES, CUATRO dependiendo de su eleccion)");
                                for(Moto.Color color : Moto.Color.values()){
                                    System.out.println(color);
                                }
                                repetir = true;
                                while (repetir) {
                                    colorSelec = teclado.next().toLowerCase();
                                    switch (colorSelec) {
                                        case "uno":
                                            v2.setColor("Azul");
                                            repetir = false;
                                            break;
                                        case "dos":
                                            v2.setColor("Rojo");
                                            repetir = false;
                                            break;
                                        case "tres":
                                            v2.setColor("Gris");
                                            repetir = false;
                                            break;
                                        case "cuatro":
                                            v2.setColor("Blanco");
                                            repetir = false;
                                            break;
                                        default:
                                            System.out.println("Ingresó un valor incorrecto, inténtelo de nuevo");
                                            break;
                                    }
                                }
                                
                                System.out.println("Seleccione una carroceria:(ingrese UNO, DOS, TRES, CUATRO dependiendo de su eleccion)");
                                for(Moto.Carroceria carroceria : Moto.Carroceria.values()){
                                    System.out.println(carroceria);
                                }
                                repetir = true;
                                while (repetir) {
                                    carroceriaSelec = teclado.next().toLowerCase();
                                    switch (carroceriaSelec) {
                                        case "uno":
                                            v2.setCarroceria("Deportiva");
                                            repetir = false;
                                            break;
                                        case "dos":
                                            v2.setCarroceria("Scooter");
                                            repetir = false;
                                            break;
                                        case "tres":
                                            v2.setCarroceria("Choper");
                                            repetir = false;
                                            break;
                                        case "cuatro":
                                            v2.setCarroceria("Enduro");
                                            repetir = false;
                                            break;
                                        default:
                                            System.out.println("Ingresó un valor incorrecto, inténtelo de nuevo");
                                            break;
                                    }
                                }

                                entradaKm = -1;
                                

                                do {
                                try {
                                    System.out.println("Ingrese el kilometraje");
                                    kilometraje = teclado.nextInt();
                                    entradaKm = v2.km(kilometraje);

                                    if (entradaKm == 0 ) {
                                        v2.setKilometraje(kilometraje);                                      
                                        v2.setEnTaller("[A LA VENTA]");
                                    } else {
                                            if (entradaKm > 0) {
                                            // Crea una nueva instancia  para cada vehículo en el taller
                                            Auto nuevaAuto = new Auto();
                                            v2.setKilometraje(kilometraje);
                                            nuevaAuto.setId(nuevaId);
                                            nuevaAuto.setKilometraje(kilometraje);

                                            System.out.println("Se lo llevará al taller, para revisarlo");
                                            v2.setEnTaller("[EN EL TALLER]");
     
                                        }

                                    }
                                } catch (InputMismatchException e) {
                                    System.out.println("Entrada no válida. Por favor, ingrese un número válido.");
                                    teclado.nextLine(); // Limpia el búfer de entrada
                                }
                            } while (entradaKm == -1);


                                
                                teclado.nextLine();
                                nuevoContadorId = vehiculosCargados.isEmpty() ? 1 : vehiculosCargados.size() + 1;
                                v2.setId(nuevoContadorId);

                                // Obtén una nueva ID aleatoria para el vehículo
                                nuevaId = random.nextInt(1000); // Elige un rango apropiado para tus IDs
                                v2.setId(nuevaId);
                                
                                vehiculo.add(v2);
                                vehiculosCargados.add(v2);
                                
                                vehiculo.add(v2);
                                System.out.println(" ");
                                System.out.println("================================================================================================");
                                System.out.println("Valores elegidos: ");
                                System.out.println("----------------------------------------------------------------------- ");
                                System.out.println("Marca:  "+ v2.getMarca());
                                System.out.println("Modelo: " + v2.getModelo());
                                System.out.println("Color: " + v2.getColor());
                                System.out.println("Carroceria: " + v2.getCarroceria());
                                System.out.println("Año " + v2.getAno());
                                System.out.println("Kilometraje: "+ v2.getKilometraje());
                                System.out.println("Condicion: "+ v2.getEnTaller());
                                
                                //se guardaron los dartos
                                try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(f))) {
                                    out.writeObject(vehiculosCargados); // Escribe la lista completa de vehículos en el archivo
                                    System.out.println("Datos de vehículos guardados en el archivo.");
                                } catch (IOException e) {
                                    System.err.println("Error al escribir en el archivo: " + e.getMessage());
                                }
                                break;
                                
                                
                            case "c":
                                teclado.nextLine();
                                System.out.println("Selecciono Camioneta");
                                System.out.println("Seleccione una marca:(ingrese UNO, DOS, TRES, CUATRO dependiendo de su eleccion)");
                                for(Camioneta.Marcas marcas : Camioneta.Marcas.values()){
                                    System.out.println(marcas);
                                }
                                repetir = true;
                                while (repetir) {
                                    marcaSelec = teclado.next().toLowerCase();
                                    switch (marcaSelec) {
                                        case "uno":
                                            v3.setMarca("Toyots");
                                            repetir = false;
                                            break;
                                        case "dos":
                                            v3.setMarca("Chevrolet");
                                            repetir = false;
                                            break;
                                        case "tres":
                                            v3.setMarca("Ford");
                                            repetir = false;
                                            break;
                                        case "cuatro":
                                            v3.setMarca("Nissan");
                                            repetir = false;
                                            break;
                                        default:
                                            System.out.println("Ingresó un valor incorrecto, inténtelo de nuevo");
                                            break;
                                    }
                                }
                                
                                System.out.println("Seleccione un modelo:(ingrese UNO, DOS, TRES dependiendo de su eleccion)");
                                for(Camioneta.Modelo modelo : Camioneta.Modelo.values()){
                                    System.out.println(modelo);
                                }
                                repetir = true;
                                while (repetir) {
                                    modeloSelec = teclado.next().toLowerCase();
                                    switch (modeloSelec) {
                                        case "uno":
                                            v3.setModelo("Combustion");
                                            repetir = false;
                                            break;
                                        case "dos":
                                            v3.setModelo("Hibrido");
                                            repetir = false;
                                            break;
                                        case "tres":
                                            v3.setModelo("Electrico");
                                            repetir = false;
                                            break;
                                        default:
                                            System.out.println("Ingresó un valor incorrecto, inténtelo de nuevo");
                                            break;
                                    }
                                }
                                
                                entradaValida=false;
                                
                                do {
                                    
                                        System.out.println("Escriba el año del Vehiculo");
                                        anoSelec = teclado.next();
                                        year = Integer.parseInt(anoSelec);
                                        entradaValida = v3.verificarAno(year);
                                        if (entradaValida) {
                                            v3.setAno(anoSelec);
                                            
                                        
                                    
                                        System.out.println("Entrada no válida. Por favor, ingrese un año válido.");
                                    }
                                } while (!entradaValida);
                                
                                System.out.println("Seleccione un color:(ingrese UNO, DOS, TRES, CUATRO dependiendo de su eleccion)");
                                for(Camioneta.Color color : Camioneta.Color.values()){
                                    System.out.println(color);
                                }
                                repetir = true;
                                while (repetir) {
                                    colorSelec = teclado.next().toLowerCase();
                                    switch (colorSelec) {
                                        case "uno":
                                            v3.setColor("Azul");
                                            repetir = false;
                                            break;
                                        case "dos":
                                            v3.setColor("Rojo");
                                            repetir = false;
                                            break;
                                        case "tres":
                                            v3.setColor("Gris");
                                            repetir = false;
                                            break;
                                        case "cuatro":
                                            v3.setColor("Blanco");
                                            repetir = false;
                                            break;
                                        default:
                                            System.out.println("Ingresó un valor incorrecto, inténtelo de nuevo");
                                            break;
                                    }
                                }
                        
                                entradaKm = -1;
                                
                                do {
                                try {
                                    System.out.println("Ingrese el kilometraje");
                                    kilometraje = teclado.nextInt();
                                    entradaKm = v3.km(kilometraje);

                                    if (entradaKm == 0 ) {
                                        v3.setKilometraje(kilometraje);                                      
                                        v3.setEnTaller("[A LA VENTA]");
                                    } else {
                                            if (entradaKm > 0) {
                                            // Crea una nueva instancia para cada vehículo en el taller
                                            Auto nuevaAuto = new Auto();
                                            v3.setKilometraje(kilometraje);
                                            nuevaAuto.setId(nuevaId);
                                            nuevaAuto.setKilometraje(kilometraje);

                                            System.out.println("Se lo llevará al taller para revisarlo");
                                            v3.setEnTaller("[EN EL TALLER]");
                                            
                                        }

                                    }
                                } catch (InputMismatchException e) {
                                    System.out.println("Entrada no válida. Por favor, ingrese un número válido.");
                                    teclado.nextLine(); // Limpia el búfer de entrada
                                }
                            } while (entradaKm == -1);
                                
                                teclado.nextLine();
                                
                                nuevoContadorId = vehiculosCargados.isEmpty() ? 1 : vehiculosCargados.size() + 1;
                                v3.setId(nuevoContadorId);

                                // Obtén una nueva ID aleatoria para el vehículo
                                nuevaId = random.nextInt(1000); // Elige un rango apropiado para tus IDs
                                v3.setId(nuevaId);
                                
                                vehiculo.add(v3);
                                vehiculosCargados.add(v3);
                                
                                System.out.println(" ");
                                System.out.println("================================================================================================");
                                System.out.println("Valores elegidos: ");
                                System.out.println("----------------------------------------------------------------------- ");
                                System.out.println("Marca:  "+ v3.getMarca());
                                System.out.println("Modelo: " + v3.getModelo());
                                System.out.println("Color: " + v3.getColor());
                                System.out.println("Año " + v3.getAno());
                                System.out.println("Kilometraje: "+ v3.getKilometraje());
                                System.out.println("Carroceria: "+ v3.getEnTaller());
                                //se guardaron los dartos
                                try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(f))) {
                                    out.writeObject(vehiculosCargados); // Escribe la lista completa de vehículos en el archivo
                                    System.out.println("Datos de vehículos guardados en el archivo.");
                                } catch (IOException e) {
                                    System.err.println("Error al escribir en el archivo: " + e.getMessage());
                                }
                                break;
                  
                            default :
                                System.out.println("La opcion ingresada es incorrecta");
                                break;
                                
                        }
                        System.out.println("====================================================================================================");
                        System.out.println("¿Desea repetir? Ingrese 's' para sí o cualquier otro caracter para no.");
                        respuesta=teclado.nextLine().toLowerCase();
                        // Actualiza contadorId después de eliminar un vehículo
                                for (int i = 0; i < vehiculosCargados.size(); i++) {
                                    vehiculosCargados.get(i).setId(i + 1);
                                }
                    }while(respuesta.equals("s"));
                    //se guardaron los dartos
                    try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(f))) {
                        out.writeObject(vehiculosCargados); // Escribe la lista completa de vehículos en el archivo
                        System.out.println("Datos de vehículos guardados en el archivo.");
                    } catch (IOException e) {
                        System.err.println("Error al escribir en el archivo: " + e.getMessage());
                    }


                    break;
                    
                    case 2:
                        System.out.println("ingrese 'v' si desea eliminar vehiculos que estan a la venta, 't' si desea quitar los que estan en el taller y ponerlo a la venta o cualquier otro caracter para salir:");
                        String opcionEliminar=teclado.next().toLowerCase();
                             // Cargar vehículos desde el archivo
                        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(f))) {
                            vehiculosCargados = (ArrayList<Vehiculo>) in.readObject();
                            System.out.println("Datos de vehículos cargados desde el archivo.");
                        } catch (IOException | ClassNotFoundException e) {
                            System.err.println("Error al leer desde el archivo: " + e.getMessage());
                        }
                        switch(opcionEliminar){
                            case "t":
                        boolean respu = true;
                        do {
                            System.out.println("=================================================================================");
                            System.out.println("Lista de vehículos que están en el taller");
                            System.out.println("(el vehículo se sacará del taller y se pondrá a la venta)");
                            
                            boolean hayVehiculosEnElTaller = false; // Variable para rastrear si hay vehículos en el taller
                    
                            for (Vehiculo vl : vehiculosCargados) {
                                if (vl.getEnTaller().equals("[EN EL TALLER]")) {
                                    System.out.println("ID: " + vl.getId());
                                    System.out.println("Marca: " + vl.getMarca());
                                    System.out.println("Modelo: " + vl.getModelo());
                                    System.out.println("Color: " + vl.getColor());
                                    System.out.println("Carrocería: " + vl.getCarroceria());
                                    System.out.println("Año: " + vl.getAno());
                                    System.out.println("Condición: " + vl.getEnTaller());
                                    System.out.println("====================================");
                                    hayVehiculosEnElTaller = true;
                                }
                            }
                    
                            if (!hayVehiculosEnElTaller) {
                                System.out.println("No hay vehículos en el taller");
                            } else {
                                try {
                                    System.out.println("Ingrese el ID del vehículo para sacarlo del taller ");
                    
                                    if (!teclado.hasNextInt()) {
                                        String entradaIncorrecta = teclado.next(); // Obtener la entrada incorrecta
                                        throw new EntradaInvalidaException("ingreso una id no valida", entradaIncorrecta);
                                    }
                                    int respId = teclado.nextInt();
                    
                                    Vehiculo vehiculoEliminar = null;
                    
                                    for (Vehiculo vehi : vehiculosCargados) {
                                        if (vehi.getId() == respId && vehi.getEnTaller().equals("[EN EL TALLER]")) {
                                            vehiculoEliminar = vehi;
                                            vehi.setEnTaller("[A LA VENTA]");
                                            break;
                                        }
                                    }
                    
                                    if (vehiculoEliminar != null) {
                                        vehiculoEliminar.setEnTaller("[A LA VENTA]");
                                        System.out.println("==================================================================================================");
                                        System.out.println("Vehículo con ID " + respId + " sacado del taller y puesto a la venta");
                                        System.out.println("===================================================================================================");
                                    } else {
                                        System.out.println("No se encontró ningún vehículo en el taller con el ID " + respId);
                                    }
                                } catch (java.util.InputMismatchException e) {
                                    System.out.println("Error de entrada: Ingrese un número entero válido.");
                                    teclado.nextLine(); // Limpia el búfer de entrada para evitar bucles infinitos
                                }
                    
                                // Guarda la lista actualizada en el archivo
                                try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(f))) {
                                    out.writeObject(vehiculosCargados); // Escribe la lista de vehículos actualizada en el archivo
                                    System.out.println("Datos de vehículos guardados en el archivo.");
                                } catch (IOException e) {
                                    System.err.println("Error al escribir en el archivo: " + e.getMessage());
                                }
                    
                                System.out.println("¿Desea sacar otro vehículo del taller? (Sí - 's', No - cualquier otra caracter)");
                                String respuestaEliminar = teclado.next().toLowerCase();
                    
                                if (respuestaEliminar.equalsIgnoreCase("s")) {
                                    respu = true;
                                } else {
                                    respu = false; // Salir del bucle si no desea sacar más vehículos del taller
                                }
                            }
                        } while (respu);
                        break;

                        
                            case "v":
                            respu = true;
                            do {
                                System.out.println("=================================================================================");
                                System.out.println("Lista de vehículos que están a la venta");
                        
                                boolean hayVehiculosAVenta = false; // Variable para rastrear si hay vehículos a la venta
                        
                                for (Vehiculo vl : vehiculosCargados) {
                                    if (vl.getEnTaller().equals("[A LA VENTA]")) {
                                        System.out.println("ID: " + vl.getId());
                                        System.out.println("Marca: " + vl.getMarca());
                                        System.out.println("Modelo: " + vl.getModelo());
                                        System.out.println("Color: " + vl.getColor());
                                        System.out.println("Carrocería: " + vl.getCarroceria());
                                        System.out.println("Año: " + vl.getAno());
                                        System.out.println("Condición: " + vl.getEnTaller());
                                        System.out.println("====================================");
                                        hayVehiculosAVenta = true;
                                    }
                                }
                        
                                if (!hayVehiculosAVenta) {
                                    System.out.println("No hay vehículos a la venta");
                                } else {
                                    try {
                                        System.out.println("Ingrese el ID del vehículo a eliminar ");
                        
                                        if (!teclado.hasNextInt()) {
                                            String entradaIncorrecta = teclado.next(); // Obtener la entrada incorrecta
                                            throw new EntradaInvalidaException("ingreso una id no valida", entradaIncorrecta);
                                        }
                        
                                        int respId = teclado.nextInt();
                                        Vehiculo vehiculoEliminar = null;
                        
                                        for (Vehiculo vehi : vehiculosCargados) {
                                            if (vehi.getId() == respId) {
                                                vehiculoEliminar = vehi;
                                                break;
                                            }
                                        }
                        
                                        if (vehiculoEliminar != null) {
                                            vehiculosCargados.remove(vehiculoEliminar); // Elimina el vehículo de la lista
                                            System.out.println("Vehículo con ID " + respId + " eliminado");
                        
                                            // Actualiza contadorId después de eliminar un vehículo
                                            for (int i = 0; i < vehiculosCargados.size(); i++) {
                                                vehiculosCargados.get(i).setId(i + 1);
                                            }
                                        } else {
                                            System.out.println("No se encontró ningún vehículo con el ID " + respId);
                                        }
                                    } catch (EntradaInvalidaException e) {
                                        System.out.println(e.getMessage());
                                        teclado.nextLine(); // Limpia el búfer de entrada para evitar bucles infinitos
                                    }
                        
                                    // Guarda la lista actualizada en el archivo
                                    try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(f))) {
                                        out.writeObject(vehiculosCargados); // Escribe la lista de vehículos actualizada en el archivo
                                        System.out.println("Datos de vehículos guardados en el archivo.");
                                    } catch (IOException e) {
                                        System.err.println("Error al escribir en el archivo: " + e.getMessage());
                                    }
                        
                                    System.out.println("¿Desea eliminar otro vehículo? (Sí - 's', No - cualquier otra caracter)");
                                    String respuestaEliminar = teclado.next().toLowerCase();
                        
                                    if (respuestaEliminar.equalsIgnoreCase("s")) {
                                        respu = true;
                                    } else {
                                        respu = false; // Salir del bucle si no desea eliminar más vehículos
                                    }
                                }
                            } while (respu);
                            break;
                        }
                     
                        case 3:
                            // Cargar datos existentes al inicio
                            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(f))) {
                                vehiculosCargados = (ArrayList<Vehiculo>) in.readObject();
                                System.out.println("Datos de vehículos cargados desde el archivo.");
                            } catch (IOException | ClassNotFoundException e) {
                                // Manejar la excepción si no hay datos existentes o hay un problema al cargarlos
                                System.err.println("No se pudieron cargar datos existentes: " + e.getMessage());
                            }

                            for (Vehiculo vl : vehiculosCargados) {
                                System.out.println("ID: " + vl.getId());
                                System.out.println("Marca: " + vl.getMarca());
                                System.out.println("Modelo: " + vl.getModelo());
                                System.out.println("Color: " + vl.getColor());
                                System.out.println("Carroceria: " + vl.getCarroceria());
                                System.out.println("Año: " + vl.getAno());
                                System.out.println("Condicion: "+vl.getEnTaller());
                                System.out.println("====================================");
 
                            }
                        
                         break;
                        case 4:
                            // Cargar datos existentes al inicio
                            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(f))) {
                                vehiculosCargados = (ArrayList<Vehiculo>) in.readObject();
                                System.out.println("Datos de vehículos cargados desde el archivo.");
                            } catch (IOException | ClassNotFoundException e) {
                                // Manejar la excepción si no hay datos existentes o hay un problema al cargarlos
                                System.err.println("No se pudieron cargar datos existentes: " + e.getMessage());
                            }
           
                            System.out.println("Datos de vehículos cargados desde el archivo.");
                            System.out.println("=================================================================================");
                            System.out.println("Lista de vehículos que están a la venta");
                            
                            boolean hayVehiculosALaVenta = false; // Variable para rastrear si hay vehículos a la venta
                            
                            for (Vehiculo vl : vehiculosCargados) {
                                if (vl.getEnTaller().equals("[A LA VENTA]")) {
                                    // Imprimir detalles de los vehículos que están a la venta
                                    System.out.println("ID: " + vl.getId());
                                    System.out.println("Marca: " + vl.getMarca());
                                    System.out.println("Modelo: " + vl.getModelo());
                                    System.out.println("Color: " + vl.getColor());
                                    System.out.println("Carrocería: " + vl.getCarroceria());
                                    System.out.println("Año: " + vl.getAno());
                                    System.out.println("Condición: " + vl.getEnTaller());
                                    System.out.println("====================================");
                            
                                    // Actualizar la variable indicando que hay vehículos a la venta
                                    hayVehiculosALaVenta = true;
                                }
                            }
                            
                            // Verificar si no hay vehículos a la venta y luego imprimir el mensaje
                            if (!hayVehiculosALaVenta) {
                                System.out.println("No hay vehículos a la venta");
                            }
                            break;
                            
                        case 5:
                            // Cargar datos existentes al inicio
                            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(f))) {
                                vehiculosCargados = (ArrayList<Vehiculo>) in.readObject();
                                System.out.println("Datos de vehículos cargados desde el archivo.");
                            } catch (IOException | ClassNotFoundException e) {
                                // Manejar la excepción si no hay datos existentes o hay un problema al cargarlos
                                System.err.println("No se pudieron cargar datos existentes: " + e.getMessage());
                            }
           
                            System.out.println("Datos de vehículos cargados desde el archivo.");
                            System.out.println("=================================================================================");
                            System.out.println("Lista de vehículos que están en el taller");
                            
                            boolean hayVehiculosEnElTaller = false; // Variable para rastrear si hay vehículos en el taller
                            
                            for (Vehiculo vl : vehiculosCargados) {
                                if (vl.getEnTaller().equals("[EN EL TALLER]")) {
                                    // Imprimir detalles de los vehículos que están en el taller
                                    System.out.println("ID: " + vl.getId());
                                    System.out.println("Marca: " + vl.getMarca());
                                    System.out.println("Modelo: " + vl.getModelo());
                                    System.out.println("Color: " + vl.getColor());
                                    System.out.println("Carrocería: " + vl.getCarroceria());
                                    System.out.println("Año: " + vl.getAno());
                                    System.out.println("Condición: " + vl.getEnTaller());
                                    System.out.println("====================================");
                            
                                    // Actualizar la variable indicando que hay vehículos en el taller
                                    hayVehiculosEnElTaller = true;
                                }
                            }
                            
                            // Verificar si no hay vehículos en el taller y luego imprimir el mensaje
                            if (!hayVehiculosEnElTaller) {
                                System.out.println("No hay vehículos en el taller");
                            }

                            break;
                                
                        case 6:
                            System.out.println("==============================================================================");
                            System.out.println("Salio del programa");
                            // Guarda la lista actualizada en el archivo
                            try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(f))) {
                                out.writeObject(vehiculosCargados); // Escribe la lista de vehículos actualizada en el archivo
                                System.out.println("Datos de vehículos guardados en el archivo.");
                            } catch (IOException e) {
                                System.err.println("Error al escribir en el archivo: " + e.getMessage());
                            }
                            
                            salir=true;
                         break;
                            
                        default:
                            System.out.println("ingreso un valor incorrecto, intentelo otra vez");
                         break;
                }
            } while (!salir);

        } catch (IOException ex) {
            Logger.getLogger(Concesionaria.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

