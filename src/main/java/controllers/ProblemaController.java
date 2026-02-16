/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import daos.IProblemaDAO;
import daos.ProblemaDAO;
import java.util.ArrayList;
import java.util.List;
import models.Problema;

/**
 *
 * @author omarb
 */
public class ProblemaController implements IProblemaController{
    
    private final IProblemaDAO problemaDAO;

    public ProblemaController() {
        this.problemaDAO = new ProblemaDAO();
    }
    
    
    
    @Override
    public boolean insertarProblema(Problema problema) {
        
        if (problema.getEstado() == null || problema.getEstado().trim().isEmpty()) {
            return false;
        }
        
        if (problema.getFch_inicio()==null) {
            return false;
        }
        
        if (problema.getIdCliente()<0){
            return false;
        }
        
        return problemaDAO.insertar(problema);
    }

    @Override
    public Problema obtenerPorID(int idProblema) {
        if (idProblema < 0) {
            return null;
        }
        
        return problemaDAO.obtenerPorID(idProblema);
    }

    @Override
    public List<Problema> obtenerTodos() {
        List<Problema> problemasLista = new ArrayList<>();
        
        problemasLista = problemaDAO.obtenerTodos();
        
        if (problemasLista.isEmpty()) {
            return null;
        }
        
        return problemasLista;
    }

    @Override
    public boolean actualizarProblema(Problema problema) {
        if (problema.getEstado() == null || problema.getEstado().trim().isEmpty()) {
            return false;
        }
        
        if (problema.getFch_inicio()==null) {
            return false;
        }
        
        if (problema.getIdCliente()<0){
            return false;
        }
        return problemaDAO.actualizarProblema(problema);
    }

    @Override
    public boolean eliminarProblema(int idProblema) {
        if (idProblema < 0) {
            return false;
        }
        return problemaDAO.eliminarProblema(idProblema);
    }

    @Override
    public boolean finalizarProblema(int idProblema) {
        if (idProblema < 0) {
            return false;
        }
        return problemaDAO.finalizarProblema(idProblema);
    }
}
