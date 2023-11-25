

import java.io.Serializable;


public class Auto extends Vehiculo implements Serializable {
    public enum Marcas {
        UNO_TOYOTA, DOS_CHEVROLET, TRES_FORD
    }

    public enum Modelo {
        UNO_COMBUSTION, DOS_HIBRIDO, TRES_ELECTRICO
    }

    public enum Color {
        UNO_AZUL, DOS_ROJO, TRES_GRIS, CUATRO_BLANCO
    }

    public enum Carroceria {
        UNO_FAMILIAR, DOS_HATCHBACK, TRES_SUV, CUATRO_COUPE, CINCO_PICKUP
    }

    
}
