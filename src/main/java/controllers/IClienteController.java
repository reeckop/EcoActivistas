package controllers;

import java.util.List;
import models.Cliente;

/**
 *
 * @author Ricardo
 */
public interface IClienteController {
    boolean agregarCliente(String nombre,String direccion, String telefonos);
    Cliente obtenerPorID(int idCliente);
    List<Cliente> obtenerTodos();
    boolean actualizarCliente(Cliente cliente);
    boolean eliminarCliente(int idCliente);
}
