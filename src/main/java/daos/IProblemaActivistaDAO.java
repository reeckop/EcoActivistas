/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package daos;

import java.util.List;
import models.ProblemaActivista;

/**
 *
 * @author daya
 */
public interface IProblemaActivistaDAO  {
    boolean insertar(ProblemaActivista problemaActivista);

    ProblemaActivista obtenerPorID(int idProblema, int idActivista);

    List<ProblemaActivista> obtenerTodos();

    boolean eliminar(int idProblema, int idActivista);
}
