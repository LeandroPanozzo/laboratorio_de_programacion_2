
import java.util.InputMismatchException;

public class EntradaInvalidaException extends InputMismatchException {

    private String entradaIncorrecta;

    public EntradaInvalidaException() {
        super("Error de entrada: La entrada no es válida.");
    }

    public EntradaInvalidaException(String mensaje, String entradaIncorrecta) {
        super(mensaje);
        this.entradaIncorrecta = entradaIncorrecta;
    }

    public String getEntradaIncorrecta() {
        return entradaIncorrecta;
    }
}
