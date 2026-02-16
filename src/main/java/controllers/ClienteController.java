package controllers;

import daos.ClienteDAO;
import models.Cliente;
import daos.IClienteDAO;

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
    
}
