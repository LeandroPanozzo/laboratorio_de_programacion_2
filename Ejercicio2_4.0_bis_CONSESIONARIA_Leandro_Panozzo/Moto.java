

import java.io.Serializable;

public class Moto extends Vehiculo implements Serializable {
    public enum Marcas {
        UNO_ZANELLA, DOS_GUERRERO, TRES_MONDIAL
    }

    public enum Modelo {
        UNO_COMBUSTION, DOS_HIBRIDO, TRES_ELECTRICO
    }

    public enum Color {
        UNO_AZUL, DOS_ROJO, TRES_GRIS, CUATRO_BLANCO
    }

    public enum Carroceria {
        UNO_DEPORTIVA, DOS_SCOOTER, TRES_CHOPER, CUATRO_ENDURO
    }

    
    
}
