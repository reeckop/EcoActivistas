/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package daos;

import java.util.List;
import models.Problema;

/**
 *
 * @author jalt2
 */
public interface IProblemaDAO {
    boolean insertar(Problema problema);
    Problema obtenerPorID(int idProblema);
    List<Problema> obtenerTodos();
    boolean actualizarProblema(Problema problema);
    boolean eliminarProblema(int idProblema);
    boolean finalizarProblema(int idProblema);
}
