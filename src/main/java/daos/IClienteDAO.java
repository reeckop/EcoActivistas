package daos;

import java.util.List;
import models.Cliente;

/**
 *
 * @author Ricardo
 */
public interface IClienteDAO {
    boolean insertar(Cliente cliente);
    Cliente obtenerPorID(int idCliente);
    List<Cliente> obtenerTodos();
    boolean actualizarCliente(Cliente cliente);
    boolean eliminarCliente(int idCliente);
}
