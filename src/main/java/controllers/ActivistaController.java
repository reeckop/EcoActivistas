package controllers;

import daos.ActivistaDAO;
import daos.IActivistaDAO;
import models.Activista;

/**
 *
 * @author Ricardo
 */
public class ActivistaController {
    private final IActivistaDAO activistaDAO;

    public ActivistaController() {
        this.activistaDAO = new ActivistaDAO();
    }

    public boolean agregarActivista(String nombre, String correo, String telefono) {
        if (nombre == null || nombre.trim().isEmpty() || 
            correo == null || !correo.contains("@")) {
            return false;
        }
        return this.activistaDAO.insertar(new Activista(nombre, correo, telefono));
    }
}
