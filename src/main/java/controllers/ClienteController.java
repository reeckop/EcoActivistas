package controllers;

import daos.ClienteDAO;
import models.Cliente;
import daos.IClienteDAO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ricardo
 */
public class ClienteController implements IClienteController {
    
    private final IClienteDAO clienteDAO;
    
    public ClienteController() {
        this.clienteDAO = new ClienteDAO();
    }
    
    @Override
    public boolean agregarCliente(String nombre, String direccion, String telefonos) {
        if (nombre == null || nombre.trim().isEmpty()) {
            return false;
        }
        if (direccion == null || direccion.trim().isEmpty()) {
            return false;
        }
        if (telefonos == null || telefonos.trim().isEmpty()) {
            return false;
        }
        
        return this.clienteDAO.insertar(new Cliente(nombre, direccion, telefonos));
    }

    @Override
    public Cliente obtenerPorID(int idCliente) {
        if (idCliente<0) {
            return null;
        }
        return clienteDAO.obtenerPorID(idCliente);
    }

    @Override
    public List<Cliente> obtenerTodos() {
        List<Cliente> listaClientes = new ArrayList<>();
        listaClientes = clienteDAO.obtenerTodos();
        
        if (listaClientes.isEmpty()) {
            return null;
        }
        
        return listaClientes;
    }

    @Override
    public boolean actualizarCliente(Cliente cliente) {
        return clienteDAO.actualizarCliente(cliente);
    }

    @Override
    public boolean eliminarCliente(int idCliente) {
        if (idCliente<0) {
            return false;
        }
        return clienteDAO.eliminarCliente(idCliente);
    }
    
}
