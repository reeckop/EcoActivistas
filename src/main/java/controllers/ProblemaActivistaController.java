/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import daos.IProblemaActivistaDAO;
import daos.IProblemaDAO;
import daos.ProblemaActivistaDAO;
import daos.ProblemaDAO;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import models.ProblemaActivista;

/**
 *
 * @author daya
 */
public class ProblemaActivistaController implements IProblemaActivistaController {

    private final IProblemaActivistaDAO problemaActivistaDAO;

    public ProblemaActivistaController() {
        this.problemaActivistaDAO = new ProblemaActivistaDAO();
    }

    @Override
    public boolean asignarActivistaAProblema(int idProblema, int idActivista) {

        if (idProblema <= 0) return false;
        if (idActivista <= 0) return false;

        ProblemaActivista pa = new ProblemaActivista(idProblema, idActivista);
        return this.problemaActivistaDAO.insertar(pa);
    }

    @Override
    public boolean eliminarRelacion(int idProblema, int idActivista) {

        if (idProblema < 0) return false;
        if (idActivista < 0) return false;

        return this.problemaActivistaDAO.eliminar(idProblema, idActivista);
    }

    @Override
    public boolean insertar(ProblemaActivista problemaActivista) {
        if (problemaActivista.getIdActivista()<0||problemaActivista.getIdProblema()<0) {
            return false;
        }
        return problemaActivistaDAO.insertar(problemaActivista);
    }

    @Override
    public ProblemaActivista obtenerPorID(int idProblema, int idActivista) {
        if (idProblema<0||idActivista<0) {
            return null;
        }
        return problemaActivistaDAO.obtenerPorID(idProblema, idActivista);
    }

    @Override
    public List<ProblemaActivista> obtenerTodos() {
        List<ProblemaActivista> listaProblemasActivistas = new ArrayList<>();
        listaProblemasActivistas= problemaActivistaDAO.obtenerTodos();
        
        if (listaProblemasActivistas.isEmpty()) {
            return null;
        }
        
        return listaProblemasActivistas;
    }

    @Override
    public boolean eliminar(int idProblema, int idActivista) {
        if (idProblema<0||idActivista<0) {
            return false;
        }
        return problemaActivistaDAO.eliminar(idProblema, idActivista);
    }
}


    