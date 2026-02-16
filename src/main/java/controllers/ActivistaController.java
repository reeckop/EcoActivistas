package controllers;

import daos.ActivistaDAO;
import daos.IActivistaDAO;
import java.util.ArrayList;
import java.util.List;
import models.Activista;

/**
 *
 * @author Ricardo
 */
public class ActivistaController implements IActivistaController{
    private final IActivistaDAO activistaDAO;

    public ActivistaController() {
        this.activistaDAO = new ActivistaDAO();
    }

    @Override
    public boolean agregarActivista(String nombre, String correo, String telefono) {
        if (nombre == null || nombre.trim().isEmpty() || 
            correo == null || !correo.contains("@")) {
            return false;
        }
        return this.activistaDAO.insertar(new Activista(nombre, correo, telefono));
    }

    @Override
    public Activista obtenerPorID(int idActivista) {
        if (idActivista<0) {
            return null;
            
        }
        return activistaDAO.obtenerPorID(idActivista);
    }

    @Override
    public List<Activista> obtenerTodos() {
        List<Activista> listaActivistas = new ArrayList<>();
        listaActivistas = activistaDAO.obtenerTodos();
        
        if (listaActivistas.isEmpty()) {
            return null;
        }
        
        return listaActivistas;
    }

    @Override
    public boolean actualizar(Activista activista) {
        if (activista.getId()<0) {
            return false;
        }
        return activistaDAO.eliminar(activista.getId());
    }

    @Override
    public boolean eliminar(int idActivista) {
        if (idActivista<0) {
            return false;
        }
        return activistaDAO.eliminar(idActivista);
    }
}
