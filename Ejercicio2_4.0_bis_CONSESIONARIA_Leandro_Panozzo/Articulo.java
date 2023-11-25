
import java.io.Serializable;


public interface Articulo extends Serializable{
    boolean disponible (String disp);
    int km(int kilometraje);
}
