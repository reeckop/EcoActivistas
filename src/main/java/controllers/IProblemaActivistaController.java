/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package controllers;

import java.util.List;
import models.ProblemaActivista;

/**
 *
 * @author omarb
 */
public interface IProblemaActivistaController {
    public boolean asignarActivistaAProblema(int idProblema, int idActivista);
    public boolean eliminarRelacion(int idProblema, int idActivista);
    
    boolean insertar(ProblemaActivista problemaActivista);

    ProblemaActivista obtenerPorID(int idProblema, int idActivista);

    List<ProblemaActivista> obtenerTodos();

    boolean eliminar(int idProblema, int idActivista);
}
