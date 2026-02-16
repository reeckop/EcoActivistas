package daos;

import java.util.List;
import models.Activista;

/**
 *
 * @author Ricardo
 */
public interface IActivistaDAO {
    boolean insertar(Activista activista);
    Activista obtenerPorID(int idActivista);
    List<Activista> obtenerTodos();
    boolean actualizar(Activista activista);
    boolean eliminar(int idActivista);
}